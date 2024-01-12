package com.eureuni.eureunibe.domain.diary.presentation;

import com.eureuni.eureunibe.domain.diary.domain.Diary;
import com.eureuni.eureunibe.domain.diary.dto.DiaryRequest;
import com.eureuni.eureunibe.domain.diary.dto.DiaryResponse;
import com.eureuni.eureunibe.domain.diary.usecase.DiaryService;
import com.eureuni.eureunibe.domain.goal.dto.GoalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diary")
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping
    public ResponseEntity<DiaryResponse> createDiary(@RequestBody DiaryRequest request, @RequestParam Long userId) {

        Diary createDiary = diaryService.createDiary(request, userId);
        DiaryResponse response = DiaryResponse.builder()
                .memberId(userId)
                .title(createDiary.getTitle())
                .content(createDiary.getContent())
                .build();

        return ResponseEntity.ok(response);

    }

    @GetMapping
    public ResponseEntity<List<DiaryResponse>> getAllDiary() {
        List<DiaryResponse> response = diaryService.getAllDiary()
                .stream().map(diary -> DiaryResponse.builder()
                        .title(diary.getTitle())
                        .content(diary.getContent())
                        .build()).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
