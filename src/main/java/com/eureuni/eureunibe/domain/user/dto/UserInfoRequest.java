package com.eureuni.eureunibe.domain.user.dto;

import com.eureuni.eureunibe.domain.user.domain.Gender;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoRequest {
    @NotBlank
    private Gender gender;

    @NotBlank
    private String birth;

    @NotBlank
    private String state;
}
