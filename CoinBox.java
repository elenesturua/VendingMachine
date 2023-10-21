public class CoinBox {
	//declaring private fields
	private int nickle;
	private int dime;
	private int quarter;
	
/**
 * constructor for coins   
 */
	public CoinBox() {
		nickle=0;
		dime=0;
		quarter=0;
 
	}
	
	/**
	 * converts nickels dimes and quarters into the corresponding dollar value
	 * @return current amount of deposited money in dollars
	 */
	public double currentAmt() {
return (nickle *0.05)+(dime*0.1)+(quarter*0.25);
	}
  
 /**
  * method for depositing quarters
  */
	public void depositQuarter() {
       quarter++;
	}
	/**
	  * method for depositing dimes
	  */
	public void depositDime() {
       dime++;
	}
	/**
	  * method for depositing nickels
	  */
	public void depositNickle() {
       nickle++;
	}
    
  /**
   * 
   * @return deposited quarters
   */
	public int getQuarterCount() {
		return quarter;
	}
	 /**
	   * 
	   * @return deposited quarters
	   */
	public int getDimeCount() {
		return dime;
	}
	 /**
	   * 
	   * @return deposited quarters
	   */
	public int getNickleCount() {
		return nickle;
	}
	
/**
 * 
 * @param The new number of coins for quarters
 */
  public void setQuarters(int num_coins) {
	  quarter=num_coins;
  }
  /**
   * 
   * @param The new number of coins for dimes
   */
  public void setDimes(int num_coins) {
	  dime=num_coins;
  }
  /**
   * 
   * @param The new number of coins for nickels
   */
  public void setNickles(int num_coins) {
	  nickle=num_coins;
  }
  
  /**
   * transfers the coins to another box so that we get the value of change coins
   * @param the CoinBox that accepts coins from user. 
   */
  public void transferCoinsFrom(CoinBox other) {
	  
	  quarter+=other.getQuarterCount();
	  dime+=other.getDimeCount();
	  quarter+=other.getNickleCount();
	  
	  

  }
  
/**
 * resets the coinbox to 0
 */
  public void resetBox() {
	  quarter=0;
	  dime=0;
	  nickle=0;
	  }
  // end class
  
}
