package com.song.coinpc.common.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class PriceCalculatorUtilsTest {

    @Test
    void calculateDiffPercentage() {

        BigDecimal bigDecimal = PriceCalculatorUtils.calculateDiffPercentage(new BigDecimal("500"),
                                                                             new BigDecimal("500"));
        System.out.println("bigDecimal: " + bigDecimal);
    }
}