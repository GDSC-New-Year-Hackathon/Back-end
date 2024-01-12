package com.eureuni.eureunibe.domain.user.usecase;

import com.eureuni.eureunibe.global.jwt.presentation.JwtResponse;

public interface UserSignup {
    JwtResponse execute(String email, String password, String nickname);
}
