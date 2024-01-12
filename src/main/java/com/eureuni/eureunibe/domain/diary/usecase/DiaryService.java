package com.eureuni.eureunibe.domain.diary.usecase;

import com.eureuni.eureunibe.domain.diary.domain.Diary;
import com.eureuni.eureunibe.domain.diary.dto.DiaryRequest;

public interface DiaryService {

    Diary createDiary(DiaryRequest request, Long userId);
}
