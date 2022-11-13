package com.song.coinpc.client.bithumb.dto;

import java.math.BigDecimal;

import javax.print.DocFlavor.STRING;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BithumbPriceInfo {

    @JsonProperty("opening_price")
    private BigDecimal openingPrice; // 시가 00시 기준

    @JsonProperty("closing_price")
    private BigDecimal closingPrice; // 종가 00시 기준 <- 현재가 인듯?

    @JsonProperty("min_price")
    private BigDecimal minPrice; // 저가 00시 기준

    @JsonProperty("max_price")
    private BigDecimal maxPrice; // 고가 00시 기준

    @JsonProperty("units_traded")
    private BigDecimal unitsTraded; // 거래량 00시 기준

    @JsonProperty("acc_trade_value")
    private BigDecimal accTradeValue; // 거래금액 00시 기준

    @JsonProperty("prev_closing_price")
    private BigDecimal prev_closing_price; // 전일종가

    @JsonProperty("units_traded_24H")
    private BigDecimal units_traded_24H; // 최근 24시간 거래량

    @JsonProperty("acc_trade_value_24H")
    private BigDecimal acc_trade_value_24H; // 최근 24시간 거래금액

    @JsonProperty("fluctate_24H")
    private BigDecimal fluctate_24H; // 최근 24시간 변동가

    @JsonProperty("fluctate_rate_24H")
    private BigDecimal fluctate_rate_24H; // 최근 24시간 변동률

}
