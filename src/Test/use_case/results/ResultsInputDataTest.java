package use_case.results;

import entity.DetailedPlace;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResultsInputDataTest {

    @Test
    void testGetDetailedPlaceValid() {
        // Arrange
        JSONObject placeJson = new JSONObject();
        placeJson.put("name", "Test Place");
        placeJson.put("Address", new JSONObject().put("formattedAddress", "123 Test St"));
        placeJson.put("geocodePoints", new JSONArray().put(new JSONObject().put("coordinates", new JSONArray())));
        DetailedPlace detailedPlace = new DetailedPlace(placeJson);
        ResultsInputData resultsInputData = new ResultsInputData(detailedPlace);

        // Act
        DetailedPlace result = resultsInputData.getDetailedPlace();

        // Assert
        assertNotNull(result, "The result should not be null");
        assertEquals(detailedPlace, result, "The returned DetailedPlace should be the same as the one passed to the constructor");
    }

    @Test
    void testGetDetailedPlace() {
        ResultsInputData resultsInputData = new ResultsInputData(null);

        DetailedPlace result = resultsInputData.getDetailedPlace();

        assertNull(result, "The result should be null when DetailedPlace is null");
    }
}