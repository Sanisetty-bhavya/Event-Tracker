@SuppressWarnings("serial")
public class Exercise extends Reporting 
{
	/**Constructor for Exercise event 
	 * @param Void
	 * @return None
	 */
	public Exercise() {
		super("Exercise");
	}

	/**Gets the Exercise Event as a Object Array
	 * @param Void
	 * @return Object[]
	*/
	public Object[] getRow() {
		Object[] row = {this.type, this.start, this.end, this.elapsedTime, ""};
		return row;
	}
} //End class