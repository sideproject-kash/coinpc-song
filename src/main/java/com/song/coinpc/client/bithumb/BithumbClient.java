package com.song.coinpc.client.bithumb;

import java.util.List;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.song.coinpc.client.upbit.dto.MarketInfo;
import com.song.coinpc.client.upbit.dto.PriceInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BithumbClient {

    private final WebClient bithumbWebClient;

    public String getPriceInfo(String orderCurrency, String paymentCurrency) { // change to enum

        String marketCode = String.format("%s_%s", orderCurrency, paymentCurrency);

        return this.bithumbWebClient.get()
                                  .uri(uriBuilder -> uriBuilder
                                          .path("public/ticker/{marketCode}")
                                          .build(marketCode))
                                  .retrieve()
//                                  .bodyToMono(new ParameterizedTypeReference<List<PriceInfo>>() {})
                                  .bodyToMono(String.class)
                                  .block();
    }

}
