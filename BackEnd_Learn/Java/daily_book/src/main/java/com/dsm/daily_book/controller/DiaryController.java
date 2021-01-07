package com.dsm.daily_book.controller;

import com.dsm.daily_book.dto.DiaryDTO;
import com.dsm.daily_book.service.diary.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;

    @PostMapping("/diary")
    public void write(@RequestBody DiaryDTO.write request){
        diaryService.write(request);
    }

    @GetMapping("/diary")
    public DiaryDTO.date writeDays(){
        return diaryService.writeDay();
    }

    @GetMapping("/day")
    public Date date(){
        return new Date();
    }


}
