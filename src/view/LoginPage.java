package view;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class LoginPage {
    private JTextField HomeAddress;
    private JPanel panel1;
    private JButton nextButton;
    private JTextField Destination;

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
            String user_address = HomeAddress.getText();
            String user_subject = Destination.getText();
        });


        }
}
