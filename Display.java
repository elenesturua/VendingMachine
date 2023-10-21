public class Display {
	

	
	public Display() {

	
	}
	
	/**
	 * prints a given string
	 * @param message
	 */
	public void show(String message) {
		System.out.println(message);
	
	}
	
	/**
	 * displays error message to the user
	 * @param message
	 */
	public void error(String message) {
		System.out.println("Error: " + message);
	}
	
	
/**
 * informs user to take their change 
 * @param q number of quarters change
 * @param d number of dimes change
 * @param n number of nickels change
 */
	public void takeChange(int q, int d, int n) {
		System.out.println("Please take your change:");
		System.out.println(q + " quarters " + d + " dimes " + n + " nickels.");
	}
	
	 /**
     * Displays a message when a given brand is sold out.
     */
	public void soldOut() {
		System.out.println("Sorry, that brand is sold out or you entered an incorrect ID.");
	}
	
	/**
     * Displays a message when everything is sold out.
     */
	public void allSoldOut() {
		System.out.println("Sorry, everything is sold out.");
	}
	
	 /**
     * Displays a message when a sale is successful.
     */
	public void sold() {
		System.out.println("Sale successful. Please take your beverage.");
	}
	
	/**
     * Displays a message when exact change cannot be made.
     */
	public void notExactChange() {
		
		System.out.println("Sorry, cannot make exact change!");
	}
	


}