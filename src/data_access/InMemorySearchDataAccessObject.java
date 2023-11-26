package data_access;

import org.json.JSONArray;
import use_case.search.SearchDataAccessInterface;

import java.util.ArrayList;

public class InMemorySearchDataAccessObject implements SearchDataAccessInterface {
    private final ArrayList results = new ArrayList();

    @Override
    public void save(JSONArray results) {
        this.results.clear();
        for (Object place:results) {
            System.out.println("PLACE:");
            System.out.println(place);
            this.results.add(place);
        }
    }

    @Override
    public ArrayList getResults() {
        return this.results;
    }
}