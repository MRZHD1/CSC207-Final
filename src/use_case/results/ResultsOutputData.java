package use_case.results;

import entity.DetailedPlace;

import java.util.ArrayList;


public class ResultsOutputData {

    private final DetailedPlace detailedPlace;

    public ResultsOutputData(DetailedPlace detailedPlace){

        this.detailedPlace = detailedPlace;

    }

    public DetailedPlace getDetailedPlace() {
        return detailedPlace;
    }
}
