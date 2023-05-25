@SuppressWarnings("serial")
public class Water extends Reporting 
{
	private double amount;
	
	/**Constructor for Water event 
	 * @param double amount
	 * @return None
	 */
	public Water(double amount) {
		super("Water");
		this.amount = amount;
	}
	
	/**Gets the Water Event as a Object Array
	 * @param Void
	 * @return Object[]
	*/
	public Object[] getRow() {
		Object[] row = {this.type, this.start, "", "", this.amount};
		return row;
	}
	
	/**Getter for Water measurement
	 * @param Void
	 * @return double 
	*/
	public double getAmount() {
		return this.amount;
	}
	
	/**Setter for Water measurement
	 * @param double
	 * @return None
	*/
	public void setAmount(double inAmount) {
		this.amount = inAmount;
	}
} //End class