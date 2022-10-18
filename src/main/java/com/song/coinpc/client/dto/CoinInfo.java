package com.song.coinpc.client.dto;

import java.math.BigDecimal;

import com.song.coinpc.client.upbit.dto.UpbitPriceInfo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CoinInfo {

    private BigDecimal tradePrice;

    private BigDecimal tradeVolume;

    public static CoinInfo from(UpbitPriceInfo upbitPriceInfo) {
        return builder().tradePrice(upbitPriceInfo.getTradePrice())
                        .tradeVolume(upbitPriceInfo.getTradeVolume())
                        .build();
    }

}
