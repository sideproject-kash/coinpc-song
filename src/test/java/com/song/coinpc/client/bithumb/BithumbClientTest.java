package com.song.coinpc.client.bithumb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class BithumbClientTest {

    @Autowired
    private BithumbClient bithumbClient;

    @Test
    void getPriceInfo() {
        String priceInfo = bithumbClient.getPriceInfo("BTC", "KRW");
        log.info("test {}", priceInfo);
    }
}
