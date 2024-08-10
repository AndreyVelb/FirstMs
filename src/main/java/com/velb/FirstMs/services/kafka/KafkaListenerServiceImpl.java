package com.velb.FirstMs.services.kafka;

import com.velb.FirstMs.model.dto.SaveFirstEntityDto;
import com.velb.FirstMs.model.entity.FirstEntity;
import com.velb.FirstMs.repositories.FirstEntityRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaListenerServiceImpl implements KafkaListenerService {

    private final FirstEntityRepository firstEntityRepository;

    private static final Logger logger = LoggerFactory.getLogger(KafkaListenerServiceImpl.class);

    @KafkaListener(topics = "first-topic", groupId = "group-id",
            properties = {"spring.json.value.default.type=com.velb.FirstMs.model.dto.SaveFirstEntityDto"})
    public void consume(SaveFirstEntityDto dto) {
        logger.info("SAVING FIRST_ENTITY IN DB");
        firstEntityRepository.save(
                FirstEntity.builder()
                        .lastName(dto.getLastName())
                        .firstName(dto.getFirstName())
                        .phoneNumber(dto.getPhoneNumber())
                        .build());
    }
}
