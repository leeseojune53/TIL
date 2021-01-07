package com.dsm.daily_book.dto;

import com.dsm.daily_book.entity.diary.Mood;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class DiaryDTO {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class write{
        private String subject;
        private String content;
        private int mood;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class load{
        private String subject;
        private String content;
        private int mood;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class date{
        private List<Integer> date;
    }

}
