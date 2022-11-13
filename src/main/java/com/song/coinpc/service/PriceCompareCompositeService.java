package com.song.coinpc.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.song.coinpc.common.utils.MessageUtils;
import com.song.coinpc.service.vo.PriceCompareResult;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class PriceCompareCompositeService {

    private final PriceCompareService priceCompareService;
    private final PriceDiffMessageService priceDiffMessageService;

    public void compareAndNotice() {
        List<PriceCompareResult> priceCompareResults = priceCompareService.compareAllMarketPrice();

        log.info("price compare result: {}", priceCompareResults);

        List<String> messages = priceCompareResults.stream()
                                                   .filter(PriceCompareResult::isBigDiff)
                                                   .map(MessageUtils::makeMessage)
                                                   .collect(Collectors.toList());

        priceDiffMessageService.sendPriceDiffMessage(messages);
    }
}
