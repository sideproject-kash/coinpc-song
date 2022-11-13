package com.song.coinpc.client.dto;

import java.math.BigDecimal;

import com.song.coinpc.client.bithumb.dto.BithumbPriceInfo;
import com.song.coinpc.client.upbit.dto.UpbitPriceInfo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

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

    public static CoinInfo from(BithumbPriceInfo bithumbPriceInfo) {
        return builder().tradePrice(bithumbPriceInfo.getClosingPrice())
                        .tradeVolume(bithumbPriceInfo.getAccTradeValue())
                        .build();
    }
}
