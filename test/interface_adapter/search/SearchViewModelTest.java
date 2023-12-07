package interface_adapter.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchViewModelTest {

    private SearchViewModel searchViewModel;

    @BeforeEach
    void setUp() {
        searchViewModel = new SearchViewModel();
    }

    @Test
    void testGetViewName() {
        String viewName = "search";

        String result = searchViewModel.getViewName();

        assertEquals(viewName, result);
    }

    @Test
    void testSetState() {

        SearchState state = new SearchState();
        searchViewModel.setState(state);

        assertEquals(state, searchViewModel.getState());
    }

    @Test
    void testFirePropertyChanged() {

        SearchState state = new SearchState();
        PropertyChangeListener listener = evt -> {

        };
        searchViewModel.addPropertyChangeListener(listener);

        searchViewModel.setState(state);
        searchViewModel.firePropertyChanged();

        assertEquals(state, searchViewModel.getState());
    }

    @Test
    void testGetState() {
        SearchState state = new SearchState();
        searchViewModel.setState(state);

        SearchState result = searchViewModel.getState();

        assertEquals(state, result);
    }
}