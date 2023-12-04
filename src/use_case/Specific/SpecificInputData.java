package use_case.Specific;

import entity.DetailedPlace;

public class SpecificInputData {


    final private DetailedPlace detailedPlace;

    public SpecificInputData(DetailedPlace detailedPlace) {

        this.detailedPlace = detailedPlace;

    }

    DetailedPlace getDetailedPlace(){

        return detailedPlace;

    }

}
