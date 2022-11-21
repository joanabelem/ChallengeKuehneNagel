package utils;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class HelpersTest {

    @Test
    public void createGetRequestTest_ValidUrl() {

        String url = "https://api.exchangerate.host/timeseries?start_date=2022-11-19&end_date=2022-11-19&base=BTC&symbols=EUR";
        String expectedResponse = "{\"motd\":{\"msg\":\"If you or your company use this project or like what we doing, " +
                "please consider backing us so we can continue maintaining and evolving this project.\"," +
                "\"url\":\"https://exchangerate.host/#/donate\"}," +
                "\"success\":true," +
                "\"timeseries\":true," +
                "\"base\":\"BTC\"," +
                "\"start_date\":\"2022-11-19\"," +
                "\"end_date\":\"2022-11-19\"," +
                "\"rates\":{\"2022-11-19\":{\"EUR\":16141.177419}}}";

        String response = Helpers.createGetRequest(url);
        assertEquals(expectedResponse, response);
    }
}
