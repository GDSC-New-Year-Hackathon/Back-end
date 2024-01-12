package com.eureuni.eureunibe.domain.goal.presentation;

import com.eureuni.eureunibe.domain.goal.application.GoalService;
import com.eureuni.eureunibe.domain.goal.domain.Goal;
import com.eureuni.eureunibe.domain.goal.dto.CreateGoalRequest;
import com.eureuni.eureunibe.domain.goal.dto.GoalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/goal")
public class GoalController {
    private final GoalService goalService;

    @PostMapping
    public ResponseEntity<GoalResponse> createGoal(@RequestBody CreateGoalRequest request) {
        Goal goal = Goal.builder()
                .userId(request.getUserId())
                .goal(request.getGoal())
                .description(request.getDescription())
                .limitNumber(request.getLimitNumber())
                .startDate(request.getStartDate())
                .period(request.getPeriod())
                .build();

        Goal createdGoal = goalService.createGoal(goal);
        GoalResponse response = GoalResponse.builder()
                .goalId(createdGoal.getGoalId())
                .userId(createdGoal.getUserId())
                .goal(createdGoal.getGoal())
                .description(createdGoal.getDescription())
                .limitNumber(createdGoal.getLimitNumber())
                .startDate(createdGoal.getStartDate())
                .period(createdGoal.getPeriod())
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<GoalResponse>> getAllGoals() {
        List<GoalResponse> response = goalService.getAllGoals().stream().map(goal -> GoalResponse.builder()
                .goalId(goal.getGoalId())
                .userId(goal.getUserId())
                .goal(goal.getGoal())
                .description(goal.getDescription())
                .limitNumber(goal.getLimitNumber())
                .startDate(goal.getStartDate())
                .period(goal.getPeriod())
                .build()).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
