package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.border.EmptyBorder;

import entity.DetailedPlace;
import interface_adapter.specific.SpecificState;
import interface_adapter.specific.SpecificViewModel;

public class SpecificView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "specific";
    private final SpecificViewModel specificViewModel;

    private JButton quitButton;

    public SpecificView(SpecificViewModel specificViewModel) {
        this.specificViewModel = specificViewModel;
        this.specificViewModel.addPropertyChangeListener(this);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(this);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add some space between the detailedPlace and the quitButton
        quitButton.setBorder(new EmptyBorder(700, 0, 0, 0));

        add(quitButton);

        JLabel title = new JLabel("Website");
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        if (evt.getSource() == quitButton) {
            System.exit(0);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SpecificState state = (SpecificState) evt.getNewValue();
        DetailedPlace detailedPlace = state.getDetailedPlace();

        // Clear existing components
        removeAll();

        JLabel name = new JLabel(detailedPlace.getName());
        JLabel website = new JLabel(detailedPlace.getWebsite());
        JLabel address = new JLabel(detailedPlace.getAddress());

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.add(name, BorderLayout.NORTH);  // Align name to the top
        textPanel.add(website, BorderLayout.CENTER);  // Center website
        textPanel.add(address, BorderLayout.SOUTH);

        add(textPanel);

        // Revalidate and repaint the panel
        revalidate();
        repaint();
    }
}
