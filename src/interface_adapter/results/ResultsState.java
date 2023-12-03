package interface_adapter.results;

import entity.DetailedPlace;

import javax.xml.transform.Result;
import java.util.ArrayList;

public class ResultsState {
    private ArrayList<DetailedPlace> results = new ArrayList<>();
    public ResultsState(ResultsState copy) {
        this.results = copy.results;
    }
    public ResultsState(){
    }
    public ArrayList<DetailedPlace> getResults() {
        return this.results;
    }
    public void setResults(ArrayList<DetailedPlace> results){
        this.results = results;
    }
}
