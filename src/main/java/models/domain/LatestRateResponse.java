package models.domain;

import lombok.Getter;

import java.util.Map;

@Getter
public class LatestRateResponse {

    private Map<String, String> motd;
    private String url;
    private String success;
    private String base;
    private Map<String, Double> rates;

}
