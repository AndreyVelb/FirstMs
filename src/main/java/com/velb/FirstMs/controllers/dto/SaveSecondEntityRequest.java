package com.velb.FirstMs.controllers.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveSecondEntityRequest {

    private String message;
    private int number;
}
