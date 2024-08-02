package com.velb.FirstMs.services.kafka;

import com.velb.FirstMs.controllers.dto.SaveSecondEntityRequest;
import com.velb.FirstMs.model.dto.SaveSecondEntityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private static final String TOPIC = "second-topic";

    @Autowired
    private KafkaTemplate<String, SaveSecondEntityDto> kafkaTemplate;

    public void publishMessage(SaveSecondEntityRequest request) {
        kafkaTemplate.send(
                TOPIC,
                SaveSecondEntityDto.builder()
                        .message(request.getMessage())
                        .number(request.getNumber())
                        .build());
    }
}
