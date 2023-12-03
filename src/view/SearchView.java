package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import interface_adapter.results.ResultsViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;





public class SearchView extends JPanel implements ActionListener, PropertyChangeListener {
    public String viewName = "WELCOME!";
    private JTextField Location = new JTextField(15);
    private JPanel panel1;
    private JButton nextButton;
    private JTextField Query = new JTextField(15);
    private JCheckBox fillInWithHomeCheckBox;

    private final SearchViewModel searchViewModel;

    private final SearchController searchController;




    public SearchView(SearchController controller, SearchViewModel searchViewModel){

        this.searchController = controller;
        this.searchViewModel = searchViewModel;

        JLabel title = new JLabel(SearchViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel locationInfo = new LabelTextPanel(
                new JLabel(SearchViewModel.LOCATION_LABEL), Location);
        LabelTextPanel queryInfo = new LabelTextPanel(
                new JLabel(SearchViewModel.QUERY_LABEL), Query);

        JPanel buttons = new JPanel();

        nextButton = new JButton(SearchViewModel.NEXT_BUTTON_LABEL);
        buttons.add(nextButton);

        //Saving the user inputs for the input boundaries (it saves when the <next> button gets clicked)

        nextButton.addActionListener(e -> {
            String location = Location.getText();
            String query = Query.getText();
            try {
                controller.execute(query, location);

                // Switch to the ResultsView
                SearchState currentState = searchViewModel.getState();
                searchViewModel.setState(currentState);



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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(locationInfo);
        this.add(queryInfo);
        this.add(buttons);


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
