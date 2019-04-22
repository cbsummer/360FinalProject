
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class ToDoListUI extends javax.swing.JFrame {
	                     
    private javax.swing.JButton addTask;
    private javax.swing.JButton deleteTask;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton openTask;
    private javax.swing.JButton printTask;
    private javax.swing.JButton saveTask;
    private javax.swing.JTextField taskDescription;
    private javax.swing.JFormattedTextField taskDueDate;
    private javax.swing.JFormattedTextField taskEndDate;
    private javax.swing.JTextField taskPriority;
    private javax.swing.JFormattedTextField taskStartDate;
    private javax.swing.JComboBox taskStatus;
    private javax.swing.JTable taskTable;
    private javax.swing.JButton taskUpdate;
    private javax.swing.JButton taskUpdate1;  

	ArrayList<Task> taskList = new ArrayList<>();
      
    public ToDoListUI() {
        initComponents();    
    }

    @SuppressWarnings("unchecked")                      
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taskTable = new javax.swing.JTable();
        addTask = new javax.swing.JButton();
        deleteTask = new javax.swing.JButton();
        saveTask = new javax.swing.JButton();
        printTask = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        taskDescription = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        taskPriority = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        taskDueDate = new javax.swing.JFormattedTextField();
        taskStatus = new javax.swing.JComboBox();
        taskStartDate = new javax.swing.JFormattedTextField();
        taskEndDate = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        taskUpdate = new javax.swing.JButton();
        openTask = new javax.swing.JButton();
        taskUpdate1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "To DO List Unlimited 2019", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        taskTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Priority", "Description", "Due Date", "Status", "Start Date", "End Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        
        taskTable.setAutoscrolls(false);
        taskTable.setCellSelectionEnabled(false);
        taskTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        taskTable.setFillsViewportHeight(true);
        taskTable.setName(""); // NOI18N
        taskTable.setRowSelectionAllowed(true);
        taskTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(taskTable);
        taskTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        TableColumnModel columns =taskTable.getColumnModel();
        columns.getColumn(1).setPreferredWidth(170);
        
        //Applies a sorter to the columns of the table.
        //Sort keys are used to keep the tasks added to the list in the order that the table is currently sorted by.
        TableRowSorter<TableModel> taskTableSort = new TableRowSorter<>(taskTable.getModel());
        taskTableSort.setSortsOnUpdates(true);
        List<RowSorter.SortKey> key = new ArrayList<RowSorter.SortKey>();
        key.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        taskTableSort.setSortKeys(key);
        taskTable.setRowSorter(taskTableSort);
        
        
        addTask.setText("Add");
        addTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTaskActionPerformed(evt);
            }
        });

        deleteTask.setText("Delete");
        deleteTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTaskActionPerformed(evt);
            }
        });

        saveTask.setText("Save");
        saveTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTaskActionPerformed(evt);
            }
        });

        printTask.setText("Print");
        printTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printTaskActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Task Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
        jLabel1.setText("Description:");
        jLabel2.setText("Priority:");
        jLabel3.setText("Status:");
        jLabel4.setText("Due Date:");
        jLabel5.setText("Start Date:");
        jLabel6.setText("End Date:");
        
        taskDueDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("M/d/yyyy"))));
        taskDueDate.setToolTipText("mm/dd/yyyy");

        taskStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Not Started", "In Progress", "Finished" }));

        taskStartDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("M/d/yyyy"))));
        taskStartDate.setToolTipText("mm/dd/yyyy");

        taskEndDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("M/d/yyyy"))));
        taskEndDate.setToolTipText("mm/dd/yyyy");


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2)
                        .addComponent(taskPriority, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(2, 2, 2)
                        .addComponent(taskDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(taskDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(taskStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(taskStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(taskEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(taskPriority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(taskDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(taskStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(taskDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(taskStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(taskEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        taskUpdate.setText("Update");
        taskUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskUpdateActionPerformed(evt);
            }
        });

        openTask.setText("Load");
        openTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openTaskActionPerformed(evt);
            }
        });

        taskUpdate1.setText("Edit");
        taskUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskUpdate1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(addTask)
                            .addGap(4, 4, 4)
                            .addComponent(taskUpdate1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(taskUpdate)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(deleteTask))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(saveTask)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(openTask)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(printTask))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveTask)
                    .addComponent(printTask)
                    .addComponent(openTask))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTask)
                    .addComponent(deleteTask)
                    .addComponent(taskUpdate)
                    .addComponent(taskUpdate1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }                       

	private void addTaskActionPerformed(java.awt.event.ActionEvent evt) {

		// added a boolean isUnique and iterated through taskList. Throws an error
		// message if there is a duplicate

		boolean isInteger = true;

		try {
			Integer.parseInt(taskPriority.getText());
		} catch (NumberFormatException e) {
			isInteger = false;
		}

		if (isInteger == false) {
			JOptionPane.showMessageDialog(null, "Priority must be a number.", "Error", JOptionPane.WARNING_MESSAGE);
		} else {
			int data1 = Integer.parseInt(taskPriority.getText());
			String data2 = taskDescription.getText();
			String data3 = taskDueDate.getText();
			String data4 = taskStatus.getSelectedItem().toString();
			String data5 = taskStartDate.getText();
			String data6 = taskEndDate.getText();

			boolean isUnique = true;

			for (Task iterator : taskList) {
				if (iterator.getDescription().equals(taskDescription.getText())) {
					isUnique = false;
				}
			}

			if (isUnique == true) {

				Object[] row = { data1, data2, data3, data4, data5, data6 };
				DefaultTableModel model = (DefaultTableModel) taskTable.getModel();

				Task task = new Task(data1, data2, data3, data4, data5, data6);
				//taskList.add(task);
				boolean foundDuplicate = ToDoListFunctions.add(taskList, task);
				
				// If no duplicates were found the task can be added normally.
				if (!foundDuplicate)
				{
					model.addRow(row);
				}
				else
				{
					// Clear the list and add the tasks again with their new
					// priorities
					model.setRowCount(0);
					for (int i = 0; i < taskList.size(); i++)
			    	{
			    		Object[] newRow = 
			    			  { taskList.get(i).getPriority(), 
			    				taskList.get(i).getDescription(), 
			    				taskList.get(i).getDueDate(), 
			    				taskList.get(i).getStatus(), 
			    				taskList.get(i).getStartDate(), 
			    				taskList.get(i).getEndDate() };
			    		
			    		
			    	    model.addRow(newRow);
			    	}
				}
				
				// Clear the text fields after adding.
				taskPriority.setText("");
				taskDescription.setText("");
				taskDueDate.setText("");
				taskStartDate.setText("");
				taskEndDate.setText("");
				taskStatus.setSelectedIndex(0);

			} else {
				JOptionPane.showMessageDialog(null, "Cannot insert duplicate description.", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}                   

	private void taskUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		// added a boolean isUnique and iterated through taskList. Throws an error
		// message if there is a duplicate

		boolean isInteger = true;

		int rowIndex = taskTable.getSelectedRow();
		if (rowIndex != -1) {

			try {
				Integer.parseInt(taskPriority.getText());
			} catch (NumberFormatException e) {
				isInteger = false;
			}

			if (isInteger == false) {
				JOptionPane.showMessageDialog(null, "Priority must be a number.", "Error", JOptionPane.WARNING_MESSAGE);
			} else {
				int data1 = Integer.parseInt(taskPriority.getText());
				String data2 = taskDescription.getText();
				String data3 = taskDueDate.getText();
				String data4 = taskStatus.getSelectedItem().toString();
				String data5 = taskStartDate.getText();
				String data6 = taskEndDate.getText();

				boolean isUnique = true;

				for (Task iterator : taskList) {
					if (iterator.getDescription().equals(taskDescription.getText())) {
						isUnique = false;
					}
				}

				// if description wasn't changed don't count as duplicate.
				rowIndex = taskTable.getSelectedRow();
				// rowIndex = taskTable.convertRowIndexToModel(rowIndex);
				if (data2.equals(taskTable.getValueAt(rowIndex, 1))) {
					isUnique = true;
				}

				if (isUnique == true) {

					// Delete Element from ArrayList and taskTable
					ToDoListFunctions.delete(taskList, taskTable);

					// Re-add the new task with edited fields
					Object[] row = { data1, data2, data3, data4, data5, data6 };
					DefaultTableModel model = (DefaultTableModel) taskTable.getModel();

					Task task = new Task(data1, data2, data3, data4, data5, data6);
					boolean foundDuplicate = ToDoListFunctions.add(taskList, task);

					// If no duplicates were found the task can be added normally.
					if (!foundDuplicate) {
						model.addRow(row);
					} else {
						// Clear the list and add the tasks again with their new
						// priorities
						model.setRowCount(0);
						for (int i = 0; i < taskList.size(); i++) {
							Object[] newRow = { taskList.get(i).getPriority(), taskList.get(i).getDescription(),
									taskList.get(i).getDueDate(), taskList.get(i).getStatus(),
									taskList.get(i).getStartDate(), taskList.get(i).getEndDate() };

							model.addRow(newRow);
						}
					}

					// Clear the text fields after adding.
					taskPriority.setText("");
					taskDescription.setText("");
					taskDueDate.setText("");
					taskStartDate.setText("");
					taskEndDate.setText("");
					taskStatus.setSelectedIndex(0);

				} else {
					JOptionPane.showMessageDialog(null, "Cannot insert duplicate description.", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}                                   

    private void openTaskActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	try
    	{
    		FileInputStream fis = new FileInputStream("TaskList");
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            taskList = (ArrayList<Task>) ois.readObject();
            
            ois.close();
            fis.close();
    	}
    	
    	catch (IOException ioe)
    	{
    		JOptionPane.showMessageDialog(null, "The To Do List must be saved before loading.",
    				"Error", JOptionPane.WARNING_MESSAGE);
    	}
    	catch (ClassNotFoundException c)
    	{
    		
    	}
    	
    	DefaultTableModel model = (DefaultTableModel) taskTable.getModel();
    	model.setRowCount(0);
    	
    	// Sets SortKey to null so that tasks are reinserted exactly how they
    	// are saved instead of int the current sorted order.
    	//RowSorter rs = taskTable.getRowSorter();
    	//rs.setSortKeys(null);
    	for (int i = 0; i < taskList.size(); i++)
    	{
    		Object[] row = 
    			  { taskList.get(i).getPriority(), 
    				taskList.get(i).getDescription(), 
    				taskList.get(i).getDueDate(), 
    				taskList.get(i).getStatus(), 
    				taskList.get(i).getStartDate(), 
    				taskList.get(i).getEndDate()
    			  };
    		
    	    model.addRow(row);
    	}   	  	
    }                                        

    private void printTaskActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	ToDoListFunctions.print(taskList);
    }                                         

    private void deleteTaskActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	
    	ToDoListFunctions.delete(taskList, taskTable); 	
    }
    	                                     

    private void saveTaskActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	try
        {
            FileOutputStream fos = new FileOutputStream("TaskList");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(taskList);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    	
        
    }                                        

    private void taskUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	try
    	{
    		int rowIndex = taskTable.getSelectedRow();
        	taskPriority.setText(String.valueOf(taskTable.getValueAt(rowIndex, 0)));
    		taskDescription.setText((String) taskTable.getValueAt(rowIndex, 1));
    		taskDueDate.setText((String) taskTable.getValueAt(rowIndex, 2));
    		taskStartDate.setText((String) taskTable.getValueAt(rowIndex, 4));
    		taskEndDate.setText((String) taskTable.getValueAt(rowIndex, 5));
    		taskStatus.setSelectedItem((String) taskTable.getValueAt(rowIndex, 3));
    	}
		catch (Exception ex)
    	{
			
    	}
    }                                           


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ToDoListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ToDoListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ToDoListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ToDoListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ToDoListUI().setVisible(true);
            }
        });
    }                
}
