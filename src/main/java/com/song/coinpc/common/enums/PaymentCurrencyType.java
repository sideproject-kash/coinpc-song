package com.song.coinpc.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PaymentCurrencyType {
    KRW("KRW"),
    BTC("BTC")
    ;

    private final String code;
}
