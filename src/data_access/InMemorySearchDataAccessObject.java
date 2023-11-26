package data_access;

import entity.Place;
import use_case.search.SearchDataAccessInterface;

import java.util.ArrayList;

public class InMemorySearchDataAccessObject implements SearchDataAccessInterface {
    private final ArrayList results = new ArrayList();

    @Override
    public void save(ArrayList results) {
        this.results.clear();
        for (Object place:results.subList(0,4)) {
            System.out.println(place);
            this.results.add(place);
        }
    }

    @Override
    public ArrayList getResults() {
        return this.results;
    }
}