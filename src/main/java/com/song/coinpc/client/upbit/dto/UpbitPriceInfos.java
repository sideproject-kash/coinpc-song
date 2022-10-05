package com.song.coinpc.client.upbit.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString // TODO: remove
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpbitPriceInfos {

    private List<UpbitPriceInfo> upbitPriceInfoList;
}
