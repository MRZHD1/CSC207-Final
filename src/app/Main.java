package app;

import data_access.InMemorySearchDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.results.ResultsViewModel;
import interface_adapter.search.SearchViewModel;
import interface_adapter.specific.SpecificViewModel;
import use_case.search.SearchDataAccessInterface;
import view.ResultsView;
import view.SearchView;
import view.SpecificView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;


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

        SearchViewModel searchViewModel = new SearchViewModel();
        ResultsViewModel resultsViewModel = new ResultsViewModel();

        SearchDataAccessInterface searchDataAccessInterface = new InMemorySearchDataAccessObject();

        SearchView searchView = SearchUseCaseFactory.create(viewManagerModel,searchViewModel,resultsViewModel,searchDataAccessInterface);
        views.add(searchView, searchView.viewName);


        ResultsView resultsView = new ResultsView(resultsViewModel);
        views.add(resultsView, resultsView.viewName);

        SpecificView specificView = new SpecificView(new SpecificViewModel());
        views.add(specificView, specificView.viewName);


        viewManagerModel.setActiveView(searchView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }
}