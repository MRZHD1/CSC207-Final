package use_case.results;

import entity;
import entity.User;

public class ResultsInteractor implements ResultsInputBoundary{


    final ResultDataAccessInterface resultDataAccessObject;
    final ResultsOutputBoundary resultPresenter;

    public ResultsInteractor(ResultDataAccessInterface resultDataAccessInterface,
                           ResultOutputBoundary resultOutputBoundary) {
        this.resultDataAccessObject = resultDataAccessInterface;
        this.resultPresenter = resultOutputBoundary;
    }



    @Override
    public void execute(ResultInputData resultInputData) {
        String username = resultInputData.getQuery_of_interest();
        User user = userDataAccessObject.get(loginInputData.getUsername());


        // getName gets the name of the user from the entity, we switch it to query of interest?
        ResultsOutputData resultsOutputData = new ResultsOutputData(result.getName(), false);
        resultPresenter.prepareSuccessView(resultOutputData);

        }
    }



}
