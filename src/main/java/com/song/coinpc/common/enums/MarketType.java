package com.song.coinpc.common.enums;

import java.util.Arrays;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MarketType {
    BTC("BTC"),
    ETC("ETC"),
    NOT_KNOWN("NOT_KNOWN")
    ;

    private final String code;

    public static MarketType from(String code) {

        return Arrays.stream(values())
                     .filter(it -> it.getCode().equals(code))
                     .findFirst()
                     .orElse(NOT_KNOWN);
    }
}
