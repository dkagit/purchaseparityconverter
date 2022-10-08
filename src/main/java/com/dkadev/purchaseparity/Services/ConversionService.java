package com.dkadev.purchaseparity.Services;

import com.dkadev.purchaseparity.Json.CoreData;
import com.dkadev.purchaseparity.Json.Parity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

@Component
public class ConversionService {

    private final WebClient webClient;

    private final String WEC_URI = "api.worldbank.org//v2//en//country//all//indicator//PA.NUS.PPP";

    public ConversionService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    private final HashMap<String, List<CoreData>> PARITY_MAP = constructParityMap();

    public HashMap<String, List<CoreData>> constructParityMap() {
        String data = getDataFromWEC().block();

        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, List<CoreData>> parityHashMap = new HashMap<String, List<CoreData>>();
        List<String> countryList = new ArrayList<String>();
        try {
            Iterator<JsonNode> element = objectMapper.readTree(data).get(1).elements();
            String country;
            Integer year = null;
            BigDecimal value = null;
            while (element.hasNext()) {
                JsonNode node = element.next();
                country = node.get("countryiso3code").textValue();
                if (country.isEmpty()) {
                    continue;
                }
                year = Integer.parseInt(node.get("date").textValue());
                value = node.get("value").isNull() ? null : new BigDecimal(node.get("value").asDouble());

                if (!countryList.contains(country)) {
                    countryList.add(country);
                }
                CoreData coreData = new CoreData(country, year, value);
                List<CoreData> coreDataList = null;
                if (parityHashMap.containsKey(country)) {
                    coreDataList = parityHashMap.get(country);
                    coreDataList.add(coreData);
                } else {
                    coreDataList = new ArrayList<CoreData>();
                    coreDataList.add(coreData);
                }
                parityHashMap.put(country, coreDataList);
            }
        } catch (Exception e) {
            return null;
        }
        return parityHashMap;
    }

    public String convert(String baseCountry, String targetCountry, Integer year) {
        List<CoreData> coreDataList = PARITY_MAP.get(targetCountry);
        BigDecimal parityVal = null;
        if (year != null) {
            for (CoreData data:coreDataList) {
                if(data.getYear().equals(year))
                {
                    parityVal = data.getParityValue();
                }
            }
        }
        else
        {
            parityVal = coreDataList.get(0).getParityValue();
        }
        if(parityVal!=null)
        {

        }
        return countryList.toString();
    }

    private Mono<String> getDataFromWEC() {
        return this.webClient.get().uri(uriBuilder -> uriBuilder
                        .path(WEC_URI)
                        .queryParam("format", "JSON")
                        .queryParam("per_page", "20000")
                        .queryParam("date", "2017:2022")
                        .build())
                .retrieve()
                .bodyToMono(String.class);
    }
}
