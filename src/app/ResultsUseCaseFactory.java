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

    public static ResultsView create(ViewManagerModel viewManagerModel,
                                      ResultsViewModel resultsViewModel,
                                      SpecificViewModel specificViewModel){

        try {
            ResultsController resultsController = createResultsUseCase(viewManagerModel, resultsViewModel, specificViewModel);
            return new ResultsView(resultsViewModel, resultsController);


        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Internal Error! Please restart the program.");
        }

        return null;

    }


    private static ResultsController createResultsUseCase(
            ViewManagerModel viewManagerModel,
            ResultsViewModel resultsViewModel,
            SpecificViewModel specificViewModel) throws IOException {

        ResultsOutputBoundary resultsOutputBoundary = new ResultsPresenter(resultsViewModel, specificViewModel, viewManagerModel);
        ResultsInputBoundary resultsInputBoundary = new ResultsInteractor(resultsOutputBoundary);

        return new ResultsController(resultsInputBoundary);
    }



}
