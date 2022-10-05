package com.song.coinpc.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MarketType {
    BTC("BTC"),
    ETC("ETC")
    ;

    private final String code;
}
