package dualdatabase;

import javax.swing.*;

/**
 * Database class
 * 
 * This class looks after a collection of customer name/details pairs in two arrays, and product name/details pairs in two arrays.
 * 
 * The arrays are set up with some basic fixed customer and product names.
 */
public class Database {

	/**
	 * Represents the aggregation relationship from Database to CustomerDB.
	 */
	private CustomerDB theCustomerDB = new CustomerDB();
	/**
	 * Represents the aggregation relationship from Database to ProductDB.
	 */
	private ProductDB theProductDB = new ProductDB();

	/**
	 * Fill up the given combo-box list with the contents of the customerNames array
	 * @param list
	 */
	public void fillCustomerList(JComboBox list) {
		theCustomerDB.fillCustomerList(list);
	} // fillCustomerList

	/**
	 * Search for the given customer in the customerNames array, and return the corresponding details, or "Not Found" if not found.
	 * @param name
	 * @return String
	 */
	public String getCustomerDetails(String name) {
		return theCustomerDB.getCustomerDetails(name);
	} // getCustomerDetails

	/**
	 * Search for the given customer in the customerNames array, set their details if found and return "Done", or return "Not found"
	 * @param name
	 * @param details
	 * @return String
	 */
	public String setCustomerDetails(String name, String details) {
		return theCustomerDB.setCustomerDetails(name,details);
	} // setCustomerDetails

	/**
	 * Fill up the given combo-box list with the contents of the productName array
	 * @param list
	 */
	public void fillProductList(JComboBox list) {
		theProductDB.fillProductList(list);
	} //fillProductList

	/**
	 * Search for the given product in the productNames array, and return the corresponding details, or "Not found" if not found
	 * @param name
	 * @return String
	 */
	public String getProductDetails(String name) {
		return theProductDB.getProductDetails(name);
	} //getProductDetails

	/**
	 * Search for the given product in the productNames array, set their details if found and return "Done", or return "Not found"
	 * @param name
	 * @param details
	 * @return String
	 */
	public String setProductDetails(String name, String details) {
		return theProductDB.setProductDetails(name,details);
	} //setProductDetails
}
