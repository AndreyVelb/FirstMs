package com.velb.FirstMs.controllers;

import com.velb.FirstMs.controllers.dto.SaveFirstEntityRequest;
import com.velb.FirstMs.controllers.dto.SaveSecondEntityRequest;
import com.velb.FirstMs.controllers.dto.SaveSecondEntityResponse;
import com.velb.FirstMs.services.firstentity.FirstEntityService;
import com.velb.FirstMs.services.kafka.KafkaProducerService;
import com.velb.FirstMs.services.secondmscall.SecondMsCallServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/first")
@RequiredArgsConstructor
public class FirstMsController {

    private final SecondMsCallServiceImpl secondMsCallServiceImpl;
    private final FirstEntityService firstEntityService;
    private final KafkaProducerService kafkaProducerService;
    private static final Logger logger = LoggerFactory.getLogger(FirstMsController.class);

    @PostMapping("/entities")
    @ResponseStatus(HttpStatus.CREATED)
    public Long saveFirstEntity(@RequestBody SaveFirstEntityRequest request) {
        logger.info("First ms was called");
        return firstEntityService.save(request);
    }

    @PostMapping("/call-second")
    @ResponseStatus(HttpStatus.CREATED)
    public SaveSecondEntityResponse callSecondMs(@RequestBody SaveSecondEntityRequest request) {
        logger.info("First ms call second ms");
        return secondMsCallServiceImpl.saveInSecondTable(request);
    }

    @PostMapping("/send-second-topic")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendToSecondTopic(@RequestBody SaveSecondEntityRequest request) {
        logger.info("First ms sending message to second kafka topic");
        kafkaProducerService.publishMessage(request);
    }
}
