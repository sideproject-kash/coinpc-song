package com.song.coinpc.client.dto;

import java.util.Map;

import com.song.coinpc.common.enums.MarketType;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CoinInfos {

    private Map<MarketType, CoinInfo> coinInfoMap; // key: Market Code
}
