package com.eureuni.eureunibe.domain.user.dto;

import com.eureuni.eureunibe.domain.user.domain.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long userId;
    private String email;
    private String nickname;
    private Gender gender;
    private String birth;
    private String state;
    private Long point;
    private String accessToken;
}
