import java.util.ArrayList;

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
	
	public static void print() {
		
	}
	
	public static void sort() {
		
	}
	
	public static void prioritySort(){
						
	}
	
	Object task;
	

}




