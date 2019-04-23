import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

public class ToDoListFunctions {


	// Adds the tasks into the ArrayList based on their priority
	// returns true if there was a duplicate priority that needed
	// to be bumped down.
	public static boolean add(ArrayList<Task> taskList, Task task) {
		int size = taskList.size();
		boolean notFound = true;
		boolean foundDuplicate = false;
		// insert at correct position
		if (size == 0)
		{
			taskList.add(task);
			notFound = false;
		}
		else {
			for (int i = 0; i < size && notFound; i++)
			{	
				int value1 = task.getPriority();
				int value2 = taskList.get(i).getPriority();
				if (value1 <= value2)
				{
					taskList.add(i, task);
					notFound = false;
				}
			}
		}
		if (notFound)
		{
			taskList.add(task);
		}
		
		size = taskList.size();
		
		if (size > 1)
		{
			// bump down priority of duplicates
			for (int i = 0; i < size - 1; i++)
			{
				int value1 = taskList.get(i).getPriority();
				int value2 = taskList.get(i+1).getPriority();
				if (value1 == value2)
				{
					taskList.get(i+1).setPriority(taskList.get(i+1).getPriority() + 1);
					foundDuplicate = true;
				}
					
			}
		}
		return foundDuplicate;
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
        		newFile.write("To Do List" + System.lineSeparator() + System.lineSeparator());
        		
        		for (Task task : taskList)
        		{
        			newFile.write("Priority: " + task.getPriority() + System.lineSeparator());
        			newFile.write("Description: " + task.getDescription() + System.lineSeparator());
        			newFile.write("Due Date: " + task.getDueDate() + System.lineSeparator());
        			newFile.write("Status: " + task.getStatus() + System.lineSeparator());
        			newFile.write("Start Date: " + task.getStartDate() + System.lineSeparator());
        			newFile.write("End Date: " + task.getEndDate() + System.lineSeparator() + System.lineSeparator());
        		}
        		newFile.close();
        		
        	}
        	catch (FileNotFoundException ex)
        	{
        		
        	}
    	}
	}

}




