package com.song.coinpc.client.bithumb;

import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.song.coinpc.client.bithumb.dto.BithumbPriceInfo;
import com.song.coinpc.client.bithumb.dto.BithumbPriceInfos;
import com.song.coinpc.client.bithumb.dto.BithumbResponse;
import com.song.coinpc.common.enums.MarketType;
import com.song.coinpc.common.enums.PaymentCurrencyType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BithumbClient {

    private final WebClient bithumbWebClient;

    public BithumbResponse<BithumbPriceInfo> getPriceInfo(MarketType orderCurrency,
                                                          PaymentCurrencyType paymentCurrency) {

        String marketCode = String.format("%s_%s", orderCurrency.getCode(), paymentCurrency.getCode());

        return bithumbWebClient.get()
                               .uri(uriBuilder -> uriBuilder
                                   .path("public/ticker/{marketCode}")
                                   .build(marketCode))
                               .retrieve()
                               .bodyToMono(
                                   new ParameterizedTypeReference<BithumbResponse<BithumbPriceInfo>>() {})
                               .block();
    }

    public BithumbResponse<BithumbPriceInfos> getAllPriceInfo(PaymentCurrencyType paymentCurrency) {

        String marketCode = String.format("ALL_%s", paymentCurrency.getCode());

        return bithumbWebClient.get()
                               .uri(uriBuilder -> uriBuilder
                                   .path("public/ticker/{marketCode}")
                                   .build(marketCode))
                               .retrieve()
                               .bodyToMono(
                                   new ParameterizedTypeReference<BithumbResponse<BithumbPriceInfos>>() {})
                               .block();
    }

}
