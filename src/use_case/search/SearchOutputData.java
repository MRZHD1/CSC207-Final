package use_case.search;

import java.util.ArrayList;

public class SearchOutputData {

    private final ArrayList results;

    public SearchOutputData(ArrayList results) {
        this.results = results;
    }

    public ArrayList getResults() {
        return results;
    }
}
