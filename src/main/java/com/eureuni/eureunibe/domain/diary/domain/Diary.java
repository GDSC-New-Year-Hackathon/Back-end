package com.eureuni.eureunibe.domain.diary.domain;

import com.eureuni.eureunibe.domain.shared.entity.BaseTimeEntity;
import com.eureuni.eureunibe.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Diary extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_id")
    private Long diaryId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @Column
    private String title;

    @Column
    private String content;

}
