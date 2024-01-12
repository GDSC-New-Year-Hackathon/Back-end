package com.eureuni.eureunibe.domain.user.usecase;

import com.eureuni.eureunibe.global.jwt.presentation.JwtResponse;

public interface UserLogin {
    JwtResponse execute(String email, String password);
}
