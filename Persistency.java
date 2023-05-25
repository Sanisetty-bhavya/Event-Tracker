import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Persistency {
	
	/**Constructor for Persistence Class
	 * @param none
	 * @return none
	*/
	public Persistency() {
	}
	
	/**
	 * Saves the Event to a file named "eventTracking.data"
	 * 
	 * @param ArrayList<Reporting>
	 * @return Void
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void saveFile(ArrayList<Reporting> event) {
		try (FileOutputStream write = new FileOutputStream("eventTracking.txt");
			ObjectOutputStream objOut = new ObjectOutputStream(write);) {
			
		objOut.writeObject(event);
		}
		catch (FileNotFoundException e) {
			System.out.println("IOException in saveFile().");
		}
		catch (IOException e) {
			System.out.println("Exception in saveFile()");
			e.printStackTrace();
		}
	}
	
	/**
	 * This loads STUFFZ from the file named "eventTracking.data"
	 * 
	 * @param None
	 * @return ArrayList<Reporting>
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Reporting> loadFile() {
		ArrayList<Reporting> events = new ArrayList<Reporting>();
		
		try (FileInputStream read = new FileInputStream("eventTracking.txt");
			ObjectInputStream objIn = new ObjectInputStream(read);) {
			
			events = (ArrayList<Reporting>)objIn.readObject();
		}
		catch (FileNotFoundException e) {
			System.out.println("FileNotFound in loadFile()");
		}
		catch (IOException e) {
			System.out.println("IOException at loadFile()");
		}
		catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException in loadFile()");
		}
		return events;
	}
} // End class