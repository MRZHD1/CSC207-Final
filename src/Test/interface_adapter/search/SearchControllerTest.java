//package interface_adapter.search;
//
//import entity.Place;
//import interface_adapter.search.SearchController;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import use_case.search.SearchInputBoundary;
//import use_case.search.SearchInputData;
//
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Matchers.argThat;
//import static org.mockito.Mockito.verify;
//
//class SearchControllerTest {
//
//    private SearchInputBoundary searchUseCaseInteractor;
//
//    // execute method?
//
//    @Test
//    void testNormalSearch() throws IOException, InterruptedException {
//        // Create a mock SearchInputBoundary
//
//        SearchInputData searchInputData = new SearchInputData("Statue of Liberty", "New York");
//
//
//        SearchController searchController = new SearchController(searchUseCaseInteractor);
//
//        assertDoesNotThrow(() -> searchController.execute("Statue of Liberty", "New York"));
//
//
//        searchController.execute("Statue of Liberty", "New York");
//
//        String queries = searchInputData.getSubject();
//        Place location = searchInputData.getPinpoint();
//
//        // Assert that the execute method of the SearchInputBoundary is called with the correct inputs
//        assertEquals("Statue of Liberty", queries);
//        assertEquals("New York", location);
//    }
//
//
//}