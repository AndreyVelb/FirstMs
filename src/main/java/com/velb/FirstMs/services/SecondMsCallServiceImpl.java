package com.velb.FirstMs.services;

import com.velb.FirstMs.controllers.dto.SaveSecondEntityRequest;
import com.velb.FirstMs.controllers.dto.SaveSecondEntityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class SecondMsCallServiceImpl implements SecondMsCallService{

    @Autowired
    private final RestTemplate restTemplate;

    @Value("${cluster.secondms.host}")
    private String SECOND_MS_HOST;

    @Value("${cluster.secondms.port}")
    private String SECOND_MS_PORT;

    @Value("${cluster.secondms.url}")
    private String SECOND_MS_URL;

    @Override
    public SaveSecondEntityResponse saveInSecondTable(SaveSecondEntityRequest request) {
        return restTemplate.postForEntity(
                createSecondMsBaseUrl() + "/entities", request, SaveSecondEntityResponse.class).getBody();
    }

    private String createSecondMsBaseUrl() {
        return "http://" + SECOND_MS_HOST + ":" + SECOND_MS_PORT + SECOND_MS_URL;
    }
}
