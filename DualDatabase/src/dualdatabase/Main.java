package dualdatabase;

public class Main {

	/**
	 * Launch the database application
	 * 
	 * Create an instance of the database and a user interface frame to interact with the database
	 * @param args
	 */
	public static void main(String[] args) {
            Database theData = new Database();             // Holds all the data
            UserInterface ui = new UserInterface(theData); // Create an interface, informing it of the database
            ui.setLocation(50,50);                         // Set where on the screen...
            ui.setVisible(true);                           //    ...and display it
	}

} // Main