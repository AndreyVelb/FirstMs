package com.velb.FirstMs.services.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaListenerService {

    void consume(ConsumerRecord<String, String> dto) throws JsonProcessingException;
}
