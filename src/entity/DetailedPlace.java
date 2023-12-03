package entity;

import org.json.JSONException;
import org.json.JSONObject;

public class DetailedPlace implements Place{
    private final String name;
    private final String address;
    private final String coordinates;
    private final String website;
    public DetailedPlace(JSONObject place) {
        this.name = place.getString("name");
        this.address = place.getJSONObject("Address").getString("formattedAddress");
        String coordinates = place.getJSONArray("geocodePoints").getJSONObject(0).
                getJSONArray("coordinates").toString();
        this.coordinates = coordinates.replace("[","").replace("]","");
        String website = "";
        try {website = place.getString("Website");} catch (JSONException ignored) {}
        this.website = website;
        System.out.println(this.website);
    }
    @Override
    public String getCoordinates() {
        return this.coordinates;
    }

    @Override
    public String getAddress() {
        return this.address;
    }
    public String getName() {
        return this.name;
    }
    public String getWebsite() {
        return this.website;
    }
}
