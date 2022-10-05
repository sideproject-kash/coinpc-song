package com.song.coinpc.client.upbit.dto;

import java.math.BigDecimal;

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
@ToString
public class UpbitPriceInfo {

    @JsonProperty("market")
    private String market;

    @JsonProperty("trade_date")
    private String tradeDate;

    @JsonProperty("trade_time")
    private String tradeTime;

    @JsonProperty("trade_date_kst")
    private String tradeDateKst;

    @JsonProperty("trade_time_kst")
    private String tradeTimeKst;

    @JsonProperty("trade_timestamp")
    private Long tradeTimestamp;

    @JsonProperty("opening_price")
    private BigDecimal openingPrice;

    @JsonProperty("high_price")
    private BigDecimal highPrice;

    @JsonProperty("low_price")
    private BigDecimal lowPrice;

    @JsonProperty("trade_price")
    private BigDecimal tradePrice;

    @JsonProperty("prev_closing_price")
    private BigDecimal prevClosingPrice;

    @JsonProperty("change")
    private String change; // todo: change to ENUM

    @JsonProperty("change_price")
    private BigDecimal changePrice;

    @JsonProperty("change_rate")
    private BigDecimal changeRate;

    @JsonProperty("signed_change_price")
    private BigDecimal signedChangePrice;

    @JsonProperty("signed_change_rate")
    private BigDecimal signedChangeRate;

    @JsonProperty("trade_volume")
    private BigDecimal tradeVolume;

    @JsonProperty("acc_trade_price")
    private BigDecimal accTradePrice;

    @JsonProperty("acc_trade_price_24h")
    private BigDecimal accTradePrice24h;

    @JsonProperty("acc_trade_volume")
    private BigDecimal accTradeVolume;

    @JsonProperty("acc_trade_volume_24h")
    private BigDecimal accTradeVolume24h;

    @JsonProperty("highest_52_week_price")
    private BigDecimal highest52WeekPrice;

    @JsonProperty("highest_52_week_date")
    private String highest52WeekDate;

    @JsonProperty("lowest_52_week_price")
    private BigDecimal lowest52WeekPrice;

    @JsonProperty("lowest_52_week_date")
    private String lowest52WeekDate;

    @JsonProperty("timestamp")
    private Long timestamp;

}
