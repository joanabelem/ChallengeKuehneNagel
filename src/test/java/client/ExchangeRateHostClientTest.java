package client;

import com.google.gson.Gson;
import models.domain.LatestRateResponse;
import models.domain.TimeseriesRateResponse;
import org.junit.Test;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class ExchangeRateHostClientTest {

    @Test
    public void getCurrentRateTest_OK(){

        ExchangeRateHostClient client = new ExchangeRateHostClient();

        Gson gson = new Gson();
        String response = "{\"rates\": {\"EUR\":16143.548387}}";
        LatestRateResponse latestRateResponse = gson.fromJson(response, LatestRateResponse.class);

        Double rate = client.getCurrentRate("EUR");
        assertEquals(latestRateResponse.getRates().get("EUR").getClass(), rate.getClass());
    }


    @Test
    public void getRatesByInterval_OK(){

        ExchangeRateHostClient client = new ExchangeRateHostClient();

        Gson gson = new Gson();
        Map<String, Map<String, Double>> clientExpectedResult = gson.fromJson("" +
                "{\"rates\":" +
                    "{\"2022-11-18\":{\"EUR\":16143.548387}," +
                    "\"2022-11-19\":{\"EUR\":16141.177419}}}", TimeseriesRateResponse.class).getRates();

        Map<String, Map<String, Double>> rates = client.getRatesByInterval("EUR", "2022-11-18", "2022-11-19");
        assertEquals(clientExpectedResult.get("2022-11-19").get("EUR"), rates.get("2022-11-19").get("EUR"));
        assertEquals(clientExpectedResult.get("2022-11-19").get("EUR"), rates.get("2022-11-19").get("EUR"));
    }
}
