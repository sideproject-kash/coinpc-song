package com.song.coinpc.client.upbit.utils;

import com.song.coinpc.common.enums.MarketType;
import com.song.coinpc.common.enums.PaymentCurrencyType;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UpbitUtils {

    public static String makeUpbitMarketStr(PaymentCurrencyType currencyType, MarketType marketType) {
        return currencyType.getCode() + '-' + marketType.getCode();
    }
}
