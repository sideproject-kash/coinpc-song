package com.song.coinpc.common.utils;

import com.song.coinpc.service.vo.PriceCompareResult;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class MessageUtils {

    public static String makeMessage(PriceCompareResult priceCompareResult) {
        return String.format("마켓: %s, 가격차이: %s, %s가격: %s, %s가격: %s",
                             priceCompareResult.getMarketType(),
                             priceCompareResult.getDiffPercentage(),
                             priceCompareResult.getBiggerPriceMarketInfo().getCoinClientType(),
                             priceCompareResult.getBiggerPriceMarketInfo().getTradePrice(),
                             priceCompareResult.getSmallerPriceMarketInfo().getCoinClientType(),
                             priceCompareResult.getSmallerPriceMarketInfo().getTradePrice());
    }
}
