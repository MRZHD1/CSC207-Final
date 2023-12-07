package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;

import entity.DetailedPlace;
import interface_adapter.results.ResultsState;
import interface_adapter.specific.SpecificState;
import interface_adapter.specific.SpecificViewModel;

public class SpecificView extends JPanel implements ActionListener, PropertyChangeListener{


    public final String viewName = "specific";
    private final SpecificViewModel specificViewModel;

    private JButton quitButton;

    public SpecificView(SpecificViewModel specificViewModel) {
        this.specificViewModel = specificViewModel;
        this.specificViewModel.addPropertyChangeListener(this);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(this);

        add(quitButton);

        JLabel title = new JLabel("More Details");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(0, 100, 50, 0));

    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        if (evt.getSource() == quitButton){
            System.exit(0);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SpecificState state = (SpecificState) evt.getNewValue();
        DetailedPlace detailedPlace = state.getDetailedPlace();
        System.out.println(detailedPlace.getName());


        ButtonGroup buttonGroup = new ButtonGroup();

    }


}





