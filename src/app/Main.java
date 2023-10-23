package app;

import java.io.IOException;
import java.net.*;





public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat=0&lon=0&appid=eb46926a4e98e257c2c14f2b9fcd1899");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();


        int code = connection.getResponseCode();
        System.out.println(code); // Returns status code if request went through.
    }
}