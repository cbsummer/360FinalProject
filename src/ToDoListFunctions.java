import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

public class ToDoListFunctions {


	public static void add() {
		
	}
	
	// Deletes selected task from both the ArrayList and the table
	public static void delete(ArrayList<Task> taskList, javax.swing.JTable taskTable) {
		try
		{
			DefaultTableModel model = (DefaultTableModel) taskTable.getModel();
			int rowIndex = taskTable.getSelectedRow();
			// Gets the description from the selected row.
			String selectedTask = (String) taskTable.getValueAt(rowIndex, 1);
			
			// Search for selected task and remove from the ArrayList
			for (int count = 0; count < taskList.size(); count++)
			{
				if (taskList.get(count).getDescription().equals(selectedTask))
					taskList.remove(count);
			}
			
			// Needed to add this so that the correct row is deleted when the 
			// table has been sorted.
			rowIndex = taskTable.convertRowIndexToModel(rowIndex);
			// remove from the table.
			model.removeRow(rowIndex);
		}
		catch (Exception e)
		{
			// Do nothing for now
		}
	}
	
	public static void modify() {
		
	}
	
	public static void save() {
		
	}
	
	public static void load() {
		
	}
	
	// Creates a text file representation of the To Do list.
	public static void print(ArrayList<Task> taskList) {
		// Creates and opens a file chooser so that the user
		// can select where they want to save the file and a file name.
		JFileChooser fileChooser = new JFileChooser();
    	fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    	int returnVal = fileChooser.showSaveDialog(null);
    	
    	// If the user clicked the save button do this
    	if (returnVal == JFileChooser.APPROVE_OPTION)
    	{
    		// Gets the path where the file will be saved to.
    		String path = fileChooser.getSelectedFile().getAbsolutePath();
        	try
        	{
        		PrintWriter newFile = new PrintWriter(new File(path + ".txt"));
        		newFile.write("To Do List\n\n");
        		
        		for (Task task : taskList)
        		{
        			newFile.write("Priority: " + task.getPriority() + "\n");
        			newFile.write("Description: " + task.getDescription() + "\n");
        			newFile.write("Due Date: " + task.getDueDate() + "\n");
        			newFile.write("Status: " + task.getStatus() + "\n");
        			newFile.write("Start Date: " + task.getStartDate() + "\n");
        			newFile.write("End Date: " + task.getEndDate() + "\n\n");
        		}
        		newFile.close();
        		
        	}
        	catch (FileNotFoundException ex)
        	{
        		
        	}
    	}
	}
	
	public static void sort() {
		
	}
	
	public static void prioritySort(){
						
	}
	
	Object task;
	

}




