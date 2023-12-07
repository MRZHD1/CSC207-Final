package interface_adapter.specific;

import entity.DetailedPlace;

import java.util.ArrayList;

public class SpecificState {

    private String specificError = "";

    private DetailedPlace detailedPlace = null;

    public SpecificState(){
    }
    public DetailedPlace getDetailedPlace() {
        return this.detailedPlace;
    }
    public void setDetailedPlace(DetailedPlace detailedPlace){
        this.detailedPlace = detailedPlace;
    }

    public String setResultsError(String resultsError) {
        return this.specificError;
    }



}
