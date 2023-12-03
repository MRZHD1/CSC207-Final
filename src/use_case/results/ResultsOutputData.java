package use_case.results;

public class ResultsOutputData {

    private final String user_query;

    public ResultsOutputData(String user_query) {
        this.user_query = user_query;
    }


    public String getUser_query() {
        return user_query;
    }

}
