package com.velb.FirstMs.controllers.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveFirstEntityRequest {

    private String firstName;
    private String lastName;
    private String phoneNumber;
}
