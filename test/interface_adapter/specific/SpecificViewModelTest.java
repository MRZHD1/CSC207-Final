package interface_adapter.specific;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SpecificViewModelTest {

    private SpecificViewModel specificViewModel;

    @BeforeEach
    void setUp() {
        specificViewModel = new SpecificViewModel();
    }

    @Test
    void testGetState() {
        SpecificState expectedState = new SpecificState();

        specificViewModel.setState(expectedState);
        SpecificState actualState = specificViewModel.getState();

        assertEquals(expectedState, actualState);
    }

    @Test
    void testSetState() {
        SpecificState expectedState = new SpecificState();

        specificViewModel.setState(expectedState);
        SpecificState actualState = specificViewModel.getState();

        assertEquals(expectedState, actualState);
    }




}