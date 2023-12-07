package use_case.results;
import entity.DetailedPlace;
import org.json.JSONArray;
import use_case.results.ResultsDataAccessInterface;
import use_case.results.ResultsInputBoundary;
import use_case.results.ResultsInputData;
import use_case.results.ResultsOutputBoundary;


public class ResultsInteractor implements ResultsInputBoundary {


    final ResultsOutputBoundary resultsPresenter;

    public ResultsInteractor(ResultsOutputBoundary resultsPresenter){
        this.resultsPresenter = resultsPresenter;
    }

    public void execute(ResultsInputData resultsInput) {
        ResultsOutputData resultsOutputData = new ResultsOutputData(resultsInput.getDetailedPlace());
        resultsPresenter.prepareSuccessView(resultsOutputData);
    }

}
