package com.song.coinpc.client.dto;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CoinInfos {

    private Map<String, CoinInfo> coinInfoMap; // key: Market Code
}
