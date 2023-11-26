package interface_adapter.results;

import javax.xml.transform.Result;
import java.util.ArrayList;

public class ResultsState {
    private ArrayList results = new ArrayList<>();
    public ResultsState(ResultsState copy) {
        results = copy.results;
    }
    public ResultsState(){
    }
    public ArrayList getResults() {
        return results;
    }
    public void setResults(ArrayList results){
        this.results = results;
    }
}
