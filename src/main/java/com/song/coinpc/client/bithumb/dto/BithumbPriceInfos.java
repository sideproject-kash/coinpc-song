package com.song.coinpc.client.bithumb.dto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.song.coinpc.client.bithumb.dto.BithumbPriceInfos.BithumbPriceInfosDeserializer;
import com.song.coinpc.client.upbit.dto.UpbitPriceInfo;
import com.song.coinpc.common.utils.ObjectMapperUtils;

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
@JsonDeserialize(using = BithumbPriceInfosDeserializer.class)
public class BithumbPriceInfos {
    private Map<String, BithumbPriceInfo> bithumbPriceInfoList;

    public static class BithumbPriceInfosDeserializer extends JsonDeserializer<BithumbPriceInfos> {

        private static final String IGNORE_FIELD = "date";

        @Override
        public BithumbPriceInfos deserialize(JsonParser parser, DeserializationContext ctxt)
            throws IOException {

            Map<String, BithumbPriceInfo> bithumbPriceInfoMap = new HashMap<>();

            TreeNode treeNode = parser.readValueAsTree();
            Iterator<String> iterator = treeNode.fieldNames();
            while (iterator.hasNext()) {
                String fieldName = iterator.next();

                if (IGNORE_FIELD.equals(fieldName)) {
                    continue;
                }

                String node = treeNode.get(fieldName).toString();
                BithumbPriceInfo value = ObjectMapperUtils.getMapper().readValue(node, BithumbPriceInfo.class);

                bithumbPriceInfoMap.put(fieldName, value);
            }
            return new BithumbPriceInfos(bithumbPriceInfoMap);
        }
    }
}
