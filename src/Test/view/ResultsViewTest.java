package view;

import entity.DetailedPlace;
import interface_adapter.results.ResultsState;
import interface_adapter.results.ResultsViewModel;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResultsViewTest {

    private ResultsViewModel resultsViewModel;
    private ResultsView resultsView;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        ResultsViewModel resultsViewModel = new ResultsViewModel();
        resultsView = new ResultsView(resultsViewModel);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testActionPerformedWhenButtonClicked() {
        // Arrange
        ActionEvent actionEvent = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "TestAction");

        resultsView.actionPerformed(actionEvent);

        assertEquals("Click TestAction\n", outContent.toString());
    }



    @Test
    public void testJRadioButtonsSelection() {
        ResultsState resultsState = new ResultsState();

        String str1 = "{\"Address\":{\"formattedAddress\":\"address\"},\"entityType\":\"Restaurant\",\"name\":\"Starbucks\",\"Website\":\"https://www.starbucks.com/store-locator/store/1008913/\",\"geocodePoints\":[{\"calculationMethod\":\"Rooftop\",\"coordinates\":[38.89933014,-77.026474],\"type\":\"Point\"}]}";
        String str2 = "{\"Address\":{\"formattedAddress\":\"address\"},\"entityType\":\"Restaurant\",\"name\":\"McDonald's\",\"Website\":\"https://www.mcdonalds.com/\",\"geocodePoints\":[{\"calculationMethod\":\"Rooftop\",\"coordinates\":[40.712776,-74.005974],\"type\":\"Point\"}]}";
        JSONObject place1 = new JSONObject(str1);
        JSONObject place2 = new JSONObject(str2);
        DetailedPlace dummy1 = new DetailedPlace(place1);
        DetailedPlace dummy2 = new DetailedPlace(place2);

        resultsState.getResults().add(dummy1);
        resultsState.getResults().add(dummy2);
        resultsView.propertyChange(new PropertyChangeEvent(this, "state", null, resultsState));

        // Simulate selecting the first radio button
        JRadioButton radioButton1 = null;
        for (Component component : resultsView.getComponents()) {
            if (component instanceof JPanel) {
                JPanel placePanel = (JPanel) component;
                for (Component innerComponent : placePanel.getComponents()) {
                    if (innerComponent instanceof JRadioButton) {
                        radioButton1 = (JRadioButton) innerComponent;
                        break;
                    }
                }
            }
        }
        if (radioButton1 != null) {
            radioButton1.setSelected(true);
            resultsView.handleRadioButtonSelection(dummy1);
        }

        String expectedOutput = "Selected Place: Starbucks";
        assertTrue(outContent.toString().contains(expectedOutput),
                "Expected output to contain: " + expectedOutput);
    }

}