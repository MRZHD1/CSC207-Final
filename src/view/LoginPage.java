package view;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class LoginPage {
    private JTextField Location;
    private JPanel panel1;
    private JButton nextButton;
    private JTextField Destination;
    private JCheckBox fillInWithHomeCheckBox;

    private JFrame frame;

    public LoginPage(){

        frame = new JFrame("Main TRP Frame");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(700, 550));
        frame.setResizable(false);

        // Adding the pannels
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.getContentPane().setBackground(Color.GREEN);

        //Saving the user inputs for the input boundaries (it saves when the <next> button gets clicked)

        nextButton.addActionListener(e -> {
            String user_location = Location.getText();
            String user_subject = Destination.getText();
        });

        fillInWithHomeCheckBox.addActionListener(e -> {
            if (fillInWithHomeCheckBox.isSelected()) {
                // If the checkbox is selected, set the Location text field
                // to "my home address"
                Location.setText("my home address");
            } else {
                // If the checkbox is deselected, clear the Location text field
                Location.setText("");
            }
        });


        }
}
