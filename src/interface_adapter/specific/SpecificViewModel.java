package interface_adapter.specific;

import interface_adapter.ViewModel;
import interface_adapter.specific.SpecificState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SpecificViewModel extends ViewModel {


    private SpecificState state = new SpecificState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SpecificViewModel() {
        super("specific");
    }


    public void setState(SpecificState state) {
        this.state = state;
    }

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SpecificState getState() {
        return this.state;
    }




}
