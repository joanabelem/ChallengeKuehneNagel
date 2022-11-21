package services;

import client.ExchangeRateHostClient;
import models.RatesOutput;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

public class RateService implements RateServiceInterface{

    ExchangeRateHostClient exchangeRateHostClient = new ExchangeRateHostClient();

    @Override
    public Double getCurrentRate(String currency) {
        return exchangeRateHostClient.getCurrentRate(currency);
    }

    @Override
    public RatesOutput getRatesByInterval(String currency, Integer interval){

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        String endDate = dateFormat.format(now);
        String startDate = dateFormat.format(now.minusDays(interval));

        ArrayList<Double> rates = new ArrayList<>();

        Map<String, Map<String, Double>> r = exchangeRateHostClient.getRatesByInterval(currency, startDate, endDate);
        for(Map<String, Double> rate : r.values()){
            rates.add(rate.get(currency));
        }

        double maxRate = rates.stream().max(Double::compare).isPresent() ? rates.stream().max(Double::compare).get() : 0.0;
        double minRate = rates.stream().min(Double::compare).isPresent() ? rates.stream().min(Double::compare).get() : 0.0;

        return RatesOutput.builder()
                .max(Double.toString(maxRate))
                .min(Double.toString(minRate))
                .build();
    }
}
