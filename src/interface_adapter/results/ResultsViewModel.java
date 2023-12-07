package interface_adapter.results;

import interface_adapter.ViewModel;
import interface_adapter.search.SearchState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ResultsViewModel extends ViewModel {

    private ResultsState state = new ResultsState();

    public static final String QUIT_BUTTON_LABEL = "Quit";

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ResultsViewModel() {
        super("results");
    }

    public void setState(ResultsState state) {
        this.state = state;
    }

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ResultsState getState() {
        return this.state;
    }


}
