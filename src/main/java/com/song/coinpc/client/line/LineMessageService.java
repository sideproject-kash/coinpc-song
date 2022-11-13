package com.song.coinpc.client.line;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.song.coinpc.client.MessageService;
import com.song.coinpc.client.line.dto.LineBroadcastMessageRequest;
import com.song.coinpc.client.line.dto.LineBroadcastMessageRequest.PushMessage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class LineMessageService implements MessageService {

    private final LineClient lineClient;

    @Override
    public void sendMessage(List<String> messages) {

        List<PushMessage> pushMessages = messages.stream()
                                                 .map(it -> PushMessage.builder()
                                                                       .type("text")
                                                                       .text(it)
                                                                       .build())
                                                 .collect(Collectors.toList());

        lineClient.sendPushMessage(
            LineBroadcastMessageRequest.builder()
                                       .messages(pushMessages)
                                       .build());
    }
}
