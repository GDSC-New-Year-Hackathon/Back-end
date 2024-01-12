package com.eureuni.eureunibe.domain.omok.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OmokResponse {
    private Long omokId;
    private Long userId;
    private Integer x;
    private Integer y;
}
