package com.dsm.daily_book.dto.request;

import com.dsm.daily_book.entity.diary.Mood;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class DiaryDTO {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class write{
        private String subject;
        private String content;
        private Mood mood;
    }
}
