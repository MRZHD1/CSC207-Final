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
import javax.swing.ButtonGroup;

public class ResultsView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "results";

    private final ResultsViewModel resultsViewModel;
    final JButton quit;

    public ResultsView(ResultsViewModel resultsViewModel) {
        this.resultsViewModel = resultsViewModel;
        this.resultsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("List of Queries");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(0, 100, 50, 0));

        quit = new JButton("Quit");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);

        this.add(quit);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ResultsState state = (ResultsState) evt.getNewValue();
        ArrayList<DetailedPlace> resultsArray = state.getResults();


        ButtonGroup buttonGroup = new ButtonGroup();

        for (DetailedPlace place : resultsArray) {
            JLabel name = new JLabel(place.getName());
            JLabel address = new JLabel(place.getAddress());

            JRadioButton radioButton = new JRadioButton();
            // ADD ACTION LISTENER HERE FOR THE USE CASE!!!

            buttonGroup.add(radioButton);

            JPanel placePanel = new JPanel();
            placePanel.setLayout(new BorderLayout());

            JPanel textPanel = new JPanel();
            textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
            textPanel.add(name);
            textPanel.add(address);
            placePanel.add(textPanel, BorderLayout.CENTER);

            placePanel.add(Box.createHorizontalGlue(), BorderLayout.EAST);
            placePanel.add(radioButton, BorderLayout.LINE_END);

            this.add(placePanel);

            address.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
            name.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));

            this.add(Box.createVerticalStrut(0));
        }

        this.add(quit);
        quit.setBorder(BorderFactory.createEmptyBorder(0, 400, 0, 0));
    }
}
