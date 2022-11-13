package com.song.coinpc.client.line.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LineBroadcastMessageRequest {

    private List<PushMessage> messages;

    @Getter
    @Builder
    public static class PushMessage {
        private String type;
        private String text;
    }
}
