package entity;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DetailedPlaceTest {

    @Test
    public void testGetCoordinatesWhenCoordinatesPresentThenReturnCoordinates() {
        // Arrange
        JSONObject place = new JSONObject()
                .put("geocodePoints", new JSONArray()
                        .put(new JSONObject()
                                .put("coordinates", new JSONArray("[34.052235,-118.243683]"))))
                .put("name", "Some Place")
                .put("Address", new JSONObject().put("formattedAddress", "123 Main St"));
        DetailedPlace detailedPlace = new DetailedPlace(place);

        // Act
        String coordinates = detailedPlace.getCoordinates();

        // Assert
        Assertions.assertEquals("34.052235,-118.243683", coordinates);
    }

    @Test
    public void testGetAddressWhenAddressPresentThenReturnAddress() {
        // Arrange
        JSONObject place = new JSONObject()
                .put("Address", new JSONObject().put("formattedAddress", "123 Main St"))
                .put("name", "Some Place")
                .put("geocodePoints", new JSONArray()
                        .put(new JSONObject()
                                .put("coordinates", new JSONArray("[34.052235, -118.243683]"))));
        DetailedPlace detailedPlace = new DetailedPlace(place);

        // Act
        String address = detailedPlace.getAddress();

        // Assert
        Assertions.assertEquals("123 Main St", address);
    }

    @Test
    public void testGetNameWhenNamePresentThenReturnName() {
        // Arrange
        JSONObject place = new JSONObject()
                .put("name", "Some Place")
                .put("Address", new JSONObject().put("formattedAddress", "123 Main St"))
                .put("geocodePoints", new JSONArray()
                        .put(new JSONObject()
                                .put("coordinates", new JSONArray("[34.052235, -118.243683]"))));
        DetailedPlace detailedPlace = new DetailedPlace(place);

        // Act
        String name = detailedPlace.getName();

        // Assert
        Assertions.assertEquals("Some Place", name);
    }

    @Test
    public void testGetWebsiteWhenWebsitePresentThenReturnWebsite() {
        // Arrange
        JSONObject place = new JSONObject()
                .put("Website", "http://www.example.com")
                .put("name", "Some Place")
                .put("Address", new JSONObject().put("formattedAddress", "123 Main St"))
                .put("geocodePoints", new JSONArray()
                        .put(new JSONObject()
                                .put("coordinates", new JSONArray("[34.052235, -118.243683]"))));
        DetailedPlace detailedPlace = new DetailedPlace(place);

        // Act
        String website = detailedPlace.getWebsite();

        // Assert
        Assertions.assertEquals("http://www.example.com", website);
    }

    @Test
    public void testGetWebsiteWhenWebsiteNotPresentThenReturnEmptyString() {
        // Arrange
        JSONObject place = new JSONObject()
                .put("name", "Some Place")
                .put("Address", new JSONObject().put("formattedAddress", "123 Main St"))
                .put("geocodePoints", new JSONArray()
                        .put(new JSONObject()
                                .put("coordinates", new JSONArray("[34.052235, -118.243683]"))));
        DetailedPlace detailedPlace = new DetailedPlace(place);

        // Act
        String website = detailedPlace.getWebsite();

        // Assert
        Assertions.assertEquals("", website);
    }
}