package data_access;

import entity.DetailedPlace;
import org.json.JSONArray;
import org.json.JSONObject;
import use_case.search.SearchDataAccessInterface;

import java.util.ArrayList;

public class InMemorySearchDataAccessObject implements SearchDataAccessInterface {
    private final ArrayList<DetailedPlace> results = new ArrayList<DetailedPlace>();

    @Override
    public void save(JSONArray results) {
        this.results.clear();
        for (int i = 0; i < results.length(); i++) {
            JSONObject place = results.getJSONObject(i);
            this.results.add(new DetailedPlace(place));
        }
    }

    @Override
    public ArrayList<entity.DetailedPlace> getResults() {
        return this.results;
    }
}