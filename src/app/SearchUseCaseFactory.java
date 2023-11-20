package app;

import interface_adapter.search.SearchController;
import use_case.search.SearchDataAccessInterface;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.*;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import interface_adapter.search.SearchViewModel;
import view.SearchView;

import javax.swing.*;
import java.io.IOException;

public class SignupUseCaseFactory {

    /** Prevent instantiation. */
    private SignupUseCaseFactory() {}

    public static SearchView create(
            ViewManagerModel viewManagerModel, SearchView searchViewModel, SearchDataAccessInterface userDataAccessObject) {

        try {
            SearchController searchController = createSearchUseCase(viewManagerModel, signupViewModel, userDataAccessObject);
            return new SearchView(searchController, signupViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SearchController createSearchUseCase(ViewManagerModel viewManagerModel, SearchViewModel searchViewModel, SearchDataAccessInterface searchDataAccessInterface) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SearchOutputBoundary signupOutputBoundary = new SearchPresenter(viewManagerModel, searchViewModel);

        UserFactory userFactory = new CommonUserFactory();

        SearchInputBoundary userSignupInteractor = new SearchInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        return new SignupController(userSignupInteractor);
    }
}

