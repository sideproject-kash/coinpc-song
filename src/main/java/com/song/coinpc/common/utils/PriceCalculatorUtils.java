package com.song.coinpc.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class PriceCalculatorUtils {

    /**
     * 1 - (target / base)
     */
    public static BigDecimal calculateDiffPercentage(BigDecimal amount1, BigDecimal amount2) {

        BigDecimal base = amount1;
        BigDecimal target = amount2;

        if (base.compareTo(target) < 0) {
            base = amount2;
            target = amount1;
        }

        return BigDecimal.ONE.subtract(target.divide(base, RoundingMode.DOWN));
    }
}
