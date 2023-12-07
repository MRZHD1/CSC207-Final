package app;

import data_access.FileUserDataAccessObject;
import data_access.InMemorySearchDataAccessObject;
import entity.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.results.ResultsViewModel;
import interface_adapter.search.SearchViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.specific.SpecificViewModel;
import use_case.results.ResultsDataAccessInterface;
import use_case.search.SearchDataAccessInterface;
import view.*;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        JFrame application = new JFrame("Place Search");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setPreferredSize(new Dimension(700, 800));

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SearchViewModel searchViewModel = new SearchViewModel();
        ResultsViewModel resultsViewModel = new ResultsViewModel();

        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SearchDataAccessInterface searchDataAccessInterface = new InMemorySearchDataAccessObject();

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, searchViewModel, userDataAccessObject);
        views.add(loginView, loginView.viewName);

        SearchView searchView = SearchUseCaseFactory.create(viewManagerModel,searchViewModel,resultsViewModel,searchDataAccessInterface);
        views.add(searchView, searchView.viewName);

        SpecificViewModel specificViewModel = new SpecificViewModel();

        ResultsView resultsView = ResultsUseCaseFactory.create(viewManagerModel, resultsViewModel,
                specificViewModel);
        views.add(resultsView, resultsView.viewName);

        SpecificView specificView = new SpecificView(specificViewModel);
        views.add(specificView, specificView.viewName);


        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }
}