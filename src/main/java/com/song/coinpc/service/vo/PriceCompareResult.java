package com.song.coinpc.service.vo;

import java.math.BigDecimal;

import com.song.coinpc.client.dto.CoinInfo;
import com.song.coinpc.common.enums.CoinClientType;
import com.song.coinpc.common.enums.MarketType;
import com.song.coinpc.common.enums.PaymentCurrencyType;
import com.song.coinpc.common.utils.PriceCalculatorUtils;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PriceCompareResult {

    private static final BigDecimal DIFF_STANDARD = new BigDecimal("0.1");

    private MarketType marketType;

    private PaymentCurrencyType paymentCurrencyType;

    private BigDecimal diffPercentage; // ex) 0.01

    private MarketPriceInfo smallerPriceMarketInfo;

    private MarketPriceInfo biggerPriceMarketInfo;

    public boolean isBigDiff() {
        return DIFF_STANDARD.compareTo(diffPercentage) < 0;
    }

    public static PriceCompareResult from(MarketType marketType, PaymentCurrencyType paymentCurrencyType, CoinInfo upbitCoinInfo, CoinInfo bithumbCoinInfo) {
        MarketPriceInfo upbitMarketPriceInfo = MarketPriceInfo.from(CoinClientType.UPBIT, upbitCoinInfo);
        MarketPriceInfo bithumbMarketPriceInfo = MarketPriceInfo.from(CoinClientType.BITHUMB, bithumbCoinInfo);

        boolean isBithumbBigger = upbitCoinInfo.getTradePrice().compareTo(bithumbCoinInfo.getTradePrice()) < 0;
        return builder().marketType(marketType)
                        .paymentCurrencyType(paymentCurrencyType)
                        .diffPercentage(PriceCalculatorUtils.calculateDiffPercentage(upbitCoinInfo.getTradePrice(), bithumbCoinInfo.getTradePrice()))
                        .biggerPriceMarketInfo(isBithumbBigger ? bithumbMarketPriceInfo : upbitMarketPriceInfo)
                        .smallerPriceMarketInfo(isBithumbBigger ? upbitMarketPriceInfo : bithumbMarketPriceInfo)
                        .build();
    }

    @Getter
    @Builder
    private static class MarketPriceInfo {

        private CoinClientType coinClientType;

        private BigDecimal tradePrice;

        private BigDecimal tradeVolume;

        public static MarketPriceInfo from(CoinClientType coinClientType, CoinInfo coinInfo) {
            return builder().coinClientType(coinClientType)
                            .tradePrice(coinInfo.getTradePrice())
                            .tradeVolume(coinInfo.getTradeVolume())
                            .build();
        }
    }
}
