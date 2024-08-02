package com.velb.FirstMs.services.kafka;

import com.velb.FirstMs.model.dto.SaveFirstEntityDto;

public interface KafkaListenerService {

    void consume(SaveFirstEntityDto dto);
}
