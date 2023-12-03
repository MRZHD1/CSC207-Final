package view;

import entity.DetailedPlace;
import interface_adapter.results.ResultsState;
import interface_adapter.results.ResultsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ResultsView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "results";

    private final ResultsViewModel resultsViewModel;
    final JButton quit;

    public ResultsView(ResultsViewModel resultsViewModel) {
        this.resultsViewModel = resultsViewModel;
        this.resultsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("List of Queries");
        title.setBorder(BorderFactory.createEmptyBorder(0, 300, 20, 0));

        quit = new JButton("Quit");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle quit button action (e.g., closing the application)
                System.exit(0);
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);

        // Add quit button to the panel
        this.add(quit);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ResultsState state = (ResultsState) evt.getNewValue();
        ArrayList<DetailedPlace> ResultsArray = state.getResults();

        for (DetailedPlace place : ResultsArray) {
            JLabel name = new JLabel(place.getName());
            JLabel address = new JLabel(place.getAddress());
            this.add(name);
            this.add(address);

            address.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 0));

            name.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 0));

            // Add vertical strut for spacing
            this.add(Box.createVerticalStrut(20));  // Adjust the value (10) for your preferred spacing
        }

        // Add quit button to the panel after detailed places
        this.add(quit);

    }
}
