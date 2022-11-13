package com.song.coinpc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.song.coinpc.service.PriceCompareCompositeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PriceCompareController {

    private final PriceCompareCompositeService priceCompareCompositeService;

    @GetMapping("coin/compare")
    public void compareCoinPrice() {
        priceCompareCompositeService.compareAndNotice();
    }
}
