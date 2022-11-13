package com.song.coinpc.client.line;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class LineClientConfig {

    private static final String LINE_BASE_URL = "https://api.line.me";

    @Bean
    public WebClient lineWebClient() {
        return WebClient.builder()
                        .baseUrl(LINE_BASE_URL)
                        .defaultHeader("accept", "application/json")
                        .build();
    }
}
