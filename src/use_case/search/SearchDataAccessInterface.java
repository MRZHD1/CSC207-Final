package use_case.search;

import entity.Place;

import java.util.ArrayList;

public interface SearchDataAccessInterface {
    void save(ArrayList results);

    ArrayList getResults();
}
