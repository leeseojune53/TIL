package com.dsm.daily_book.service.diary;

import com.dsm.daily_book.dto.request.DiaryDTO;

public interface DiaryService {
    void write(DiaryDTO.write request);
}
