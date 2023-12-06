package use_case.Specific;
import entity.DetailedPlace;
import org.json.JSONArray;
import use_case.results.ResultsDataAccessInterface;
import use_case.results.ResultsInputBoundary;
import use_case.results.ResultsInputData;
import use_case.results.ResultsOutputBoundary;
import use_case.search.SearchInputData;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputData;

import java.io.IOException;
import java.util.ArrayList;

public class ResultsInteractor implements ResultsInputBoundary {


    final ResultsDataAccessInterface resultsAccessObject;

    final ResultsOutputBoundary resultsPresenter;

    public ResultsInteractor(ResultsDataAccessInterface resultsAccessObject, ResultsOutputBoundary resultsPresenter){
        this.resultsPresenter = resultsPresenter;
        this.resultsAccessObject = resultsAccessObject;
    }

    public void execute(ResultsInputData resultsInput) {

    }

}
