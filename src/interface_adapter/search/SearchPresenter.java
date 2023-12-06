package interface_adapter.search;

import interface_adapter.ViewManagerModel;
import interface_adapter.results.ResultsState;
import interface_adapter.results.ResultsViewModel;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;

public class SearchPresenter implements SearchOutputBoundary {
    private final SearchViewModel searchViewModel;
    private final ResultsViewModel resultsViewModel;
    private ViewManagerModel viewManagerModel;

    public SearchPresenter(SearchViewModel searchViewModel,
                           ResultsViewModel resultsViewModel,
                           ViewManagerModel viewManagerModel) {
        this.searchViewModel = searchViewModel;
        this.resultsViewModel = resultsViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(SearchOutputData response) {

        ResultsState resultsState = resultsViewModel.getState();
        resultsState.setResults(response.getResults());
        this.resultsViewModel.setState(resultsState);
        this.resultsViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(resultsViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SearchState searchState = searchViewModel.getState();
        searchState.setSearchError(error);
        this.searchViewModel.setState(searchState);
        this.searchViewModel.firePropertyChanged();
    }
}
