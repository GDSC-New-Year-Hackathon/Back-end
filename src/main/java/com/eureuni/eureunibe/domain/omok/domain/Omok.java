package com.eureuni.eureunibe.domain.omok.domain;

import com.eureuni.eureunibe.domain.shared.entity.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Omok extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long omokId;

    @Column(nullable = false)
    private Long userId;

    @Column
    @Max(5)
    private Integer x;

    @Column
    @Max(5)
    private Integer y;
}
