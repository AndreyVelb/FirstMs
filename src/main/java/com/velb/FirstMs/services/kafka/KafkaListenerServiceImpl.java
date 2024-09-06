package com.velb.FirstMs.services.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.velb.FirstMs.model.dto.SaveFirstEntityDto;
import com.velb.FirstMs.model.entity.FirstEntity;
import com.velb.FirstMs.repositories.FirstEntityRepository;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaListenerServiceImpl implements KafkaListenerService {

    private final FirstEntityRepository firstEntityRepository;
    private final ObjectMapper objectMapper;

    private static final Logger logger = LoggerFactory.getLogger(KafkaListenerServiceImpl.class);

    @KafkaListener(topics = "first-topic", groupId = "group-id")
    public void consume(ConsumerRecord<String,String> record) throws JsonProcessingException {

        SaveFirstEntityDto dto = objectMapper.readValue(record.value(), SaveFirstEntityDto.class);
        logger.info("SAVING FIRST_ENTITY IN DB");

        var entity = new FirstEntity();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPhoneNumber(dto.getPhoneNumber());

        firstEntityRepository.save(entity);
    }
}
