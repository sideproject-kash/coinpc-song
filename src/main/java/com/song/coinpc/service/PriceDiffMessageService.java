package com.song.coinpc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.song.coinpc.client.MessageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class PriceDiffMessageService {

    private final MessageService lineMessageService;

    public void sendPriceDiffMessage(List<String> messages) {

        StringBuilder sb = new StringBuilder();

        messages.forEach(it -> {
            sb.append(it);
            sb.append('\n');
            sb.append('\n');
        });

        lineMessageService.sendMessage(List.of(sb.toString()));
    }
}
