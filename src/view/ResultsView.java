package view;

import entity.DetailedPlace;
import interface_adapter.results.ResultsState;
import interface_adapter.results.ResultsViewModel;
import interface_adapter.results.ResultsState;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ResultsView extends JPanel implements ActionListener, PropertyChangeListener{

    public final String viewName = "results";

    private final ResultsViewModel resultsViewModel;

    JLabel query1;
    JLabel query2;

    JLabel query3;

    JLabel query4;

    final JButton quit;


    public ResultsView(ResultsViewModel resultsViewModel){

        this.resultsViewModel = resultsViewModel;
        this.resultsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("List of Queries");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        quit = new JButton(resultsViewModel.QUIT_BUTTON_LABEL);
        buttons.add(quit);



        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);

    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ResultsState state = (ResultsState) evt.getNewValue();
        ArrayList<DetailedPlace> ResultsArray = state.getResults();
        for (DetailedPlace place: ResultsArray) {
            JLabel name = new JLabel(place.getName());
            this.add(name);
            this.add(new JLabel());
        }
    }
}
