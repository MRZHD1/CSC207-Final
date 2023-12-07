package use_case.results;

import entity.DetailedPlace;

public class ResultsInputData {


    final private DetailedPlace detailedPlace;

    public ResultsInputData(DetailedPlace detailedPlace) {

        this.detailedPlace = detailedPlace;

    }

    DetailedPlace getDetailedPlace(){

        return detailedPlace;

    }

}
