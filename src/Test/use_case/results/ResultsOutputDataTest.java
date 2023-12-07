package use_case.results;

import entity.DetailedPlace;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultsOutputDataTest {

    @Test
    public void testGetDetailedPlace() {
        JSONObject placeJson = new JSONObject();
        placeJson.put("name", "Test Place");
        placeJson.put("Address", new JSONObject().put("formattedAddress", "123 Test St"));
        JSONArray coordinatesArray = new JSONArray().put(40.7128).put(-74.0060);
        JSONArray geocodePointsArray = new JSONArray().put(new JSONObject().put("coordinates", coordinatesArray));
        placeJson.put("geocodePoints", geocodePointsArray);
        placeJson.put("Website", "http://testplace.com");
        DetailedPlace detailedPlace = new DetailedPlace(placeJson);

        ResultsOutputData resultsOutputData = new ResultsOutputData(detailedPlace);

        DetailedPlace result = resultsOutputData.getDetailedPlace();

        assertEquals(detailedPlace, result, "The returned DetailedPlace object should be the same as the one passed to the constructor");
    }
}