package com.velb.FirstMs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@EnableCaching
public class FirstMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstMsApplication.class, args);
	}

}
