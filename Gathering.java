import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Gathering implements Serializable
{
	Persistency save = new Persistency();
	private ArrayList<Reporting> events = new ArrayList<Reporting>();
	
	
	/**Constructor for Gathering
	 * @param Void
	 * @return None
	 */
	public Gathering(){
	}
	
	/**Creates a new Water Event
	 * @param Double
	 * @return None
	 */
	public void addWater(Double amount) {
		Water water = new Water(amount);
		this.events.add(water);
	}
	
	/**Creates a new Weight Event
	 * @param Double
	 * @return None
	 */
	public void addWeight(Double measurement) {
		Weight weight = new Weight(measurement);
		this.events.add(weight);
	}
	
	/**Creates a new Sleep Event
	 * @param Void
	 * @return None
	 */
	public void addSleep() {
		Sleep sleep = new Sleep();
		this.events.add(sleep);
	}
	
	/**Creates a new Water Event
	 * @param Double
	 * @return None
	 */
	public void addExercise() {
		Exercise exercise = new Exercise();
		this.events.add(exercise);
	}
	
	/**Ends a Sleep and Exercise event
	 * @param Void
	 * @return None
	 */
	public void endEvent() {
		for (int i = this.events.size() - 1; i >= 0; i--) {
				Reporting event = this.events.get(i);
				if (event.getType() == "Sleep" || event.getType() == "Exercise") {
				event.finishEvent();
				this.events.set(i, event);
				break;
				}
		}
	}
	
	/**Updates the amount in Water Weight Amount
	 * @param int index, double value
	 * @return None
	*/
	public void upDateAmount(int index, double inValue) {
		Reporting event = this.events.get(index);
		event.setAmount(inValue);
		this.events.set(index, event);
		
	}
	
	/**Updates the Start time
	 * @param int index, Timestamp inTime
	 * @return None
	*/
	public void upDateStart(int index, Timestamp inTime) {
		Reporting event = this.events.get(index);
		event.setStart(inTime);
		this.events.set(index, event);
		
	}
	
	/**Updates the End time
	 * @param int index, Timestamp inTime
	 * @return None
	*/
	public void upDateEnd(int index, Timestamp inTime) {
		Reporting event = this.events.get(index);
		event.setEnd(inTime);
		this.events.set(index, event);
	}
	
	/**Returns a MultiDimensional Array of all/specific Event types
	 * @param String
	 * @return Object[][]
	*/
	public Object[][] getTableData(String searchTxt) {
			Object[][] data = new Object[20][5];
			
			if (searchTxt == "All Info") {
				for (int i = 0; i < this.events.size(); i++) {
					Object[] row = this.events.get(i).getRow();
					data[i] =  row;
				}
			
			} else {
				
			int j = 0;
				for (int i = 0; i < this.events.size(); i++) {
					String strType = this.events.get(i).getType();
		
					if (strType == searchTxt) {
						Object[] row = this.events.get(i).getRow();
						data[j] =  row;
						j++;
					}
				}
			}
		return data;	
	}	
	
	/**Removes the selected Event from record
	 * @param Integer
	 * @return None
	*/
	public void deleteEvent(int index) {
		this.events.remove(index);
	}
	
	/**Saves the Data
	 * @param Void
	 * @return None
	*/
	public void saveData() {
		this.save.saveFile(events);
	}
	
	/**Loads the Data
	 * @param Void
	 * @return None
	*/
	public void loadData() {
		this.events = this.save.loadFile();
	}
	
	/**Erases the Data
	 * @param Void
	 * @return None
	*/
	public void eraseData() {
		this.events.clear();
	}
	
	/**Creates a blank Event List
	 * @param Void
	 * @return None
	*/
	public void newDataFile() {
		eraseData();
		saveData();
	}

} // End class