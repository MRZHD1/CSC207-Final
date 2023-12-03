package use_case.results;

public class ResultsInputData {


    final private String query_of_interest;

    public ResultsInputData(String query_of_interest) {
        this.query_of_interest = query_of_interest;
    }


    String getQuery_of_interest() {
        return query_of_interest;
    }


}
