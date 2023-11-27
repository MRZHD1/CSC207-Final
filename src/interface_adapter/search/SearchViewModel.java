package interface_adapter.search;

import interface_adapter.ViewModel;
import interface_adapter.results.ResultsState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Search View";

    public static final String LOCATION_LABEL = "Enter location";
    public static final String QUERY_LABEL = "Enter destination";

    public static final String NEXT_BUTTON_LABEL = "Next";

    private SearchState state = new SearchState();

    public SearchViewModel() {
        super("search");
    }

    public void setState(SearchState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SearchState getState() {
        return state;
    }
}
