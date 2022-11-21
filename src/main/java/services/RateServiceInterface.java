package services;

import models.RatesOutput;

public interface RateServiceInterface {

    Double getCurrentRate(String currency);
    RatesOutput getRatesByInterval(String currency, Integer interval);

}
