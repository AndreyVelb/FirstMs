package com.velb.FirstMs.services.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.velb.FirstMs.controllers.dto.SaveSecondEntityRequest;
import com.velb.FirstMs.model.dto.SaveSecondEntityDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    @Autowired
    private Producer<String, String> producer;

    private final ObjectMapper objectMapper;

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerServiceImpl.class);

    @Value(value = "${cluster.kafka.topic.second-topic}")
    private String secondTopic;

    public void publishMessage(SaveSecondEntityRequest request) throws JsonProcessingException {
        logger.info("FIRST_MS PUBLISHING TO SECOND-TOPIC");

        var value = objectMapper.writeValueAsString(new SaveSecondEntityDto(request.getMessage(), request.getNumber()));
        producer.send(new ProducerRecord<>(secondTopic, value));
    }
}
