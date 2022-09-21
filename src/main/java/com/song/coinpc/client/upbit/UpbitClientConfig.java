package com.song.coinpc.client.upbit;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class UpbitClientConfig {

    private static final String UPBIT_BASE_URL = "https://api.upbit.com";

    @Bean
    public WebClient upbitWebClient() {
        return WebClient
                .builder()
                .baseUrl(UPBIT_BASE_URL)
                .defaultHeader("accept", "application/json")
                .build();
    }
}
