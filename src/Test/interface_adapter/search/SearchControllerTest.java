package interface_adapter.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInputData;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SearchControllerTest {

    private SearchInputBoundary searchUseCaseInteractor;
    private SearchController searchController;

    @BeforeEach
    void setUp() {
        searchUseCaseInteractor = new SearchInputBoundary() {
            @Override
            public void execute(SearchInputData searchInput) {
                // Mock implementation for testing
            }
        };
        searchController = new SearchController(searchUseCaseInteractor);
    }

    @Test
    void testExecuteWhenValidInput() throws IOException, InterruptedException {

        String query = "test query";
        String location = "test location";


        searchController.execute(query, location);

    }

    @Test
    void testExecuteThrow() throws IOException, InterruptedException {

        String query = "test query";
        String location = "test location";
        searchUseCaseInteractor = new SearchInputBoundary() {
            @Override
            public void execute(SearchInputData searchInput) {
                throw new RuntimeException(new FileNotFoundException());
            }
        };
        searchController = new SearchController(searchUseCaseInteractor);


        assertThrows(RuntimeException.class, () -> {
            searchController.execute(query, location);
        });
    }



    @Test
    void testExecuteInterruptedException() throws IOException, InterruptedException {

        String query = "test query";
        String location = "test location";
        searchUseCaseInteractor = new SearchInputBoundary() {
            @Override
            public void execute(SearchInputData searchInput) {
                throw new RuntimeException(new InterruptedException());
            }
        };
        searchController = new SearchController(searchUseCaseInteractor);


        assertThrows(RuntimeException.class, () -> {
            searchController.execute(query, location);
        });
    }
}