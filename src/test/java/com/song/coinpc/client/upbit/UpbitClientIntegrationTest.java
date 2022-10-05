package com.song.coinpc.client.upbit;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.song.coinpc.client.upbit.dto.MarketInfo;
import com.song.coinpc.client.upbit.dto.UpbitPriceInfo;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class UpbitClientIntegrationTest {

    @Autowired
    private UpbitClient upbitClient;

    @Test
    void getMarketCodes() {
        List<MarketInfo> marketInfos = upbitClient.getMarketCodes();

        for (MarketInfo marketInfo : marketInfos) {
            log.info("market {}", marketInfo);
        }

        marketInfos.stream().filter(it -> !"NONE".equals(it.getMarketWarning())).forEach(
                it -> log.info("CAUTION {}", it));
    }

    @Test
    void getPriceInfo() {
        List<UpbitPriceInfo> upbitPriceInfos = upbitClient.getPriceInfo(List.of("KRW-BTC", "BTC-ETH"));

        log.info("test : {}", upbitPriceInfos.get(0).toString());
        log.info("test : {}", upbitPriceInfos.get(1).toString());

    }

}