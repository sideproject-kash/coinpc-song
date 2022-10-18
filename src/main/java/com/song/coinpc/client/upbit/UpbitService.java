package com.song.coinpc.client.upbit;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.song.coinpc.client.CoinMarketService;
import com.song.coinpc.client.dto.CoinInfo;
import com.song.coinpc.client.dto.CoinInfos;
import com.song.coinpc.common.enums.MarketType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpbitService implements CoinMarketService {

    private final UpbitClient upbitClient;

    @Override
    public CoinInfos findCoinInfos() {

        List<String> markets = Arrays.stream(MarketType.values())
                                     .map(MarketType::getCode)
                                     .collect(Collectors.toList());

        Map<MarketType, CoinInfo> coinInfoMap = upbitClient.getPriceInfo(markets)
                                                           .stream()
                                                           .collect(Collectors.toMap(
                                                               it -> MarketType.from(it.getMarket()),
                                                               CoinInfo::from));

        return CoinInfos.builder()
                        .coinInfoMap(coinInfoMap)
                        .build();
    }
}
