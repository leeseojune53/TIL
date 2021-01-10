package com.dsm.daily_book.service.diary;

import com.dsm.daily_book.dto.DiaryDTO;
import com.dsm.daily_book.entity.diary.Diary;

import java.util.List;

public interface DiaryService {
    void write(DiaryDTO.write request);
    DiaryDTO.date writeDay();
    List<DiaryDTO.diary> findDay(DiaryDTO.loadDate request);
}
