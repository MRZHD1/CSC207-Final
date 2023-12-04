package use_case.Specific;

import entity.DetailedPlace;

import java.util.ArrayList;

public class SpecificOutputData {

    private final DetailedPlace detailedPlace;

    public SpecificOutputData(DetailedPlace detailedPlace){

        this.detailedPlace = detailedPlace;

    }

    public DetailedPlace getDetailedPlace() {
        return detailedPlace;
    }
}
