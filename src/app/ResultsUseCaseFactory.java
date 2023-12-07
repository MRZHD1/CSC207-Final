package app;
import interface_adapter.ViewManagerModel;
import interface_adapter.results.ResultsController;
import interface_adapter.results.ResultsPresenter;
import interface_adapter.results.ResultsViewModel;
import interface_adapter.search.SearchController;

import interface_adapter.specific.SpecificViewModel;
import use_case.results.ResultsDataAccessInterface;
import use_case.results.ResultsInputBoundary;
import use_case.results.ResultsInteractor;
import use_case.results.ResultsOutputBoundary;

import view.ResultsView;

import view.SpecificView;

import javax.swing.*;
import java.io.IOException;

public class ResultsUseCaseFactory {


    private ResultsUseCaseFactory(){}

    public static SpecificView create(ViewManagerModel viewManagerModel,
                                      ResultsViewModel resultsViewModel,
                                      SpecificViewModel specificViewModel,
                                      ResultsDataAccessInterface resultsDataAccessObject){


        try {
            ResultsController resultsController = createResultsUseCase(viewManagerModel, resultsViewModel, specificViewModel, resultsDataAccessObject);
            return new ResultsView(resultsViewModel, resultsController);
            // DO WE PROVIDE RESULTSVIEW HERE OR SPECIFIC VIEW?


        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Internal Error! Please restart the program.");
        }

        return null;



    }


    private static ResultsController createResultsUseCase(
            ViewManagerModel viewManagerModel,
            ResultsViewModel resultsViewModel,
            SpecificViewModel specificViewModel,
            ResultsDataAccessInterface resultsDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        ResultsOutputBoundary resultsOutputBoundary = new ResultsPresenter(resultsViewModel, specificViewModel, viewManagerModel);
        ResultsInputBoundary resultsInputBoundary = new ResultsInteractor(
                resultsDataAccessObject, resultsOutputBoundary);

        return new ResultsController(resultsInputBoundary);
    }



}
