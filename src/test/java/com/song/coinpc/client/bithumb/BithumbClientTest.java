package com.song.coinpc.client.bithumb;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.song.coinpc.client.bithumb.dto.BithumbPriceInfo;
import com.song.coinpc.client.bithumb.dto.BithumbPriceInfos;
import com.song.coinpc.client.bithumb.dto.BithumbResponse;
import com.song.coinpc.common.enums.MarketType;
import com.song.coinpc.common.enums.PaymentCurrencyType;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class BithumbClientTest {

    @Autowired
    private BithumbClient bithumbClient;

    @Test
    void getPriceInfo() {
        BithumbResponse<BithumbPriceInfo> priceInfo = bithumbClient.getPriceInfo(MarketType.BTC,
                                                                                 PaymentCurrencyType.KRW);
        log.info("test {}", priceInfo);
    }

    @Test
    void getAllPriceInfo() {
        BithumbResponse<BithumbPriceInfos> allPriceInfo = bithumbClient.getAllPriceInfo(
            PaymentCurrencyType.KRW);
        log.info("test {}", allPriceInfo);
    }
}
