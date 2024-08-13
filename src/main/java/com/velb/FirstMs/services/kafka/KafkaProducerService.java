package com.velb.FirstMs.services.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.velb.FirstMs.controllers.dto.SaveSecondEntityRequest;

public interface KafkaProducerService {

    void publishMessage(SaveSecondEntityRequest request) throws JsonProcessingException;
}
