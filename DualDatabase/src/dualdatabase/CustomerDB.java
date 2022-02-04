package dualdatabase;

import javax.swing.*;

/**
 * Customer Database class
 * 
 * This class looks after a collection of customer name/details pairs in two arrays.
 * 
 * The arrays are set up with some basic fixed customer names.
 */
public class CustomerDB {

	private final int MAX = 5;
	/**
	 * The customer data storage
	 */
	private String[] customerName = new String[MAX];
	private String[] customerDetails = new String[MAX];

	public CustomerDB() {
		// Set up a simple database of customers: names and some details
		customerName[0] = "David Cairns";       customerDetails[0] = "House 1";
		customerName[1] = "Patrick Meier";      customerDetails[1] = "Flat 3";
		customerName[2] = "Saemi Haraldsson";   customerDetails[2] = "The Palace";
		customerName[3] = "Simon Jones";        customerDetails[3] = "Dunprogrammin";
		customerName[4] = "Savi Maharaj";       customerDetails[4] = "House 2";
	}

	/**
	 * Fill up the given combo-box list with the contents of the customerNames array
	 * @param list
	 */
	public void fillCustomerList(JComboBox list) {
		list.removeAllItems();                          // Empty out current contents
		for (int i = 0; i < MAX; i++)
			list.addItem(customerName[i]);
	} // fillCustomerList

	/**
	 * Search for the given customer in the customerNames array, and return the corresponding details, or "Not Found" if not found.
	 * @param name
	 * @return String
	 */
	public String getCustomerDetails(String name) {
		for (int i = 0; i < MAX; i++)
			if (name.equals(customerName[i]))           // Check next text
				return customerDetails[i];              // Found the required entry
		return "Not found";                             // Didn't find the required entry
	} // getCustomerDetails

	/**
	 * Search for the given customer in the customerNames array, set their details if found and return "Done", or return "Not found"
	 * @param name
	 * @param details
	 * @return String
	 */
	public String setCustomerDetails(String name, String details) {
		for (int i = 0; i < MAX; i++)
			if (name.equals(customerName[i])) {         // Check next text
				customerDetails[i] = details;           // Found the required entry
				return "Done";
			}
		return "Not found";                             // Didn't find the required entry
	} // setCustomerDetails

}