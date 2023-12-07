package interface_adapter.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchStateTest {

    private SearchState searchState;

    @BeforeEach
    void setUp() {
        searchState = new SearchState();
    }

    @Test
    void testGetQuery() {

        String query = "example query";

        searchState.setQuery(query);
        String result = searchState.getQuery();


        assertEquals(query, result);
    }

    @Test
    void testGetLocation(){

        String location = "location";

        searchState.setLocation(location);
        String result = searchState.getLocation();

        assertEquals(location, result);

    }


    @Test
    void testGetSearchError() {

        String searchError = "example error";


        searchState.setSearchError(searchError);
        String result = searchState.getSearchError();

        assertEquals(searchError, result);
    }

    @Test
    void testSetSearchError() {

        String searchError = "example error";


        searchState.setSearchError(searchError);

        assertEquals(searchError, searchState.getSearchError());
    }
}