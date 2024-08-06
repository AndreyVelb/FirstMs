package com.velb.FirstMs.services.kafka;

import com.velb.FirstMs.controllers.dto.SaveSecondEntityRequest;
import com.velb.FirstMs.model.dto.SaveSecondEntityDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, SaveSecondEntityDto> kafkaTemplate;

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerServiceImpl.class);

    @Value(value = "${cluster.kafka.topic.second-topic}")
    private String secondTopic;

    public void publishMessage(SaveSecondEntityRequest request) {
        logger.info("FIRST_MS PUBLISHING TO SECOND-TOPIC");
        kafkaTemplate.send(secondTopic, new SaveSecondEntityDto(request.getMessage(), request.getNumber()));
    }
}
