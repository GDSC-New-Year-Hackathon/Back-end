package com.eureuni.eureunibe.domain.user.presentation;

import com.eureuni.eureunibe.domain.user.dto.LoginRequest;
import com.eureuni.eureunibe.domain.user.dto.SignupRequest;
import com.eureuni.eureunibe.domain.user.usecase.UserLogin;
import com.eureuni.eureunibe.domain.user.usecase.UserSignup;
import com.eureuni.eureunibe.global.jwt.presentation.JwtResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserLogin userLogin;
    private final UserSignup userSignup;

    @PostMapping(value = "/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest) throws Exception {
        JwtResponse jwt = userLogin.execute(loginRequest.getEmail(), loginRequest.getPassword());
        return new ResponseEntity<>(Map.of("message", "로그인이 성공했습니다."), HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody SignupRequest signupRequest) throws Exception {
        JwtResponse jwt = userSignup.execute(signupRequest.getEmail(), signupRequest.getPassword(), signupRequest.getNickname());
        return new ResponseEntity<>(Map.of("message", "회원가입이 성공했습니다."), HttpStatus.OK);
    }
}