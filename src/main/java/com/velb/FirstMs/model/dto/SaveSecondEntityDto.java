package com.velb.FirstMs.model.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class SaveSecondEntityDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String message;
    private int number;
}
