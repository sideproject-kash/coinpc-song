package com.song.coinpc.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.song.coinpc.service.vo.PriceCompareResult;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PriceCompareCompositeService {

    private final PriceCompareService priceCompareService;
    private final PriceDiffMessageService priceDiffMessageService;

    public void compareAndNotice() {
        List<PriceCompareResult> priceCompareResults = priceCompareService.compareAllMarketPrice();

        priceCompareResults.stream()
            .filter(PriceCompareResult::isBigDiff)
            .forEach(priceDiffMessageService::sendPriceDiffMessage);
    }
}
