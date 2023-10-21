public class BillBox {

	private int dollarBills; //declare a private field
	
	/**
	 * constructor
	 */
	public BillBox() {
		dollarBills=0;
	}

	/**
	 * updates count every time a bill is deposited
	 */
	public void depositBill() {
		dollarBills++;
	}
    	
	/** 
	 * resets the deposited bill in the current transaction
	 */
	public void resetBills() {
		dollarBills=0;
		
	}
	
	/** 
	 *  method that returns the deposited bills
	 * @return the number of recently deposited bills 
	 */
	public int getCurrentBills() {
		return dollarBills;
	}
	
	
}
