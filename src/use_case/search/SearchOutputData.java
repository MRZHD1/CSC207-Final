package use_case.search;

import java.util.ArrayList;

public class SearchOutputData {

    private final ArrayList results;
    private boolean searchFailed;

    public SearchOutputData(ArrayList results, boolean searchFailed) {
        this.results = results;
        this.searchFailed = searchFailed;
    }

    public ArrayList getResults() {
        return results;
    }
}
