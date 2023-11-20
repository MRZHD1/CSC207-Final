package interface_adapter.search;

import interface_adapter.ViewManagerModel;
import use_case.search.SearchOutputBoundary;

public class SearchPresenter implements SearchOutputBoundary {

    private final SearchViewModel searchViewModel;

    private ViewManagerModel viewManagerModel;


    public SearchPresenter(ViewManagerModel viewManagerModel, SearchViewModel searchViewModel) {

        this.viewManagerModel= viewManagerModel;
        this.searchViewModel = searchViewModel;

    }

}
