package com.eureuni.eureunibe.domain.goal.application;

import com.eureuni.eureunibe.domain.goal.domain.Goal;
import com.eureuni.eureunibe.domain.goal.repository.GoalRepository;
import com.eureuni.eureunibe.domain.user.domain.User;
import com.eureuni.eureunibe.domain.user.exception.UserNotFoundException;
import com.eureuni.eureunibe.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GoalService {
    private final GoalRepository goalRepository;
    private final UserRepository userRepository;

    public Goal createGoal(Goal goal) {
        User user = userRepository.findByUserId(goal.getUserId())
                .orElseThrow(UserNotFoundException::new);
        return goalRepository.save(goal);
    }

    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }
}
