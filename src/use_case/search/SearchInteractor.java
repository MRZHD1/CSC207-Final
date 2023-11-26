package use_case.search;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


import entity.Place;
import org.json.JSONArray;
import org.json.JSONObject;

public class SearchInteractor implements SearchInputBoundary {
    final SearchDataAccessInterface searchAccessObject;
    final SearchOutputBoundary searchResults;


    public SearchInteractor(SearchDataAccessInterface searchAccessObject, SearchOutputBoundary searchResults) {
        this.searchAccessObject = searchAccessObject;
        this.searchResults = searchResults;
    }

    @Override
    public void execute(SearchInputData searchInput) {
        // Use Bing Maps API to create the list of searchResults
        try {
            JSONArray jsonArray = search(searchInput.getQuery(), searchInput.getLocation());
            searchAccessObject.save(jsonArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private JSONArray search(String query, Place location) throws IOException, InterruptedException {
        File file = new File(
                "./key.txt");
        Scanner sc = new Scanner(file);
        String key = sc.nextLine();
        String coordinates = location.getCoordinates();
        String searchURL = String.format("https://dev.virtualearth.net/REST/v1/LocalSearch/?query=%s&userLocation=%s&key=%s",query,coordinates,key);
        System.out.println(searchURL);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(searchURL))
                .build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jObject  = new JSONObject(response.body().toString());
        System.out.println(jObject);
        JSONArray results = jObject.getJSONArray("resourceSets").getJSONObject(0).getJSONArray("resources");
        System.out.println("PLACES:");
        System.out.println(results);
        return results;
    }
}
