package com.eureuni.eureunibe.domain.user.domain;

import com.eureuni.eureunibe.domain.shared.entity.BaseTimeEntity;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"User\"")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Email
    @Column(nullable = false)
    private String email;

    @Column
    private String password;

    @Column
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private String birth;

    @Column
    private String state;

    @Column
    private Long point;

    @Column
    private LocalDateTime deletedAt;

    @PreDestroy
    public void preDestroy() {
        this.deletedAt = LocalDateTime.now();
    }
}