package interface_adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ViewManagerModelTest {

    private ViewManagerModel viewManagerModel;
    private boolean propertyChangeCalled;

    @BeforeEach
    void setUp() {
        viewManagerModel = new ViewManagerModel();
        propertyChangeCalled = false;
    }

    @Test
    void testGetActiveView() {

        String expectedActiveView = "Home";

        viewManagerModel.setActiveView(expectedActiveView);
        String actualActiveView = viewManagerModel.getActiveView();

        assertEquals(expectedActiveView, actualActiveView);
    }

    @Test
    void testFirePropertyChanged() {

        String expectedPropertyName = "view";
        String expectedOldValue = null;
        String expectedNewValue = "Results";
        viewManagerModel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                propertyChangeCalled = true;
                assertEquals(expectedPropertyName, evt.getPropertyName());
                assertEquals(expectedOldValue, evt.getOldValue());
                assertEquals(expectedNewValue, evt.getNewValue());
            }
        });

        viewManagerModel.setActiveView(expectedNewValue);
        viewManagerModel.firePropertyChanged();

        assertTrue(propertyChangeCalled);
    }
}