package com.eureuni.eureunibe.domain.diary.repository;

import com.eureuni.eureunibe.domain.diary.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
