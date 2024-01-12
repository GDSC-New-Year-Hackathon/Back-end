package com.eureuni.eureunibe.domain.user.dto;

import com.eureuni.eureunibe.domain.user.domain.Gender;
import jakarta.validation.constraints.NotBlank;

public class UserInfoRequest {
    @NotBlank
    private Gender gender;

    @NotBlank
    private String birth;

    @NotBlank
    private String state;
}
