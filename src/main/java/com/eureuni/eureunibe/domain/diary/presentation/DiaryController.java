package com.eureuni.eureunibe.domain.diary.presentation;

import com.eureuni.eureunibe.domain.diary.domain.Diary;
import com.eureuni.eureunibe.domain.diary.dto.DiaryRequest;
import com.eureuni.eureunibe.domain.diary.dto.DiaryResponse;
import com.eureuni.eureunibe.domain.diary.usecase.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
                .memberId(createDiary.getUserId().getUserId())
                .title(createDiary.getTitle())
                .content(createDiary.getContent())
                .build();

        return ResponseEntity.ok(response);

    }

    @GetMapping
    public ResponseEntity<List<DiaryResponse>> getAllDiary() {
        List<DiaryResponse> response = diaryService.getAllDiary()
                .stream().map(diary -> DiaryResponse.builder()
                        .memberId(diary.getUserId().getUserId())
                        .title(diary.getTitle())
                        .content(diary.getContent())
                        .build()).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{diaryId}")
    public ResponseEntity<DiaryResponse.getDiaryResponse> getDiary(@PathVariable Long diaryId) {

        Optional<Diary> diary = diaryService.getDiary(diaryId);
        DiaryResponse.getDiaryResponse response = DiaryResponse.getDiaryResponse.builder()
                .title(diary.get().getTitle())
                .content(diary.get().getContent())
                .build();

        return ResponseEntity.ok(response);
    }
}
