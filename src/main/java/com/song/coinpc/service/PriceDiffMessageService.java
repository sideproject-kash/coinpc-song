package com.song.coinpc.service;

import org.springframework.stereotype.Service;

import com.song.coinpc.service.vo.PriceCompareResult;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class PriceDiffMessageService {

    public void sendPriceDiffMessage(PriceCompareResult priceCompareResult) {
        log.info("sendPriceDiffMessage: {}", priceCompareResult);
    }
}
