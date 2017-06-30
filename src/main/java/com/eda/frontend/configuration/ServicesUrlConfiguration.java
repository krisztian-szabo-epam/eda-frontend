package com.eda.frontend.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/service-locations.properties")
@ConfigurationProperties
public class ServicesUrlConfiguration {

    private String userRegistration;

    public String getUserRegistration() {
        return userRegistration;
    }

    public void setUserRegistration(String userRegistration) {
        this.userRegistration = userRegistration;
    }

}
