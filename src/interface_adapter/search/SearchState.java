package interface_adapter.search;

public class SearchState {
    private String query = "";
    private String location = "";
    private String searchError = "";

    public SearchState(SearchState copy) {
        query = copy.query;
        location = copy.location;
        searchError = copy.searchError;
    }

    public SearchState() {}

    public String getQuery() {
        return query;
    }
    public String getLocation() {
        return location;
    }
    public void setSearchError(String searchError) {
        this.searchError = searchError;
    }

    public String getSearchError() {
        return this.searchError;
    }

}
