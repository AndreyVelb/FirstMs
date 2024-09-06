package com.velb.FirstMs.model.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.io.Serializable;

@Data
@Builder
public class FirstEntityDto implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
