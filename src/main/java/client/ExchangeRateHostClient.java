package client;

import com.google.gson.Gson;
import models.domain.LatestRateResponse;
import models.domain.TimeseriesRateResponse;
import utils.Helpers;

import java.util.Map;

public class ExchangeRateHostClient implements ExchangeRateHostClientInterface {

    private static final String BASE_URL = "https://api.exchangerate.host/";
    private static final String LATEST_URL = "latest?base=BTC&symbols=";
    private static final String TIMESERIES_URL = "timeseries?start_date=START_DATE&end_date=END_DATE&base=BTC&symbols=";

    public Double getCurrentRate(String currency){

        Gson gson = new Gson();
        String url = BASE_URL + LATEST_URL + currency;

        String response = Helpers.createGetRequest(url);
        LatestRateResponse r = gson.fromJson(response, LatestRateResponse.class);
        return r.getRates().get(currency);
    }

    public Map<String, Map<String, Double>> getRatesByInterval(String currency, String startDate, String endDate){

        Gson gson = new Gson();
        String url = BASE_URL +
                TIMESERIES_URL.replace("START_DATE", startDate).replace("END_DATE", endDate) +
                currency;

        String response = Helpers.createGetRequest(url);
        TimeseriesRateResponse r = gson.fromJson(response, TimeseriesRateResponse.class);
        return r.getRates();
    }
}
