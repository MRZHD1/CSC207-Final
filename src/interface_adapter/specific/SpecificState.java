package interface_adapter.specific;

import entity.DetailedPlace;

import java.util.ArrayList;

public class SpecificState {

    private String specificError = "";

    private ArrayList<DetailedPlace> specific = new ArrayList<>();

    public SpecificState(){
    }
    public ArrayList<DetailedPlace> getResults() {
        return this.specific;
    }
    public void setSpecific(ArrayList<DetailedPlace> results){
        this.specific = specific;
    }

    public String setResultsError(String resultsError) {
        return this.specificError;
    }



}
