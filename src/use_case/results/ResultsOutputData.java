package use_case.results;

import entity.DetailedPlace;


public class ResultsOutputData {

    private final DetailedPlace detailedPlace;

    public ResultsOutputData(DetailedPlace detailedPlace){

        this.detailedPlace = detailedPlace;

    }

    public DetailedPlace getSpecific() {
        return detailedPlace;
    }

}
