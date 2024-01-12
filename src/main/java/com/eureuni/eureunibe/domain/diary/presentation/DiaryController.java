package com.eureuni.eureunibe.domain.diary.presentation;

import com.eureuni.eureunibe.domain.diary.domain.Diary;
import com.eureuni.eureunibe.domain.diary.dto.DiaryRequest;
import com.eureuni.eureunibe.domain.diary.dto.DiaryResponse;
import com.eureuni.eureunibe.domain.diary.usecase.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
