package interface_adapter.results;

import entity.DetailedPlace;
import interface_adapter.search.SearchState;

import javax.xml.transform.Result;
import java.util.ArrayList;

public class ResultsState {

    private String resultsError = "";

    private ArrayList<DetailedPlace> results = new ArrayList<>();

    public ResultsState(){
    }
    public ArrayList<DetailedPlace> getResults() {
        return this.results;
    }
    public void setResults(ArrayList<DetailedPlace> results){
        this.results = results;
    }

    public String setResultsError(String resultsError) {
        return this.resultsError;
    }
}
