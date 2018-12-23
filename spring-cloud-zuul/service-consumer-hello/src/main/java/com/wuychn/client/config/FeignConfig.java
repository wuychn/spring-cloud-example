package com.wuychn.client.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class FeignConfig {

    @Bean
    public Retryer reignRetryer() {
        return new Retryer.Default(100, SECONDS.toMillis(1), 5);
    }
}
