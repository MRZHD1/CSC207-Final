package use_case.results;
import entity.DetailedPlace;

public interface ResultsDataAccessInterface {


    void save(DetailedPlace detailedPlace);

    DetailedPlace get(String placeName);


}
