package use_case.Specific;
import entity.DetailedPlace;

public interface SpecificDataAccessInterface {


    void save(DetailedPlace detailedPlace);

    DetailedPlace get(String placeName);


}
