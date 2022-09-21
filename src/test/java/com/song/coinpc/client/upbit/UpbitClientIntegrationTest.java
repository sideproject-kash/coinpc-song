package com.song.coinpc.client.upbit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.song.coinpc.client.upbit.dto.MarketInfo;
import com.song.coinpc.client.upbit.dto.PriceInfo;
import com.song.coinpc.client.upbit.dto.PriceInfos;

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
        List<PriceInfo> priceInfos = upbitClient.getPriceInfo(List.of("KRW-BTC", "BTC-ETH"));

        log.info("test : {}", priceInfos.get(0).toString());
        log.info("test : {}", priceInfos.get(1).toString());

    }

}