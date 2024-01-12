package com.eureuni.eureunibe.domain.omok.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OmokRequest {
    private Long userId;
    private Integer x;
    private Integer y;
}