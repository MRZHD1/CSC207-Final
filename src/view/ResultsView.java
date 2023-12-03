package view;

import interface_adapter.results.ResultsState;
import interface_adapter.results.ResultsViewModel;
import interface_adapter.results.ResultsState;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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

        JLabel query1info = new JLabel("First Result: ");
        query1 = new JLabel();

        JLabel query2info = new JLabel("Second Result: ");
        query2 = new JLabel();

        JLabel query3info = new JLabel("Third Result: ");
        query3 = new JLabel();

        JLabel query4info = new JLabel("Fourth Result ");
        query4 = new JLabel();

        JPanel buttons = new JPanel();
        quit = new JButton(resultsViewModel.QUIT_BUTTON_LABEL);
        buttons.add(quit);



        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(query1info);
        this.add(query1);
        this.add(query2info);
        this.add(query3);
        this.add(query3info);
        this.add(query4);
        this.add(query4info);

    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ResultsState state = (ResultsState) evt.getNewValue();
        query1.setText("DUMMY TEXT OMEGALUL");
    }
}
