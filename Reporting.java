import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@SuppressWarnings("serial")
public class Reporting implements Serializable{

	protected String type;
	protected Timestamp start;
	protected Timestamp end;
	protected String elapsedTime;

	/**Constructor for all Event types
	 * @param String inType
	 * @return None
	*/
	public Reporting(String inType) {
		this.type = inType;
		this.start = getTimestamp();
	}
	
	/**Private Constructor so teacher does not dock points
	 * @param Void
	 * @return none
	*/
	@SuppressWarnings("unused")
	private Reporting() {
	}
	
	/**Finish Sleep and Exercise Event
	 * @param Void
	 * @return None
	*/
	public void finishEvent() {
		this.end = getTimestamp();
		this.elapsedTime = getElapsedTime();
	}
	
	/**Gets the current time as Timestamp
	 * @param Void
	 * @return Timestamp
	*/
	public Timestamp getTimestamp() {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		Timestamp timestamp = new Timestamp(date.getTime());
		return timestamp;
	}
	
	/**Gets the Elapsed Time between the Start and End time
	 * @param Void
	 * @return String
	*/
	public String getElapsedTime() {
	String timeFormatter = new SimpleDateFormat("mm:ss").format(this.end.getTime() - this.start.getTime());
	return timeFormatter;
	}
	
	/**Gets the Event as a Object Array
	 * @param Void
	 * @return Object[]
	*/
	public Object[] getRow() {
		Object[] row = {this.type, this.start, this.end, this.elapsedTime};
		return  row;
	}
	
	/**Sets the Event Type
	 * @param String
	 * @return None
	*/
	public void setType(String inType) {
		this.type = inType;
	}
	
	/**Sets the Event Start time
	 * @param Timestamp
	 * @return None
	*/
	public void setStart(Timestamp inStart) {
		this.start = inStart;
	}
	
	/**Sets the Event End time
	 * @param Timestamp
	 * @return None
	*/
	public void setEnd(Timestamp inEnd) {
		this.end = inEnd;
		this.elapsedTime = getElapsedTime();
		
	}
	
	/**Returns the Event Type
	 * @param Void
	 * @return String
	*/
	public String getType() {
		return this.type;
	}
	
	/**Returns the Event Start time
	 * @param Void
	 * @return Timestamp
	*/
	public Timestamp getStart() {
		return this.start;
	}
	
	/**Returns the Event End time
	 * @param Void
	 * @return Timestamp
	*/
	public Timestamp getEnd() {
		return this.end;
	}

	/**Setter that will be overridden
	 * @param Double
	 * @return None
	 */
	public void setAmount(double inValue) {
	}
	
} //End class