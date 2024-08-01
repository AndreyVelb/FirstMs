package com.velb.FirstMs.services.kafka;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaListenerServiceImpl implements KafkaListenerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaListenerServiceImpl.class);

    @KafkaListener(topics = "first-topic", groupId = "group-id")
    public void consume(String message) {
        logger.info(message);
    }
}