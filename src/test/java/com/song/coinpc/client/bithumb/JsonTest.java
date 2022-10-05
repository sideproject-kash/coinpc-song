package com.song.coinpc.client.bithumb;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.song.coinpc.client.bithumb.dto.BithumbPriceInfo;
import com.song.coinpc.client.bithumb.dto.BithumbPriceInfos;
import com.song.coinpc.client.bithumb.dto.BithumbResponse;
import com.song.coinpc.client.upbit.dto.UpbitPriceInfos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class JsonTest {

    String json = """
        {"status":"0000","data":{"BTC":{"test":"1"}, "ETC": {"test":"2"}}}
        """;

    String json2 = """
        {"status":"0000","data":{"BTC":{"opening_price":"28775000","closing_price":"28846000","min_price":"28473000","max_price":"29097000","units_traded":"761.45977429","acc_trade_value":"21934366170.5736","prev_closing_price":"28775000","units_traded_24H":"2049.68096696","acc_trade_value_24H":"58724118015.3318","fluctate_24H":"616000","fluctate_rate_24H":"2.18"},"ETH":{"opening_price":"1931000","closing_price":"1935000","min_price":"1915000","max_price":"1948000","units_traded":"3654.32663423","acc_trade_value":"7064423408.3276","prev_closing_price":"1932000","units_traded_24H":"11734.82880952","acc_trade_value_24H":"22643300534.4819","fluctate_24H":"30000","fluctate_rate_24H":"1.57"}}}
        """;

    String json3 = """
        {"status":"0000","data":{"BTC":{"opening_price":"28476000","closing_price":"28681000","min_price":"28471000","max_price":"28821000","units_traded":"105.39686661","acc_trade_value":"3013833977.8601","prev_closing_price":"28477000","units_traded_24H":"2007.8611323","acc_trade_value_24H":"57648234983.3066","fluctate_24H":"119000","fluctate_rate_24H":"0.42"},"date":"1664986909098"}}
        """;

    @Test
    void test() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonModel jsonModel = mapper.readValue(json, JsonModel.class);
        System.out.println(jsonModel);
    }

    @Test
    void test2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        BithumbResponse<Map<String, BithumbPriceInfo>> mapBithumbResponse = mapper.readValue(json2,
                                                                                             new TypeReference<>() {});
        System.out.println(mapBithumbResponse);
    }

    @Test
    void test3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        BithumbResponse<BithumbPriceInfos> mapBithumbResponse = mapper.readValue(json3, new TypeReference<>() {});
        System.out.println(mapBithumbResponse);
    }

    @Test
    void write() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        JsonModel model = new JsonModel();
        model.setStatus("ok");
        model.setData(new DataModels(Map.of("BTD", new DataModel("1"))));

        String s = mapper.writeValueAsString(model);
        System.out.println(s);

        JsonModel model1 = mapper.readValue(s, JsonModel.class);
        System.out.println(model1);
    }

    @Data
    private static class JsonModel {
        private String status;
//        @JsonUnwrapped
        private DataModels data;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class DataModels {
        private Map<String, DataModel> tests;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class DataModel {
        private String test;
    }
}
