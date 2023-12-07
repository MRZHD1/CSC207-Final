package interface_adapter.search;

public class SearchState {
    private String query = "";
    private String location = "";
    private String searchError = "";
    private String defaultAddress = "";

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
    public void setDefaultAddress(String defaultAddress) {
        this.defaultAddress = defaultAddress;
    }
    public String getDefaultAddress(){
        return defaultAddress;
    }

    public void setQuery(String query) {

        this.query = query;

    }

    public void setLocation(String location) {
        this.location = location;
    }
}
