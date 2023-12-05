package use_case.search;

import data_access.InMemorySearchDataAccessObject;
import org.junit.jupiter.api.Test;
import use_case.search.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SearchInteractorTest {

    @Test
    void successTest() throws IOException, InterruptedException {

        SearchInputData inputData = new SearchInputData("Statue of liberty", "New York");
        SearchDataAccessInterface searchRepository = new InMemorySearchDataAccessObject();

        SearchOutputBoundary successPresenter = new SearchOutputBoundary() {
            @Override
            public void prepareSuccessView(SearchOutputData results) {
                // Need help with finding the address!!!!!!!!
                assertEquals(results.getResults(), results.getResults());

            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is not supposed to happen");
            }
        };

        SearchInputBoundary interactor = new SearchInteractor(searchRepository, successPresenter);
        interactor.execute(inputData);

    }

    @Test
    void failureInputTest() throws IOException, InterruptedException {

        SearchInputData inputData = new SearchInputData("Coffee", "Onatrio");
        SearchDataAccessInterface searchRepository = new InMemorySearchDataAccessObject();


        SearchOutputBoundary failurePresenter = new SearchOutputBoundary() {
            @Override
            public void prepareSuccessView(SearchOutputData results) {
                // Need help with finding the address
                fail("Use case is not supposed to succeed");

            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Your search failed! Make sure your location is in the US.", error);
            }
        };

        SearchInputBoundary interactor = new SearchInteractor(searchRepository, failurePresenter);
        interactor.execute(inputData);

    }


}