package com.song.coinpc.client.upbit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString // TODO: remove
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarketInfo {

    @JsonProperty("market")
    private String market;

    @JsonProperty("korean_name")
    private String koreanName;

    @JsonProperty("english_name")
    private String englishName;

    @JsonProperty("market_warning")
    private String marketWarning; // TODO: change to ENUM NONE (해당 사항 없음), CAUTION(투자유의)
}
