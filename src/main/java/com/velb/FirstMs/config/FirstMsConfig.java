package com.velb.FirstMs.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableTransactionManagement
public class FirstMsConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${spring.kafka.consumer.group-id}")
    private String groupId;

    @Value(value = "${cluster.kafka.topic.first-topic}")
    private String firstTopic;

    @Value(value = "${cluster.kafka.topic.second-topic}")
    private String secondTopic;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public NewTopic firstTopic() {
        return TopicBuilder.name(firstTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic secondTopic() {
        return TopicBuilder.name(secondTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
