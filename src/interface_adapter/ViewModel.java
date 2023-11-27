package interface_adapter;

import java.beans.PropertyChangeListener;

public abstract class ViewModel {

    public static String TITLE_LABEL;
    private String viewName;

    public ViewModel(String viewName) {
        this.viewName = viewName;
    }
    public String getViewName() {
        return this.viewName;
    }

    public abstract void firePropertyChanged();
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);


}
