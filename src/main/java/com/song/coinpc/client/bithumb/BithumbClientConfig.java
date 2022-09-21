package com.song.coinpc.client.bithumb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BithumbClientConfig {

    private static final String BITHUMB_BASE_URL = "https://api.bithumb.com";

    @Bean
    public WebClient bithumbWebClient() {
        return WebClient
                .builder()
                .baseUrl(BITHUMB_BASE_URL)
                .defaultHeader("accept", "application/json")
                .build();
    }
}
