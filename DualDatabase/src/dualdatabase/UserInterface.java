package dualdatabase;

/**
 * A database user interface.
 * 
 * Note: This is a JFrame so gives a standalone window, but needs a main class to launch the application and instantiate this class.
 * 
 * Provides interactive access to a database of customer names and details (in one panel of the window) and to a database of product names and details (in another panel of the window).
 * 
 * Savi Maharaj (after Simon Jones)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class UserInterface 
        extends JFrame
        implements ActionListener {

	/**
	 * Reference, initialized in the constructor
	 */
	private Database theData;
	/**
	 * Customer management panel
	 */
	private JPanel customerPanel = new JPanel();;
	/**
	 * For displaying a drop down list of customers
	 */
	private JComboBox customerList = new JComboBox();
	private JButton getCustomerDetailsButton = new JButton("Get customer details");;
	private JButton setCustomerDetailsButton = new JButton("Set customer details");
	/**
	 * For displaying/entering the selected customer's details
	 */
	private JTextField customerDetailsField = new JTextField(30);
        
        /**
	 * Product management panel
	 */
	private JPanel productPanel = new JPanel();;
	/**
	 * For displaying a drop down list of products
	 */
	private JComboBox productList = new JComboBox();
	private JButton getProductDetailsButton = new JButton("Get product details");;
	private JButton setProductDetailsButton = new JButton("Set product details");
	/**
	 * For displaying/entering the selected product's details
	 */
	private JTextField productDetailsField = new JTextField(30);

	/**
	 * Frame constructor
	 * @param theData
	 */
	public UserInterface(Database theData) {
            this.theData = theData;                           // Record the reference to the database
            setTitle("Database user interface");
            setSize(600,200);                                 // Width, height of window
            createGUI();                                      // Set up the GUI
	} // constructor

	/**
	 * Set up the GUI
	 */
	public void createGUI() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            Container window = getContentPane();
            window.setLayout(new GridLayout(2,1));            // Otherwise JFrame defaults to BorderLayout

            // Set up customer management panel
            customerPanel.setBackground(Color.cyan);
            customerPanel.add(new JLabel("Customer:"));
            theData.fillCustomerList(customerList);           // Populate the list with the customer names
            customerPanel.add(customerList);
            customerList.addActionListener(this);             // Notify actionPerformed when a selection is made
            customerList.setEditable(false);                  // Set not editable - for choosing only
            customerPanel.add(getCustomerDetailsButton);
            getCustomerDetailsButton.addActionListener(this); // Notify actionPerformed when button is clicked
            customerPanel.add(setCustomerDetailsButton);
            setCustomerDetailsButton.addActionListener(this); // Notify actionPerformed when button is clicked
            customerPanel.add(customerDetailsField);
            customerDetailsField.setEditable(true);           // Allow user editing
            window.add(customerPanel);

            // Set up product management panel
            productPanel.setBackground(Color.green);
            productPanel.add(new JLabel("Product:"));
            theData.fillProductList(productList);             // Populate the list with the product names
            productPanel.add(productList);
            productList.addActionListener(this);              // Notify actionPerformed when a selection is made
            productList.setEditable(false);                   // Set not editable - for choosing only
            productPanel.add(getProductDetailsButton);
            getProductDetailsButton.addActionListener(this);  // Notify actionPerformed when button is clicked
            productPanel.add(setProductDetailsButton);
            setProductDetailsButton.addActionListener(this);  // Notify actionPerformed when button is clicked
            productPanel.add(productDetailsField);
            productDetailsField.setEditable(true);            // Allow user editing
            window.add(productPanel);
	} // createGUI

	/**
	 * Handle button presses and selection of items from the list
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == customerList)                // Clear text field when an item is selected
               customerDetailsField.setText("");

            if (e.getSource() == productList)                 // Clear text field when an item is selected
               productDetailsField.setText("");

            if (e.getSource() == getCustomerDetailsButton) {                   // Get customer details?
               String chosen = (String)customerList.getSelectedItem();         // Which customer selected?
               String theDetails = theData.getCustomerDetails(chosen);         // Look up details
               customerDetailsField.setText(theDetails);                       // And display them
            }

            if (e.getSource() == setCustomerDetailsButton) {                   // Change customer details?
               String chosen = (String)customerList.getSelectedItem();         // Which customer selected?
               String theDetails = customerDetailsField.getText();             // Look up details
               String result = theData.setCustomerDetails(chosen,theDetails);  // Update the database
               customerDetailsField.setText(result);                           // And report the result
            }

            if (e.getSource() == getProductDetailsButton) {                    // Get product details?
               String chosen = (String)productList.getSelectedItem();          // Which product selected?
               String theDetails = theData.getProductDetails(chosen);          // Look up details
               productDetailsField.setText(theDetails);                        // And display them
            }

            if (e.getSource() == setProductDetailsButton) {                    // Change product details?
               String chosen = (String)productList.getSelectedItem();          // Which product selected?
               String theDetails = productDetailsField.getText();              // Look up details
               String result = theData.setProductDetails(chosen,theDetails);   // Update the database
               productDetailsField.setText(result);                            // And report the result
            }

            // No need for repaint(); as there is no paint!
	}
}
