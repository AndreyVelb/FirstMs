package com.velb.FirstMs.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveFirstEntityDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private String phoneNumber;
}
