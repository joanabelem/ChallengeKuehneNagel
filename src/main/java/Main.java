import models.RatesOutput;
import services.RateService;
import utils.Validations;

import java.util.Scanner;

public class Main {

    private static final Integer RATES_INTERVAL = 90;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String currency;
        RateService service = new RateService();
        boolean isCurrencyValid;

        do{
            System.out.println("Insert a currency (USD, EUR, GBP, ...): ");
            currency = scanner.nextLine().toUpperCase();
            isCurrencyValid = Validations.isCurrencyValid(currency);

            if(isCurrencyValid){
                Double currentRate = service.getCurrentRate(currency);
                RatesOutput rates = service.getRatesByInterval(currency, RATES_INTERVAL);

                System.out.println("Current Bitcoin Rate: " + currentRate);
                System.out.println("Highest Bitcoin Rate: " + rates.getMax());
                System.out.println("Lowest Bitcoin Rate: " + rates.getMin());
            }else{
                System.out.println("Currency is not valid! Please, try again.");
            }
        }while(!isCurrencyValid);
    }
}
