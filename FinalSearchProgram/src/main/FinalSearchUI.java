package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BreezySwing.*;

public class FinalSearchUI extends GBFrame {

	JMenuItem addEmployee = addMenuItem("new","Employee");
	JMenuItem addStudent = addMenuItem("new","Student");
	JMenuItem addWidget = addMenuItem("new","Widget");
	
	JPanel dataLayout = addPanel(1,2,1,1);
	JTable dataTable = null;
	DefaultTableModel dataModel = null;
	ArrayList<Object> list = new ArrayList<>();
	
	public void menuItemSelected(JMenuItem m) {
		if(m==addEmployee) {
			display("Name","Salary");
			list.add(new Employee("Matt",12300));
			displayObjects(list);
		}
	}
	
	private void display(String title1, String title2) {
		String[] columnNames = {title1, title2};
		String[][] StudentData = {{"",""}};

		// Set the layout mode of the data panel
		dataLayout.setLayout(new BorderLayout());
		
		// Create the placeholder table and put it in a scroll pane
		dataTable = new JTable (StudentData,columnNames);
		dataModel = new DefaultTableModel();
		dataModel.setColumnIdentifiers(columnNames);
        dataTable.setModel(dataModel);
        
        //sets the alignment
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        dataTable.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        dataTable.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
     

		// Add the scrollPane to the panel and put it in the center so it uses the full panel
		JScrollPane scrollPane = new JScrollPane(dataTable);
		dataLayout.add(scrollPane,BorderLayout.CENTER);
		dataTable.disable();
	}

	private void displayObjects(ArrayList<Object> list) {
		dataModel.setRowCount(0);
		for(Object obj:list) {
			displayObject(obj);
		}
	}
	
	private void displayObject(Object obj) {
		String[] dataRow = new String[2];
		if(obj.getClass().equals(Student.class)) {
			dataRow[0] = ((Student)(obj)).getName();
			dataRow[1] = String.format("%f", ((Student)(obj)).getGpa());
		}
		if(obj.getClass().equals(Employee.class)) {
			dataRow[0] = ((Employee)(obj)).getName();
			dataRow[1] = String.format("%f", ((Employee)(obj)).getSalary());
		}
		if(obj.getClass().equals(Widget.class)) {
			dataRow[0] = String.format("%d", ((Widget)(obj)).getProductNum());
			dataRow[1] = String.format("%d", ((Widget)(obj)).getNumSold());
		}
		
		dataModel.addRow(dataRow);
	}
	
	public static void main(String[] args) {
		JFrame frm = new FinalSearchUI();
		frm.setSize(500,300);
		frm.setTitle("Final Search");
		frm.getContentPane().setBackground(new Color(232, 72, 60));
		frm.setResizable(true);
		frm.setVisible(true);
		frm.setLocationRelativeTo(null);
	}
}
