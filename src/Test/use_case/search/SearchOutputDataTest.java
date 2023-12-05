package use_case.search;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchOutputDataTest {

    @Test
    void testGetResults() {
        // Arrange
        ArrayList<String> results = new ArrayList<>();
        results.add("Result 1");
        results.add("Result 2");
        SearchOutputData searchOutputData = new SearchOutputData(results);

        // Act
        ArrayList<String> actualResults = searchOutputData.getResults();

        // Assert
        assertEquals(results, actualResults, "Results should match the expected results");
    }

    @Test
    void testGetResultsNoResults() {
        // Arrange
        ArrayList<String> results = new ArrayList<>();
        SearchOutputData searchOutputData = new SearchOutputData(results);

        // Act
        ArrayList<String> actualResults = searchOutputData.getResults();

        // Assert
        assertEquals(results, actualResults, "Results should be an empty list");
    }
}