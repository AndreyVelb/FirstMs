package com.velb.FirstMs.controllers.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SaveSecondEntityResponse {

    private Long id;
    private LocalDateTime callTime;
}
