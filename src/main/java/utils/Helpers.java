package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Helpers {

    public static String createGetRequest(String url) {

        String response = "";

        try {
            URL httpUrl = new URL(url);
            HttpURLConnection request = (HttpURLConnection) httpUrl.openConnection();
            request.setRequestMethod("GET");
            request.setRequestProperty("Accept", "application/json");
            request.connect();

            int responseCode = request.getResponseCode();

            if (responseCode == 200) {
                Scanner scanner = new Scanner(request.getInputStream());
                while (scanner.hasNextLine()) {
                    response += scanner.nextLine();
                }
                scanner.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
