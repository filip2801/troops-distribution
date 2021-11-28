package com.filip2801.goodgame.troopsdistribution

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class IntegrationTestConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate()
    }
}
