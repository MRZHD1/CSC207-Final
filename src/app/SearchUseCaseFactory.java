package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.results.ResultsViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchPresenter;
import interface_adapter.search.SearchViewModel;
import use_case.search.SearchDataAccessInterface;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import view.SearchView;

import javax.swing.*;
import java.io.IOException;

public class SearchUseCaseFactory {
    /** Prevent instantiation. */
    private SearchUseCaseFactory() {}

    public static SearchView create(
            ViewManagerModel viewManagerModel,
            SearchViewModel searchViewModel,
            ResultsViewModel resultsViewModel,
            SearchDataAccessInterface userDataAccessObject) {

        try {
            SearchController searchController = createSearchUseCase(viewManagerModel, searchViewModel, resultsViewModel, userDataAccessObject);
            return new SearchView(searchController, searchViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Internal Error! Please restart the program.");
        }

        return null;
    }

    private static SearchController createSearchUseCase(
            ViewManagerModel viewManagerModel,
            SearchViewModel searchViewModel,
            ResultsViewModel resultsViewModel,
            SearchDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SearchOutputBoundary searchOutputBoundary = new SearchPresenter(searchViewModel, resultsViewModel, viewManagerModel);
        SearchInputBoundary searchInputBoundary = new SearchInteractor(
                userDataAccessObject, searchOutputBoundary);

        return new SearchController(searchInputBoundary);
    }
}
