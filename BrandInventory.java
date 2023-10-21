public class BrandInventory {
	//declaring private fields
	private String ID;
	private float price;
	private int count;
	
/**
 * constructor 
 * @param id
 * @param price
 * @param numItems
 */
	public BrandInventory(String id, float price, int numItems) {
		this.ID=id;
		this.price=price;
		this.count=numItems;
		
	}
	
	/**
	 * accessor for ID
	 * @return ID
	 */
	public String getID() {
		return ID;
	}
	/**
	 * accessor for price
	 * @return price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * accessor for count
	 * @return count
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * updates the available number of sodas after a successful purchase.
	 */
	  public void reduceOnHand() {
		  count--;
	  }
	
	/**
	 * checks if the specific item is sold out
	 * @return true or false
	 */
	public boolean isSoldOut() {
		return count==0;
	}
	
	/**
	 * @return a string containing ID and price of the item
	 */
	public String toString() {
		return "Brand ID: "+ID+" Price:"+price;
	}


}