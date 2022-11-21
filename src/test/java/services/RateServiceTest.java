package services;

import client.ExchangeRateHostClient;
import com.google.gson.Gson;
import models.RatesOutput;
import models.domain.TimeseriesRateResponse;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RateServiceTest {

    @Test
    public void getCurrentRateTest_OK(){

        RateService rateService = new RateService();
        rateService.exchangeRateHostClient = mock(ExchangeRateHostClient.class);

        Double expectedRate = 3.0;
        when(rateService.exchangeRateHostClient.getCurrentRate("EUR")).thenReturn(expectedRate);
        Double rate = rateService.getCurrentRate("EUR");
        assertEquals(expectedRate, rate);
    }


    @Test
    public void getRatesByInterval_OK(){
        RateService rateService = new RateService();
        rateService.exchangeRateHostClient = mock(ExchangeRateHostClient.class);

        RatesOutput expectedResult = RatesOutput.builder()
                                        .max("16143.548387")
                                        .min("16141.177419")
                                        .build();

        Gson gson = new Gson();
        Map<String, Map<String, Double>> clientExpectedResult = gson.fromJson("" +
                "{\"rates\":" +
                    "{\"2022-11-18\":{\"EUR\":16143.548387}," +
                    "\"2022-11-19\":{\"EUR\":16141.177419}}}", TimeseriesRateResponse.class).getRates();

        when(rateService.exchangeRateHostClient.getRatesByInterval(any(), any(), any())).thenReturn(clientExpectedResult);
        RatesOutput rate = rateService.getRatesByInterval("EUR", 90);
        assertEquals(expectedResult.getMax(), rate.getMax());
        assertEquals(expectedResult.getMin(), rate.getMin());
    }
}
