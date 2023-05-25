import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.sql.Timestamp;

import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;


public class Presentation {

	Gathering cmd = new Gathering();
	
	public static String[] comboBoxArray = {"All Info", "Sleep", "Exercise", "Water", "Weight"};
	DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(comboBoxArray);
	
	public static String[] columnNames = {"Type", "Start Time", "End Time", "Elapsed Time", "Amount"};
	

	JFrame frmEventTracker;
	private JTable tblDisplay;
	private Object[][] data = new Object[20][5];
	private JToggleButton tglbtnSleep, tglbtnExercise;
	private JButton btnDrinkWater, btnWeight, btnDisplay, btnClearAllData, btnSave, btnLoad, btnClearScreen, btnNewRecord;
	private JComboBox ddlEventType;
	private JLabel lblStatusText;
	private double waterAmount, weightAmount;
	
	
	/**Creates JTable for displaying ArrayList data
	 * Get the model behind the JTable and tie the listener to it
	 */
	public void updateTable(String searchTxt) {
		this.data = cmd.getTableData(searchTxt);
		tblDisplay.setModel(new DefaultTableModel(this.data, Presentation.columnNames));
		
		TableModel model = tblDisplay.getModel();
		model.addTableModelListener(new TableModelListener(){
			
		    public void tableChanged(TableModelEvent e) {
		    	 	
		        int row = e.getFirstRow();
		        int column = e.getColumn();
		        
		        TableModel model = (TableModel) e.getSource();
		        Object data = model.getValueAt(row, column);
		        switch(column){
		        case 0: //Event type
		            break;
		        case 1: //Start time
		            Timestamp startValue = Timestamp.valueOf(data.toString());
		            cmd.upDateEnd(row, startValue);
		            break;
		        case 2: //End time
		            Timestamp endValue = Timestamp.valueOf(data.toString());
		            cmd.upDateEnd(row, endValue);
		            break;
		        case 3: //Elapsed time
		            break;
		        case 4: //Amount
		            Double amountValue = Double.valueOf(data.toString());
		            cmd.upDateAmount(row, amountValue);
		            break;
		        }
		      }
			
		});
	}
	

