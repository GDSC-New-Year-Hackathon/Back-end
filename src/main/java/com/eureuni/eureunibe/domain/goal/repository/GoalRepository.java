package com.eureuni.eureunibe.domain.goal.repository;

import com.eureuni.eureunibe.domain.goal.domain.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {
}
