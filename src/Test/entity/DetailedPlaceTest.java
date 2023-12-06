package entity;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DetailedPlaceTest {

    @Test
    public void testGetCoordinatesValid() {

        JSONObject place = new JSONObject()
                .put("geocodePoints", new JSONArray()
                        .put(new JSONObject()
                                .put("coordinates", new JSONArray("[34.052235,-118.243683]"))))
                .put("name", "Some Place")
                .put("Address", new JSONObject().put("formattedAddress", "123 Main St"));
        DetailedPlace detailedPlace = new DetailedPlace(place);


        String coordinates = detailedPlace.getCoordinates();


        Assertions.assertEquals("34.052235,-118.243683", coordinates);
    }

    @Test
    public void testGetAddresValid() {

        JSONObject place = new JSONObject()
                .put("Address", new JSONObject().put("formattedAddress", "123 Main St"))
                .put("name", "Some Place")
                .put("geocodePoints", new JSONArray()
                        .put(new JSONObject()
                                .put("coordinates", new JSONArray("[34.052235, -118.243683]"))));
        DetailedPlace detailedPlace = new DetailedPlace(place);


        String address = detailedPlace.getAddress();


        Assertions.assertEquals("123 Main St", address);
    }

    @Test
    public void testGetNameValid() {

        JSONObject place = new JSONObject()
                .put("name", "Some Place")
                .put("Address", new JSONObject().put("formattedAddress", "123 Main St"))
                .put("geocodePoints", new JSONArray()
                        .put(new JSONObject()
                                .put("coordinates", new JSONArray("[34.052235, -118.243683]"))));
        DetailedPlace detailedPlace = new DetailedPlace(place);


        String name = detailedPlace.getName();


        Assertions.assertEquals("Some Place", name);
    }

    @Test
    public void testGetWebsiteValid() {

        JSONObject place = new JSONObject()
                .put("Website", "http://www.example.com")
                .put("name", "Some Place")
                .put("Address", new JSONObject().put("formattedAddress", "123 Main St"))
                .put("geocodePoints", new JSONArray()
                        .put(new JSONObject()
                                .put("coordinates", new JSONArray("[34.052235, -118.243683]"))));
        DetailedPlace detailedPlace = new DetailedPlace(place);


        String website = detailedPlace.getWebsite();


        Assertions.assertEquals("http://www.example.com", website);
    }

    @Test
    public void testGetWebsite() {
        JSONObject place = new JSONObject()
                .put("name", "Some Place")
                .put("Address", new JSONObject().put("formattedAddress", "123 Main St"))
                .put("geocodePoints", new JSONArray()
                        .put(new JSONObject()
                                .put("coordinates", new JSONArray("[34.052235, -118.243683]"))));
        DetailedPlace detailedPlace = new DetailedPlace(place);

        String website = detailedPlace.getWebsite();

        Assertions.assertEquals("", website);
    }
}