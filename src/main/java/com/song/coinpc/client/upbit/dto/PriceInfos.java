package com.song.coinpc.client.upbit.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString // TODO: remove
@Getter
@Setter
@Builder
public class PriceInfos {

    private List<PriceInfo> priceInfoList;

}
