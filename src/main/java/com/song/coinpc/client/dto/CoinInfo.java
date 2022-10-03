package com.song.coinpc.client.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CoinInfo {

    private String market;

    private String tradeDateKst;

    private String tradeTimeKst;

    private BigDecimal tradePrice;

    private BigDecimal tradeVolume;

}
