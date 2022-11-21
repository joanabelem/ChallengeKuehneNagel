package client;

import java.util.Map;

public interface ExchangeRateHostClientInterface {

    Double getCurrentRate(String currency);
    Map<String, Map<String, Double>> getRatesByInterval(String currency, String startDate, String endDate);
}
