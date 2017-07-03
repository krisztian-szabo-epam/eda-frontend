package com.eda.frontend.features.registration.service;

import com.eda.frontend.configuration.ServicesUrlConfiguration;
import com.eda.frontend.features.registration.domain.UserRegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RegistrationService {

    @Autowired
    private ServicesUrlConfiguration config;

    private final RestTemplate client;

    public RegistrationService(RestTemplateBuilder restTemplateBuilder) {
        client = restTemplateBuilder.build();
    }

    public void send(UserRegistrationModel userRegistrationData) {
        client.postForLocation(config.getUserRegistration(), userRegistrationData);
    }

}
