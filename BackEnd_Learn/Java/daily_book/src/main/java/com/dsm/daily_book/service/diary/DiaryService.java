package com.dsm.daily_book.service.diary;

import com.dsm.daily_book.dto.DiaryDTO;

public interface DiaryService {
    void write(DiaryDTO.write request);
    DiaryDTO.date writeDay();
}
