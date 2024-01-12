package com.eureuni.eureunibe.domain.diary.usecase;

import com.eureuni.eureunibe.domain.diary.domain.Diary;
import com.eureuni.eureunibe.domain.diary.dto.DiaryRequest;
import com.eureuni.eureunibe.domain.diary.repository.DiaryRepository;
import com.eureuni.eureunibe.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService {

    public final UserRepository userRepository;
    public final DiaryRepository diaryRepository;
    @Override
    @Transactional
    public Diary createDiary(DiaryRequest request, Long userId) {

        Diary diary = Diary.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        diary.setUserId(userRepository.findById(userId).get());

        return diaryRepository.save(diary);

    }

    public List<Diary> getAllDiary() {
        return diaryRepository.findAll();
    }

    public Optional<Diary> getDiary(Long diaryId) {
        return diaryRepository.findById(diaryId);
    }
}
