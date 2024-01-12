package com.eureuni.eureunibe.domain.user.usecase;

import com.eureuni.eureunibe.domain.user.domain.Gender;
import com.eureuni.eureunibe.domain.user.domain.User;
import com.eureuni.eureunibe.domain.user.exception.EmailDuplicateException;
import com.eureuni.eureunibe.domain.user.exception.PasswordInvalidException;
import com.eureuni.eureunibe.domain.user.repository.UserRepository;
import com.eureuni.eureunibe.global.jwt.JwtProvider;
import com.eureuni.eureunibe.global.jwt.presentation.JwtResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignupImpl implements UserSignup {
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public JwtResponse execute(String email, String password, String nickname, Gender gender) throws EmailDuplicateException, PasswordInvalidException {
        if (userRepository.existsByEmail(email)) {
            throw new EmailDuplicateException();
        }

        User user = User.builder()
                .email(email)
                .nickname(nickname)
                .gender(gender)
                .password(passwordEncoder.encode(password))
                .build();

        userRepository.save(user);

        String accessToken = jwtProvider.generateToken(user.getUserId(), user.getEmail(), false);
        String refreshToken = jwtProvider.generateToken(user.getUserId(), user.getEmail(), true);
        return new JwtResponse(accessToken, refreshToken);
    }
}
