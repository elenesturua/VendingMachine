import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class VendingMachine {

	
	private ArrayList<BrandInventory> inventory;
	private CoinBox depositCoins=new CoinBox();
	private BillBox depositBills=new BillBox();
	private CoinBox userChange=new CoinBox();
	Display display=new Display();
	

/**
 * constructs a VendingMachine object and initializes its parameters
 * @throws FileNotFoundException
 */
	public VendingMachine() throws FileNotFoundException{
		inventory=new ArrayList<BrandInventory>();

		
		try {
			Scanner infoFile=new Scanner(new FileReader("config.dat"));
			while (infoFile.hasNext()) {
				String ID=infoFile.next();
				float price=infoFile.nextFloat();
				int numofItems=infoFile.nextInt();    
				
				
				inventory.add(new BrandInventory(ID, price, numofItems));
				infoFile.hasNextLine();
			}
		}
		
		catch (FileNotFoundException e) {
			System.err.println("Could not find config.dat");
			
		}
		

				
		userChange.setDimes(10);
		userChange.setNickles(10);
		userChange.setQuarters(10);
		
		
	} 
	
	/**
	 * checks if the product corresponding to the input ID is in stock
	 * @param purchaseID
	 * @return true if product available and false if unavailable
	 */
	public boolean isAvailable(String purchaseID) {
		for (BrandInventory item : inventory) {
            if (item.getID().equals(purchaseID) && item.getCount() > 0) {
                return true;
            }
        }
        return false;
    }
	
	
/**
 * finds price of the item
 * @param purchaseID
 * @return price of product if found, 0 if not found
 */
	public float purchasePrice(String purchaseID) {
		for (BrandInventory item : inventory) {
		if (item.getID().contentEquals(purchaseID)) {
			return item.getPrice();
		}
		
	} return 0;
		}
	
	
	
	/**
	 * 
	 * @return total amount deposited by user
	 */
	public double getAmtDeposited() {
		return depositCoins.currentAmt() + depositBills.getCurrentBills();
	
	}
	
	/**
	 * accepts bill and adds it to deposited bills amount
	 */
	public void acceptBill() {
	  depositBills.depositBill();
 	}
	/**
	 * accepts quarter and adds it to deposited quarters amount
	 */
	  public void acceptQuarter() {
	 	 depositCoins.depositQuarter();
    }
	  /**
		 * accepts dime and adds it to deposited dimes amount
		 */
    public void acceptDime() {
	  depositCoins.depositDime();
    }
    /**
	 * accepts nickle and adds it to deposited nickle amount
	 */
   public void acceptNickle() {
	  depositCoins.depositNickle();
   }
   
   /**
    * makes change for deposited amount 
    * @param dollar_amount
    * @return true if change can be mace; false if not
    */
 public boolean makeChange(double dollar_amount) {
	 
	 double leftChange = dollar_amount;

	    if (dollar_amount == 0) {
	        return false;
	    } else if (dollar_amount > 0) {
	        int quarterChange = (int) (leftChange / 0.25);
	        leftChange -= quarterChange * 0.25;

	        int dimeChange = (int) (leftChange / 0.1);
	        leftChange -= dimeChange * 0.1;

	        int nickleChange = (int) (leftChange / 0.05);

	        userChange.setQuarters(userChange.getQuarterCount() - quarterChange);
	        userChange.setDimes(userChange.getDimeCount() - dimeChange);
	        userChange.setNickles(userChange.getNickleCount() - nickleChange);

	        display.takeChange(quarterChange, dimeChange, nickleChange);
	    }
	    return true;
	} 
	 
 /**
  * prints inventory of items
  */
	public void printInventory() {
		 for (BrandInventory item : inventory) {
	            display.show(item.toString());
	        }
		
	}
	
	 /**
     * Prints the available product choices along with their prices.
     */
	public void printChoices() {
		
		  for (BrandInventory item : inventory) {
	            if (!item.isSoldOut()) {
	                display.show("Choice: " + item.getID() + ", Price: $" + item.getPrice());
	            }
	        }
	}
	
	 /**
     * Completes a successful sale, transfers deposited coins to user change,
     * and resets the deposited coins and bills.
     */
	public void completeSale() {
			userChange.transferCoinsFrom(depositCoins);
	        depositCoins.resetBox();
	        depositBills.resetBills();
	        display.sold();
	}

} 
