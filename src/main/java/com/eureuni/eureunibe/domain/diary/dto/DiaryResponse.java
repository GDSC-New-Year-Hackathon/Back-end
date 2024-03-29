package com.eureuni.eureunibe.domain.diary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DiaryResponse {


    Long memberId;

    String title;

    String content;


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getDiaryResponse {
        String title;
        String content;
    }
}
