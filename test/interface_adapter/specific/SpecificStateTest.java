package interface_adapter.specific;

import entity.DetailedPlace;
import interface_adapter.specific.SpecificState;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SpecificStateTest {

    private SpecificState specificState;

    @BeforeEach
    void setUp() {
        specificState = new SpecificState();
    }

    @Test
    void testGetDetailedPlace() {
        JSONObject placeJson = new JSONObject();
        placeJson.put("name", "Test Place");
        placeJson.put("Address", new JSONObject().put("formattedAddress", "123 Test Street"));
        JSONArray coordinatesJson = new JSONArray().put(0.0).put(0.0);
        JSONArray geocodePointsJson = new JSONArray().put(new JSONObject().put("coordinates", coordinatesJson));
        placeJson.put("geocodePoints", geocodePointsJson);
        placeJson.put("Website", "https://example.com");
        DetailedPlace expectedDetailedPlace = new DetailedPlace(placeJson);

        specificState.setDetailedPlace(expectedDetailedPlace);
        DetailedPlace actualDetailedPlace = specificState.getDetailedPlace();

        assertEquals(expectedDetailedPlace, actualDetailedPlace);
    }

    @Test
    void testSetDetailedPlace() {
        JSONObject placeJson = new JSONObject();
        placeJson.put("name", "Test Place");
        placeJson.put("Address", new JSONObject().put("formattedAddress", "123 Test Street"));
        JSONArray coordinatesJson = new JSONArray().put(0.0).put(0.0);
        JSONArray geocodePointsJson = new JSONArray().put(new JSONObject().put("coordinates", coordinatesJson));
        placeJson.put("geocodePoints", geocodePointsJson);
        placeJson.put("Website", "https://example.com");
        DetailedPlace expectedDetailedPlace = new DetailedPlace(placeJson);

        specificState.setDetailedPlace(expectedDetailedPlace);
        DetailedPlace actualDetailedPlace = specificState.getDetailedPlace();

        assertEquals(expectedDetailedPlace, actualDetailedPlace);
    }

    @Test
    void testSetResultsError() {
        String expectedError = "";

        String actualError = specificState.setResultsError(expectedError);

        assertEquals(expectedError, actualError);
    }
}