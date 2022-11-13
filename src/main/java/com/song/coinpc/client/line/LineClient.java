package com.song.coinpc.client.line;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.song.coinpc.client.line.dto.LineBroadcastMessageRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LineClient {

    private static final String PUSH_MESSAGE_URL = "/v2/bot/message/broadcast";

    //TODO: remove
    private static final String ACCESS_TOKEN = "xxxx";

    private final WebClient lineWebClient;

    public String sendPushMessage(LineBroadcastMessageRequest request) {

        return lineWebClient.post()
                            .uri(PUSH_MESSAGE_URL)
                            .headers(h -> h.setBearerAuth(ACCESS_TOKEN))
                            .bodyValue(request)
                            .retrieve()
                            .bodyToMono(String.class)
                            .block();
    }
}
