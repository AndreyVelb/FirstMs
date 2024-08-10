package com.velb.FirstMs.services.kafka;

import com.velb.FirstMs.controllers.dto.SaveSecondEntityRequest;

public interface KafkaProducerService {

    void publishMessage(SaveSecondEntityRequest request);
}
