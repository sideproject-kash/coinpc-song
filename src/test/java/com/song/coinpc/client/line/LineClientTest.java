package com.song.coinpc.client.line;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.song.coinpc.client.line.dto.LineBroadcastMessageRequest;
import com.song.coinpc.client.line.dto.LineBroadcastMessageRequest.PushMessage;

@SpringBootTest
class LineClientTest {

    @Autowired
    private LineClient lineClient;

    @Test
    void sendPushMessage() {
        LineBroadcastMessageRequest request = LineBroadcastMessageRequest.builder()
                                                                         .messages(List.of(PushMessage.builder()
                                                                                            .type("text")
                                                                                            .text("test text")
                                                                                            .build()))
                                                                         .build();
        lineClient.sendPushMessage(request);
    }
}