package com.song.coinpc.client.bithumb.dto;

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
public class BithumbResponse<T> {

    @JsonProperty("status")
    private String status;

    @JsonProperty("data")
    private T data;
}
