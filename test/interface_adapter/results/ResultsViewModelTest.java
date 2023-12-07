package interface_adapter.results;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;
import static org.junit.jupiter.api.Assertions.*;

class ResultsViewModelTest {

    private ResultsViewModel resultsViewModel;
    private PropertyChangeListener listener;

    @BeforeEach
    void setUp() {
        resultsViewModel = new ResultsViewModel();
        listener = evt -> {
        };
    }

    @Test
    void testGetViewName() {
        String expectedViewName = "results";

        String actualViewName = resultsViewModel.getViewName();

        assertEquals(expectedViewName, actualViewName);
    }



    @Test
    void testSetState() {
        ResultsState expectedState = new ResultsState();

        resultsViewModel.setState(expectedState);
        ResultsState actualState = resultsViewModel.getState();

        assertEquals(expectedState, actualState);
    }

    @Test
    void testGetState() {
        ResultsState expectedState = new ResultsState();
        resultsViewModel.setState(expectedState);

        ResultsState actualState = resultsViewModel.getState();

        assertEquals(expectedState, actualState);
    }
}