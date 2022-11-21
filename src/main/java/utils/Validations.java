package utils;

import models.Currency;

public class Validations {

    public static boolean isCurrencyValid(String currency){

        try {
            Currency.valueOf(currency);
        }catch (IllegalArgumentException e){
            return false;
        }

        return true;
    }
}
