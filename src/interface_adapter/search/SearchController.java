package interface_adapter.search;

import use_case.search.SearchInputBoundary;
import use_case.search.SearchInputData;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SearchController {
    final SearchInputBoundary searchUseCaseInteractor;

    public SearchController(SearchInputBoundary searchUseCaseInteractor) {
        this.searchUseCaseInteractor = searchUseCaseInteractor;
    }

    public void execute(String query, String location) throws IOException, InterruptedException {
        SearchInputData searchInput = new SearchInputData(query, location);

        searchUseCaseInteractor.execute(searchInput);
    }
}
