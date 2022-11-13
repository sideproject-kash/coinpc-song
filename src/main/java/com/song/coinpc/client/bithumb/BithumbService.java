package com.song.coinpc.client.bithumb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.song.coinpc.client.CoinMarketService;
import com.song.coinpc.client.bithumb.dto.BithumbPriceInfo;
import com.song.coinpc.client.bithumb.dto.BithumbPriceInfos;
import com.song.coinpc.client.bithumb.dto.BithumbResponse;
import com.song.coinpc.client.dto.CoinInfo;
import com.song.coinpc.client.dto.CoinInfos;
import com.song.coinpc.client.upbit.utils.UpbitUtils;
import com.song.coinpc.common.enums.CoinClientType;
import com.song.coinpc.common.enums.MarketType;
import com.song.coinpc.common.enums.PaymentCurrencyType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BithumbService implements CoinMarketService {

    private final BithumbClient bithumbClient;

    @Override
    public CoinInfos findCoinInfos() {

        BithumbResponse<BithumbPriceInfos> allPriceInfo = bithumbClient.getAllPriceInfo(PaymentCurrencyType.KRW);

        if (!"0000".equals(allPriceInfo.getStatus())) { // TODO: fix to ENUM
            throw new RuntimeException("bithumb response error");
        }

        Map<String, BithumbPriceInfo> bithumbPriceInfoMap = allPriceInfo.getData().getBithumbPriceInfoMap();

        Map<MarketType, CoinInfo> coinInfoMap = bithumbPriceInfoMap.keySet()
                                                                   .stream().map(MarketType::from)
                                                                   .filter(it -> it != MarketType.NOT_KNOWN)
                                                                   .collect(Collectors.toMap(type -> type,
                                                                                             type -> CoinInfo.from(
                                                                                                 bithumbPriceInfoMap.get(
                                                                                                     type.getCode()))));

        return CoinInfos.builder()
                        .coinInfoMap(coinInfoMap)
                        .build();
    }

    @Override
    public CoinClientType getCoinClientType() {
        return CoinClientType.BITHUMB;
    }
}
