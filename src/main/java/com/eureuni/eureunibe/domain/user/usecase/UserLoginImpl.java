package com.eureuni.eureunibe.domain.user.usecase;

import com.eureuni.eureunibe.domain.user.domain.User;
import com.eureuni.eureunibe.domain.user.exception.PasswordNotMatchException;
import com.eureuni.eureunibe.domain.user.exception.UserNotFoundException;
import com.eureuni.eureunibe.domain.user.repository.UserRepository;
import com.eureuni.eureunibe.global.jwt.JwtProvider;
import com.eureuni.eureunibe.global.jwt.presentation.JwtResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserLoginImpl implements UserLogin {

    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public JwtResponse execute(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new PasswordNotMatchException();
        }

        String accessToken = jwtProvider.generateToken(user.getUserId(), user.getEmail(), false);
        String refreshToken = jwtProvider.generateToken(user.getUserId(), user.getEmail(), true);
        return new JwtResponse(accessToken, refreshToken);
    }
}
