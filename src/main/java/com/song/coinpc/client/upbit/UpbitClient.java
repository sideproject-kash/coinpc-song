package com.song.coinpc.client.upbit;

import java.util.List;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.song.coinpc.client.upbit.dto.MarketInfo;
import com.song.coinpc.client.upbit.dto.UpbitPriceInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpbitClient {

    private final WebClient upbitWebClient;

    public List<MarketInfo> getMarketCodes() {
        return upbitWebClient.get()
                             .uri(uriBuilder -> uriBuilder
                                 .path("v1/market/all")
                                 .queryParam("isDetails", true)
                                 .build())
                             .retrieve()
                             .bodyToMono(new ParameterizedTypeReference<List<MarketInfo>>() {})
                             .block();
    }

    public List<UpbitPriceInfo> getPriceInfo(List<String> markets) {
        return upbitWebClient.get()
                             .uri(uriBuilder -> uriBuilder
                                 .path("v1/ticker")
                                 .queryParam("markets", StringUtils.join(markets, ','))
                                 .build())
                             .retrieve()
                             .bodyToMono(new ParameterizedTypeReference<List<UpbitPriceInfo>>() {})
                             .block();
    }

}
