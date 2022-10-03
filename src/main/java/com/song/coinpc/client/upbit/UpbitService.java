package com.song.coinpc.client.upbit;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.song.coinpc.client.CoinMarketService;
import com.song.coinpc.client.dto.CoinInfos;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpbitService implements CoinMarketService {

    private final UpbitClient upbitClient;

    @Override
    public CoinInfos findCoinInfos() {
        return null;
//        return upbitClient.getPriceInfo(); TODO: fix
    }
}
