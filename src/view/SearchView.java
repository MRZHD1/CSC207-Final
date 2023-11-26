package view;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import interface_adapter.search.SearchController;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;
import interface_adapter.signup.SignupState;

public class SearchView extends JPanel implements ActionListener, PropertyChangeListener {
    public String viewName = "Search";
    private JTextField Location;
    private JPanel panel1;
    private JButton nextButton;
    private JTextField Query;
    private JCheckBox fillInWithHomeCheckBox;

    private SearchController searchController;

    private JFrame frame;

    public SearchView(SearchController controller, SearchViewModel searchViewModel){

        frame = new JFrame("Main Placify Frame");
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
            String location = Location.getText();
            String query = Query.getText();
            try {
                controller.execute(query, location);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

        });

        fillInWithHomeCheckBox.addActionListener(e -> {
            if (fillInWithHomeCheckBox.isSelected()) {
                // If the checkbox is selected, set the Location text to "my home address"
                Location.setText("my home address");
                String location = "my home address";
            } else {
                // If the checkbox is deselected, clear the Location text field
                Location.setText("");
            }
        });


        }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchState state = (SearchState) evt.getNewValue();
        if (state.getSearchError() != null) {
            JOptionPane.showMessageDialog(this, state.getSearchError());
        }
    }
}
