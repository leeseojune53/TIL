package com.dsm.daily_book.controller;

import com.dsm.daily_book.dto.request.DiaryDTO;
import com.dsm.daily_book.entity.diary.DiaryRepository;
import com.dsm.daily_book.service.diary.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;

    @PostMapping("/diary")
    public void write(@RequestBody DiaryDTO.write request){
        diaryService.write(request);
    }
}
