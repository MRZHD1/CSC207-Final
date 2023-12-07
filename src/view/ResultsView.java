package view;

import entity.*;
import entity.DetailedPlace;
import interface_adapter.results.ResultsController;
import interface_adapter.results.ResultsState;
import interface_adapter.results.ResultsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ButtonGroup;

public class ResultsView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "results";

    private final ResultsViewModel resultsViewModel;
    private final ResultsController resultsController;
    final JButton quit;
    final JButton nextButton;
    public DetailedPlace selectedPlace;

    public ResultsView(ResultsViewModel resultsViewModel, ResultsController resultsController) {
        this.resultsViewModel = resultsViewModel;
        this.resultsViewModel.addPropertyChangeListener(this);
        this.resultsController = resultsController;

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

        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleNextButtonClicked();
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(nextButton);
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

            radioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleRadioButtonSelection(place);
                }
            });

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

        this.add(nextButton);
        this.add(quit);
        quit.setBorder(BorderFactory.createEmptyBorder(0, 400, 0, 0));
    }

    void handleRadioButtonSelection(DetailedPlace selectedPlace) {
        // Do something with the radio button here
        System.out.println("Selected Place: " + selectedPlace.getName());
        this.selectedPlace = selectedPlace;
        // i can extend this method to perform additional actions based on the selected place
    }

    void handleNextButtonClicked() {
        try {
            this.resultsController.execute(this.selectedPlace);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}