	/**
	 * Create the application.
	 */
	public Presentation() {
		
		/**Creates a JFrame for application.
		 */
		frmEventTracker = new JFrame();
		frmEventTracker.setTitle("Event Tracker +");
		frmEventTracker.setBounds(100, 100, 805, 566);
		frmEventTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEventTracker.getContentPane().setLayout(null);
		
		/**Status text to show what is being displayed.
		 */
		lblStatusText = new JLabel();
		lblStatusText.setBounds(281, 250, 269, 14);
		frmEventTracker.getContentPane().add(lblStatusText);

		/**ComboBox to select event type to display.
		 */
		ddlEventType = new JComboBox(this.comboModel);
		ddlEventType.setBounds(556, 280, 120, 20);
		frmEventTracker.getContentPane().add(ddlEventType);


		
		
		/**creates a new sleep event
		*/
		tglbtnSleep = new JToggleButton("Sleep");
		tglbtnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnSleep.isSelected() == true) {
				cmd.addSleep();
				tglbtnExercise.setEnabled(false);
				lblStatusText.setText("Started Sleeping");
				} else {
					cmd.endEvent();
					tglbtnExercise.setEnabled(true);
					lblStatusText.setText("Ended Sleeping");
				}
					
			}
		});
		tglbtnSleep.setBounds(63, 279, 89, 23);
		frmEventTracker.getContentPane().add(tglbtnSleep);
		
		
		/**creates a new exercise event
		*/
		tglbtnExercise = new JToggleButton("Exercise");
		tglbtnExercise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnExercise.isSelected() == true) {
					cmd.addExercise();
					tglbtnSleep.setEnabled(false);
					lblStatusText.setText("Started Exercising");
					} else {
						cmd.endEvent();
						tglbtnSleep.setEnabled(true);
						lblStatusText.setText("Ended Exercising");
					}
			}
		});
		tglbtnExercise.setBounds(63, 329, 89, 23);
		frmEventTracker.getContentPane().add(tglbtnExercise);
		
		

		
		
		
		/** Creates JDesktopPane, visibility set as false.
		 */
		final JDesktopPane waterDesktopPane = new JDesktopPane();
		waterDesktopPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		waterDesktopPane.setBackground(UIManager.getColor("FormattedTextField.inactiveBackground"));
		waterDesktopPane.setBounds(185, 240, 358, 178);
		frmEventTracker.getContentPane().add(waterDesktopPane);
		
		/** Button sets waterDesktopPane visibility to true.
		 */
		btnDrinkWater = new JButton("Drink");
		btnDrinkWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				waterDesktopPane.setVisible(true);
				disable();
			}
		});
		btnDrinkWater.setBounds(175, 279, 89, 23);
		frmEventTracker.getContentPane().add(btnDrinkWater);
		
		/** JLabel asking for water amount.
		 */
		JLabel waterLabel = new JLabel("Enter Water:");
		waterLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		waterLabel.setBounds(118, 21, 131, 20);
		waterDesktopPane.add(waterLabel);
		
		/** JTextField for user input.
		 */
		final JTextField waterTextField = new JTextField();
		waterTextField.setText("");
		waterTextField.setBounds(118, 57, 115, 26);
		waterDesktopPane.setVisible(false);
		waterDesktopPane.add(waterTextField);
		waterTextField.setColumns(10);
		
		/** JLabel for prompting reentry.
		 */
		final JLabel waterHandlingText = new JLabel("");
		waterHandlingText.setHorizontalAlignment(SwingConstants.CENTER);
		waterHandlingText.setBounds(47, 87, 263, 20);
		waterDesktopPane.add(waterHandlingText);
		
		/** Converts user input to a double and creates/adds water event.
		 *  Resets waterDesktopPane visibility to false.
		 */
		JButton waterOkay = new JButton("Okay");
		waterOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String input = waterTextField.getText();
				if(isDouble(input) == true)	
				{
					waterAmount = Double.parseDouble(input.replaceAll(" ","."));
					if(waterAmount > 0)
					{
						cmd.addWater(waterAmount);
						waterTextField.setText(null);
						waterHandlingText.setText(null); // If InputHandlingText appears, this just resets it to be blank.
						waterDesktopPane.setVisible(false);
						enable();
					}
					else
					{
						waterTextField.setText(null);
						waterHandlingText.setText("Please enter value greater than 0.");
					}
				}
				else
				{
					waterTextField.setText(null);
					waterHandlingText.setText("Please enter a numerical value.");
				}
			}
		});
		waterOkay.setBounds(47, 120, 115, 29);
		waterDesktopPane.add(waterOkay);
		
		/** Resets waterDesktopPane visibility to false.
		 */
		JButton waterCancel = new JButton("Cancel");
		waterCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				waterDesktopPane.setVisible(false);
				enable();
			}
		});
		waterCancel.setBounds(195, 120, 115, 29);
		waterDesktopPane.add(waterCancel);
		
		
		
		/** Creates JDesktopPane, visibility set as false.
		 */
		final JDesktopPane weightDesktopPane = new JDesktopPane();
		weightDesktopPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		weightDesktopPane.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		weightDesktopPane.setBounds(185, 250, 354, 173);
		weightDesktopPane.setVisible(false);
		frmEventTracker.getContentPane().add(weightDesktopPane);
		
		/**Button sets weightDesktopPane visibility to true.
		 */
		btnWeight = new JButton("Weight");
		btnWeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				weightDesktopPane.setVisible(true);
				disable();
			}
		});
		btnWeight.setBounds(175, 329, 89, 23);
		frmEventTracker.getContentPane().add(btnWeight);
		
		/**JLabel to ask for weight.
		 */
		JLabel lblEnterWeight = new JLabel("Enter Weight:");
		lblEnterWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterWeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterWeight.setBounds(109, 16, 134, 29);
		weightDesktopPane.add(lblEnterWeight);
		
		/** JTextField for user input.
		 */
		final JTextField weightTextField = new JTextField();
		weightTextField.setBounds(119, 52, 115, 29);
		weightDesktopPane.add(weightTextField);
		weightTextField.setColumns(10);
		
		/** JLabel for prompting reentry.
		 */
		final JLabel weightHandlingText = new JLabel("");
		weightHandlingText.setHorizontalAlignment(SwingConstants.CENTER);
		weightHandlingText.setBounds(49, 86, 258, 20);
		weightDesktopPane.add(weightHandlingText);
		
		/** Converts user input to a double and creates/adds weight event.
		 *  Resets weightDesktopPane visibility to false.
		 */
		JButton weightOkay = new JButton("Okay");
		weightOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String input = weightTextField.getText();
				if(isDouble(input) == true)
				{
					weightAmount = Double.parseDouble(input.replaceAll(" ","."));
					if(weightAmount > 0)
					{
						cmd.addWeight(weightAmount);
						weightTextField.setText(null);
						weightHandlingText.setText(null);
						weightDesktopPane.setVisible(false);
						enable();
					}
					else
					{
						weightTextField.setText(null);
						weightHandlingText.setText("Please enter a value greater than 0.");
					}
				}
				else
				{
					weightTextField.setText(null);
					weightHandlingText.setText("Please enter a numerical value.");
				}
			}
		});
		weightOkay.setBounds(49, 117, 115, 29);
		weightDesktopPane.add(weightOkay);
				
		/** Sets weightdesktopPane to invisible
		 */
		JButton weightCancel = new JButton("Cancel");
		weightCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				weightDesktopPane.setVisible(false);
				enable();
			}
		});
		weightCancel.setBounds(192, 117, 115, 29);
		weightDesktopPane.add(weightCancel);
		
		/**This will get what is selected in the drop down list and Display only that
		*/
		btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strDDLIndex = (String) ddlEventType.getSelectedItem();
				lblStatusText.setText("Displaying: " + strDDLIndex);
				updateTable(strDDLIndex);

			}
		});
		btnDisplay.setBounds(573, 329, 89, 23);
		frmEventTracker.getContentPane().add(btnDisplay);
		
		/**Erases all data and creates a new file.
		*/
		btnClearAllData = new JButton("Clear All Data");
		btnClearAllData.setToolTipText("");
		btnClearAllData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmd.eraseData();
				lblStatusText.setText("All Records Have Been Deleted");
			}
		});
		btnClearAllData.setBounds(63, 452, 129, 23);
		frmEventTracker.getContentPane().add(btnClearAllData);
		
		
		/**Saves the data
		*/
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmd.saveData();
				lblStatusText.setText("Information Has Been Saved");
			}
		});
		btnSave.setBounds(63, 413, 129, 23);
		frmEventTracker.getContentPane().add(btnSave);
		
		
		/**loads the data
		*/
		btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmd.loadData();
				lblStatusText.setText("Information Has Been Loaded");
			}
		});
		btnLoad.setBounds(207, 413, 115, 23);
		frmEventTracker.getContentPane().add(btnLoad);
		
		/**Creates new file.
		 */
		btnNewRecord = new JButton("New Record");
		btnNewRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmd.newDataFile();
				lblStatusText.setText("New Blank Record Created");
			}
		});
		btnNewRecord.setBounds(207, 452, 120, 23);
		frmEventTracker.getContentPane().add(btnNewRecord);
		
		/**Clears Jtable display
		 */
		btnClearScreen = new JButton("Clear Screen");
		btnClearScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateTable("Stop It Brad");
				lblStatusText.setText("Screen Has Been Cleared");
			}
		});
		btnClearScreen.setBounds(573, 401, 120, 23);
		frmEventTracker.getContentPane().add(btnClearScreen);
		
		/**Creates JScrollPane for JTable
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 11, 715, 213);
		frmEventTracker.getContentPane().add(scrollPane);
		
		
		
		/**Creates JTable for displaying ArrayList data
		 * Get the model behind the JTable and tie the listener to it
		 */
		tblDisplay = new JTable(new DefaultTableModel(this.data, Presentation.columnNames));
		scrollPane.setViewportView(tblDisplay);
	}
	
	/**Returns true of if the string is able to be parsed into a double.
	 * @param str
	 * @return void
	 */
	public boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	/**Disables JFrame components when a JDesktopPane is visible.
	 * @param none
	 * @return void
	 */
	public void disable()
	{
		tglbtnSleep.setEnabled(false);
		tglbtnExercise.setEnabled(false);
		btnDrinkWater.setVisible(false);
		btnWeight.setVisible(false);
		lblStatusText.setVisible(false);
		btnDisplay.setEnabled(false);
		btnClearAllData.setEnabled(false);
		btnSave.setEnabled(false);
		btnLoad.setEnabled(false);
		btnClearScreen.setEnabled(false);
		ddlEventType.setEnabled(false);
		btnNewRecord.setEnabled(false);
	}
	
	/**Enables JFrame components when a JDesktopPain is visible
	 * @param none
	 * @return void
	 */
	public void enable()
	{
		tglbtnSleep.setEnabled(true);
		tglbtnExercise.setEnabled(true);
		btnDrinkWater.setVisible(true);
		lblStatusText.setVisible(true);
		btnWeight.setVisible(true);
		btnDisplay.setEnabled(true);
		btnClearAllData.setEnabled(true);
		btnSave.setEnabled(true);
		btnLoad.setEnabled(true);
		btnClearScreen.setEnabled(true);
		ddlEventType.setEnabled(true);
		btnNewRecord.setEnabled(true);
	}
	
}// End Presentation.java