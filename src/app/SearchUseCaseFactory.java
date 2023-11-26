package app;

import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginViewModel;
import interface_adapter.results.ResultsViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchViewModel;
import use_case.search.SearchDataAccessInterface;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import view.SearchPage;

import javax.swing.*;
import java.io.IOException;

public class SearchUseCaseFactory {
    /** Prevent instantiation. */
    private SearchUseCaseFactory() {}

    public static SearchPage create(
            ViewManagerModel viewManagerModel,
            SearchViewModel searchViewModel,
            ResultsViewModel resultsViewModel,
            SearchDataAccessInterface userDataAccessObject) {

        try {
            SearchController searchController = createSearchUseCase(viewManagerModel, searchViewModel, resultsViewModel, userDataAccessObject);
            return new LoginView(loginViewModel, searchController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static LoginController createSearchUseCase(
            ViewManagerModel viewManagerModel,
            SearchViewModel searchViewModel,
            ResultsViewModel resultsViewModel,
            SearchDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SearchOutputBoundary searchOutputBoundary = new SearchPresenter()
        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loggedInViewModel, loginViewModel);

        UserFactory userFactory = new CommonUserFactory();

        SearchInputBoundary searchInputBoundary = new SearchInteractor(
                userDataAccessObject, SearchOutputBoundary);

        return new SearchController(loginInteractor);
    }
}
