package interface_adapter.results;

import entity.DetailedPlace;
import interface_adapter.ViewManagerModel;
import interface_adapter.results.ResultsPresenter;
import interface_adapter.results.ResultsState;
import interface_adapter.results.ResultsViewModel;
import interface_adapter.specific.SpecificState;
import interface_adapter.specific.SpecificViewModel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.results.ResultsOutputData;

import static org.junit.jupiter.api.Assertions.*;
import java.beans.PropertyChangeListener;

class ResultsPresenterTest {

    private ResultsPresenter resultsPresenter;
    private ResultsViewModel resultsViewModel;
    private SpecificViewModel specificViewModel;
    private ViewManagerModel viewManagerModel;
    private PropertyChangeListener listener;

    @BeforeEach
    void setUp() {
        resultsViewModel = new ResultsViewModel();
        specificViewModel = new SpecificViewModel();
        viewManagerModel = new ViewManagerModel();
        resultsPresenter = new ResultsPresenter(resultsViewModel, specificViewModel, viewManagerModel);
        listener = evt -> {
            // Handle property change event
        };
    }

    @Test
    void testPrepareSuccessView() {
        // Arrange
        JSONObject placeJson = new JSONObject();
        placeJson.put("name", "Test Place");
        placeJson.put("Address", new JSONObject().put("formattedAddress", "123 Test Street"));
        JSONArray coordinatesJson = new JSONArray().put(0.0).put(0.0);
        JSONArray geocodePointsJson = new JSONArray().put(new JSONObject().put("coordinates", coordinatesJson));
        placeJson.put("geocodePoints", geocodePointsJson);
        placeJson.put("Website", "https://example.com");
        DetailedPlace detailedPlace = new DetailedPlace(placeJson);
        ResultsOutputData response = new ResultsOutputData(detailedPlace);

        // Act
        resultsPresenter.prepareSuccessView(response);
        SpecificState specificState = specificViewModel.getState();

        // Assert
        assertEquals(detailedPlace, specificState.getDetailedPlace());
        assertEquals(specificViewModel.getViewName(), viewManagerModel.getActiveView());
    }

    @Test
    void testPrepareFailView() {
        String error = "";

        resultsPresenter.prepareFailView(error);
        ResultsState resultsState = resultsViewModel.getState();

        assertEquals(error, resultsState.getResultsError());
    }


}