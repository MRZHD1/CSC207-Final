package interface_adapter.results;

import entity.DetailedPlace;
import use_case.results.ResultsInputBoundary;
import use_case.results.ResultsInputData;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInputData;

import java.io.IOException;

public class ResultsController {

    final ResultsInputBoundary resultsUseCaseInteractor;

    public ResultsController(ResultsInputBoundary resultsUseCaseInteractor) {
        this.resultsUseCaseInteractor = resultsUseCaseInteractor;
    }

    public void execute(DetailedPlace selectedPlace) throws IOException, InterruptedException {
        ResultsInputData resultsInput = new ResultsInputData(selectedPlace);

        resultsUseCaseInteractor.execute(resultsInput);
    }


}
