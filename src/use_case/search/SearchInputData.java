package use_case.search;
import entity.CommonPlace;
import entity.Place;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class SearchInputData {
    final private String query;
    final private Place location;

    public SearchInputData(String query, String location) throws IOException, InterruptedException {
        this.query = query;
        this.location = new CommonPlace(location);
    }

    String getQuery(){
        return URLEncoder.encode(this.query, StandardCharsets.UTF_8);
    }
    Place getLocation() {return this.location;}

    public String getSubject() {
        return query;
    }

    public Place getPinpoint(){
        return location;
    }
}
