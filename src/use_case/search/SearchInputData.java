package use_case.search;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class SearchInputData {
    final private String query;
    final private String location;

    public SearchInputData(String query, String location){
        this.query = query;
        this.location = location;
    }

    String getQuery(){
        return URLEncoder.encode(this.query, StandardCharsets.UTF_8);
    }

    String getLocation() {
        return URLEncoder.encode(this.location, StandardCharsets.UTF_8);
    }
}
