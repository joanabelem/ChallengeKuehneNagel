package models.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class TimeseriesRateResponse {

    private Map<String, String> motd;
    private String url;
    private String success;
    private String base;
    private Map<String, Map<String, Double>> rates;

}
