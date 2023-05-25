@SuppressWarnings("serial")
public class Sleep extends Reporting 
{
	/**Constructor for Sleep event 
	 * @param Void
	 * @return None
	 */
	public Sleep() {
		super("Sleep");
	}
	
	/**Gets the Sleep Event as a Object Array
	 * @param Void
	 * @return Object[]
	*/
	public Object[] getRow() {
		Object[] row = {this.type, this.start, this.end, this.elapsedTime, ""};
		return row;
	}
} //End class