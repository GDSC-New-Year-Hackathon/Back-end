package com.eureuni.eureunibe.domain.omok.application;

import com.eureuni.eureunibe.domain.goal.domain.Goal;
import com.eureuni.eureunibe.domain.omok.domain.Omok;
import com.eureuni.eureunibe.domain.omok.repository.OmokRepository;
import com.eureuni.eureunibe.domain.user.domain.User;
import com.eureuni.eureunibe.domain.user.exception.UserNotFoundException;
import com.eureuni.eureunibe.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OmokService {
    private final OmokRepository omokRepository;
    private final UserRepository userRepository;

    public Omok playOmok(Omok omok) {
        User user = userRepository.findByUserId(omok.getUserId())
                .orElseThrow(UserNotFoundException::new);
        return omokRepository.save(omok);
    }
}
