package entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CommonPlace implements Place {
    private final String address;
    private final String coordinates;

    public CommonPlace(String address) throws IOException, InterruptedException {
        this.address = URLEncoder.encode(address, StandardCharsets.UTF_8);
        this.coordinates = setCoordinates(this.address);
    }

    public String setCoordinates(String address) throws IOException, InterruptedException {
        File file = new File(
                "./key.txt");
        Scanner sc = new Scanner(file);
        String key = sc.nextLine();
        String locateURL = String.format("https://dev.virtualearth.net/REST/v1/Locations?q=%s&key=%s",address,key);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(locateURL))
                .build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jObject  = new JSONObject(response.body().toString());
        String coordinates = jObject.getJSONArray("resourceSets").getJSONObject(0)
                .getJSONArray("resources").getJSONObject(0).getJSONArray("geocodePoints")
                .getJSONObject(0).get("coordinates").toString();
        return coordinates.replace("[","").replace("]","")+",10000";
    }

    @Override
    public String getCoordinates() {
        return this.coordinates;
    }

    @Override
    public String getAddress() {
        return this.address;
    }
}
