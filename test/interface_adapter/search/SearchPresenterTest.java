package interface_adapter.search;

import entity.DetailedPlace;
import interface_adapter.ViewManagerModel;
import interface_adapter.results.ResultsState;
import interface_adapter.results.ResultsViewModel;
import use_case.search.SearchOutputData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchPresenterTest {

    private SearchViewModel mockSearchViewModel;
    private ResultsViewModel mockResultsViewModel;
    private ViewManagerModel mockViewManagerModel;
    private SearchPresenter searchPresenter;

    @BeforeEach
    void setUp() {
        mockSearchViewModel = new SearchViewModel();
        mockResultsViewModel = new ResultsViewModel();
        mockViewManagerModel = new ViewManagerModel();
        searchPresenter = new SearchPresenter(mockSearchViewModel, mockResultsViewModel, mockViewManagerModel);
    }

    @Test
    void testPrepareSuccessView() {

        ResultsState mockResultsState = new ResultsState();
        mockResultsViewModel.setState(mockResultsState);
        ArrayList<DetailedPlace> mockResults = new ArrayList<>();
        SearchOutputData mockSearchOutputData = new SearchOutputData(mockResults);


        searchPresenter.prepareSuccessView(mockSearchOutputData);


        assertEquals(mockResults, mockResultsState.getResults());
        assertEquals(mockResultsState, mockResultsViewModel.getState());
        assertEquals(mockResultsState, mockResultsViewModel.getState());
        assertEquals(mockResultsViewModel.getViewName(), mockViewManagerModel.getActiveView());
    }

    @Test
    void testPrepareFailView() {
        // Arrange
        SearchState mockSearchState = new SearchState();
        mockSearchViewModel.setState(mockSearchState);
        String errorMessage = "Error occurred during search";


        searchPresenter.prepareFailView(errorMessage);


        assertEquals(errorMessage, mockSearchState.getSearchError());
        assertEquals(mockSearchState, mockSearchViewModel.getState());
    }
}