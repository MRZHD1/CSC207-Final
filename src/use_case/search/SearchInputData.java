package use_case.search;
import java.net.URL;
import java.net.URLEncoder;

public class SearchInputData {
    final private String query;
    final private String location;

    public SearchInputData(String query, String location){
        this.query = query;
        this.location = location;
    }

    String getQuery(){
        String cleanQuery = URLEncoder.encode(this.query);
        return cleanQuery;
    }

    String getLocation() {
        String cleanLocation = URLEncoder.encode(this.location);
        return cleanLocation;
    }
}
