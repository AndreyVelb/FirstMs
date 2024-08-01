package com.velb.FirstMs.services.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private static final String TOPIC = "second-topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
