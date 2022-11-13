package com.song.coinpc.client;

import com.song.coinpc.client.dto.CoinInfos;
import com.song.coinpc.common.enums.CoinClientType;

public interface CoinMarketService {

    CoinInfos findCoinInfos();

    CoinClientType getCoinClientType();
}
