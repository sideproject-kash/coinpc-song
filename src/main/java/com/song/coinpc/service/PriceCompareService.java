package com.song.coinpc.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.song.coinpc.client.CoinMarketService;
import com.song.coinpc.client.dto.CoinInfo;
import com.song.coinpc.client.dto.CoinInfos;
import com.song.coinpc.common.enums.CoinClientType;
import com.song.coinpc.common.enums.MarketType;
import com.song.coinpc.common.enums.PaymentCurrencyType;
import com.song.coinpc.service.vo.PriceCompareResult;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriceCompareService {

    private final List<CoinMarketService> coinMarketServiceList;
    private Map<CoinClientType, CoinMarketService> coinMarketServiceMap;

    @PostConstruct
    public void init() {
        coinMarketServiceMap = coinMarketServiceList.stream().collect(Collectors.toMap(CoinMarketService::getCoinClientType, it -> it));
    }

    public List<PriceCompareResult> compareAllMarketPrice() {

        CoinInfos bithumbCoinInfos = coinMarketServiceMap.get(CoinClientType.BITHUMB).findCoinInfos();
        CoinInfos upbitCoinInfos = coinMarketServiceMap.get(CoinClientType.UPBIT).findCoinInfos();

        return getPriceCompareResult(bithumbCoinInfos, upbitCoinInfos);

    }

    private List<PriceCompareResult> getPriceCompareResult(CoinInfos bithumbCoinInfos,
                                                           CoinInfos upbitCoinInfos) {
        return Arrays.stream(MarketType.values())
                     .filter(marketType -> bithumbCoinInfos.getCoinInfoMap()
                                                           .containsKey(marketType))
                     .filter(marketType -> upbitCoinInfos.getCoinInfoMap()
                                                         .containsKey(marketType))
                     .map(marketType -> {
                         CoinInfo bithumbCoinInfo = bithumbCoinInfos.getCoinInfoMap().get(marketType);
                         CoinInfo upbitCoinInfo = upbitCoinInfos.getCoinInfoMap().get(marketType);

                         return PriceCompareResult.from(marketType, PaymentCurrencyType.KRW, upbitCoinInfo,
                                                        bithumbCoinInfo);
                     })
                     .collect(Collectors.toList());
    }

}
