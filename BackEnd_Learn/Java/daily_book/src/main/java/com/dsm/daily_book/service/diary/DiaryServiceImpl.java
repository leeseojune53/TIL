package com.dsm.daily_book.service.diary;

import com.dsm.daily_book.dto.DiaryDTO;
import com.dsm.daily_book.entity.diary.Diary;
import com.dsm.daily_book.entity.diary.DiaryRepository;
import com.dsm.daily_book.entity.diary.Mood;
import com.dsm.daily_book.entity.user.UserRepository;
import com.dsm.daily_book.exception.user.UserNotFoundException;
import com.dsm.daily_book.security.jwt.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class DiaryServiceImpl implements DiaryService{
    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;
    private final AuthenticationFacade authenticationFacade;

    @Override
    public void write(DiaryDTO.write request) {
        String email = authenticationFacade.getUser().getEmail();
        try{
            userRepository.findByEmail(email)
                    .map(user ->
                        diaryRepository.save(
                                Diary.builder()
                                        .subject(request.getSubject())
                                        .content(request.getContent())
                                        .mood(Mood.value(request.getMood()))
                                        .writer(user)
                                        .build()
                        )
                    ).orElseThrow(UserNotFoundException::new);
        }catch (Exception e){
            throw new UserNotFoundException();
        }
        log.info("Write Diary email : " + email + " Subject : " + request.getSubject());

    }

    @Override
    @Transactional
    public DiaryDTO.date writeDay() {
        List<Diary> diaries = authenticationFacade.getUser().getDiaries();
        Calendar calendar = Calendar.getInstance();
        int i;
        for(i=0;i<diaries.size();i++){
            if(diaries.get(i).getWriteDate().getMonth() != calendar.get(Calendar.MONTH))
                break;
        }
        List<Integer> date = new ArrayList<>();
        for(int j=0;j<i;j++){
            date.add(diaries.get(j).getWriteDate().getDate());
        }
        return new DiaryDTO.date(date);
    }
}
