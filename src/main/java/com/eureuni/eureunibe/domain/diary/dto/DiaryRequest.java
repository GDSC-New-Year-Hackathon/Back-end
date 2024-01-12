package com.eureuni.eureunibe.domain.diary.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DiaryRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

}
