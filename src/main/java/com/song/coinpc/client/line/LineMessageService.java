package com.song.coinpc.client.line;

import org.springframework.stereotype.Service;

import com.song.coinpc.client.MessageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class LineMessageService implements MessageService {

    @Override
    public void sendMessage(String message) {
        log.info("send message: {}", message);
    }
}
