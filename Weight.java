@SuppressWarnings("serial")
public class Weight extends Reporting
{
	private double amount;
	
	
	/**Constructor to create a new Weight Event
	 * @see Reporting
	 * @param double pounds
	 * @return void
	*/
	public Weight(double pounds) {
		super("Weight");
		this.amount = pounds;
	}

	/**Gets the Weight Event as a Object Array
	 * @param Void
	 * @return Object[]
	*/
	public Object[] getRow() {
		Object[] row = {this.type, this.start, "", "", this.amount};
		return row;
	}
	
	/**Getter for Weight measurement
	 * @param Void
	 * @return double 
	*/
	public double getAmount() {
		return this.amount;
	}
	
	/**Setter for Weight measurement
	 * @param double 
	 * @return None
	*/
	public void setAmount(double inAmount) {
		this.amount = inAmount;
	}
} //End class