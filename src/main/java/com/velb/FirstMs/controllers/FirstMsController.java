package com.velb.FirstMs.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.velb.FirstMs.controllers.dto.SaveFirstEntityRequest;
import com.velb.FirstMs.controllers.dto.SaveSecondEntityRequest;
import com.velb.FirstMs.controllers.dto.SaveSecondEntityResponse;
import com.velb.FirstMs.model.dto.FirstEntityDto;
import com.velb.FirstMs.model.entity.FirstEntity;
import com.velb.FirstMs.services.firstentity.FirstEntityService;
import com.velb.FirstMs.services.kafka.KafkaProducerService;
import com.velb.FirstMs.services.secondmscall.SecondMsCallServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/first")
@RequiredArgsConstructor
public class FirstMsController {

    private final SecondMsCallServiceImpl secondMsCallServiceImpl;
    private final FirstEntityService firstEntityService;
    private final KafkaProducerService kafkaProducerService;
    private static final Logger logger = LoggerFactory.getLogger(FirstMsController.class);

    @GetMapping("/entities")
    @ResponseStatus(HttpStatus.OK)
    public List<FirstEntityDto> getAllEntities() {
        logger.info("GET ALL FIRST_ENTITY");
        return firstEntityService.getAll();
    }

    @PostMapping("/entities")
    @ResponseStatus(HttpStatus.CREATED)
    public Long saveFirstEntity(@RequestBody SaveFirstEntityRequest request) {
        logger.info("SAVE FIRST_ENTITY");
        return firstEntityService.save(request).getId();
    }

    @GetMapping("/entities/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FirstEntityDto getEntityById(@PathVariable Long id) {
        logger.info("GET FIRST_ENTITY BY ID=" + id);
        return firstEntityService.getById(id);
    }

    @DeleteMapping("/entities/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEntityById(@PathVariable Long id) {
        logger.info("DELETE FIRST_ENTITY BY ID=" + id);
        firstEntityService.deleteById(id);
    }

    @PostMapping("/call-second")
    @ResponseStatus(HttpStatus.CREATED)
    public SaveSecondEntityResponse callSecondMs(@RequestBody SaveSecondEntityRequest request) {
        logger.info("FIRST_MS CALL SECOND_MS");
        return secondMsCallServiceImpl.saveInSecondTable(request);
    }

    @PostMapping("/send-second-topic")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendToSecondTopic(@RequestBody SaveSecondEntityRequest request) throws JsonProcessingException {
        kafkaProducerService.publishMessage(request);
    }
}
