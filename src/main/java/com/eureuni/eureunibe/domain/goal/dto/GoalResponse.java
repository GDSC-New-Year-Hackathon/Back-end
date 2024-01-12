package com.eureuni.eureunibe.domain.goal.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class GoalResponse {
    private Long goalId;
    private Long userId;
    private String goal;
    private String description;
    private Integer limitNumber;
    private LocalDateTime startDate;
    private Integer period;
}