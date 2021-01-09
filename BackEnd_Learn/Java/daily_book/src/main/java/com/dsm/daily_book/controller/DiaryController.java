package com.dsm.daily_book.controller;

import com.dsm.daily_book.dto.DiaryDTO;
import com.dsm.daily_book.service.diary.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/diary/{date}")
    public DiaryDTO.diary load(@PathVariable("date") Date date){
        return diaryService
    }

    @GetMapping("/day")
    public Date date(){
        return new Date();
    }


}
