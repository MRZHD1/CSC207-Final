package use_case.search;

import org.json.JSONArray;

import java.util.ArrayList;

public interface SearchDataAccessInterface {
    void save(JSONArray results);

    ArrayList getResults();
}
