package com.eureuni.eureunibe.domain.omok.presentation;

import com.eureuni.eureunibe.domain.omok.application.OmokService;
import com.eureuni.eureunibe.domain.omok.domain.Omok;
import com.eureuni.eureunibe.domain.omok.dto.OmokRequest;
import com.eureuni.eureunibe.domain.omok.dto.OmokResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/omok")
public class OmokController {
    private final OmokService omokService;

    @PostMapping
    public ResponseEntity<OmokResponse> playOmok(@RequestBody OmokRequest request) {
        Omok omok = Omok.builder()
                .userId(request.getUserId())
                .x(request.getX())
                .y(request.getY())
                .build();

        Omok playOmok = omokService.playOmok(omok);
        OmokResponse response = OmokResponse.builder()
                .omokId(playOmok.getOmokId())
                .userId(playOmok.getUserId())
                .x(playOmok.getX())
                .y(playOmok.getY())
                .build();

        return ResponseEntity.ok(response);
    }
}
