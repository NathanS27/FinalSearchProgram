package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BreezySwing.*;

public class FinalSearchUI extends GBFrame {

	JMenuItem displayEmployee = addMenuItem("Display","Employees");
	JMenuItem displayStudent = addMenuItem("Display","Students");
	JMenuItem displayWidget = addMenuItem("Display","Widgets");
	JMenuItem populate = addMenuItem("Display","populate");
	
	JPanel dataLayout = addPanel(1,2,1,1);
	JTable dataTable = null;
	DefaultTableModel dataModel = null;
	
	String[] columnNames = new String[2];
	
	ArrayList<Object> list = new ArrayList<>();
	
	public FinalSearchUI(){
		display();
	}
	
	public ArrayList<Object> getStudents() {
		ArrayList<Object> students = new ArrayList<>();
		for(Object s:list) {
			if(s.getClass().equals(Student.class)) {
				students.add((Student)s);
			}
		}
		int size=students.size();
		for(int i=1;i<size-1;i++) {
			int min=i;
			for(int j=i+1;j<size;j++) {
				if(((Student)(students.get(j))).getGpa()<(((Student)(students.get(min))).getGpa())) {
					min=j;
				}
			}
			if(min!=i) {
				Object temp=students.get(min);
				students.set(min, students.get(i));
				students.set(i, temp);
			}
		}
		return students;
	}
	
	public ArrayList<Object> getEmployees() {
		ArrayList<Object> employees = new ArrayList<>();
		for(Object s:list) {
			if(s.getClass().equals(Employee.class)) {
				employees.add((Employee)s);
			}
		}
		int size=employees.size();
		for(int i=1;i<size-1;i++) {
			int min=i;
			for(int j=i+1;j<size;j++) {
				if(((Employee)(employees.get(j))).getSalary()<(((Employee)(employees.get(min))).getSalary())) {
					min=j;
				}
			}
			if(min!=i) {
				Object temp=employees.get(min);
				employees.set(min, employees.get(i));
				employees.set(i, temp);
			}
		}
		return employees;
	}
	
	public ArrayList<Object> getWidgets() {
		ArrayList<Object> widgets = new ArrayList<>();
		for(Object s:list) {
			if(s.getClass().equals(Student.class)) {
				widgets.add((Widget)s);
			}
		}
		return widgets;
	}
	
	public void menuItemSelected(JMenuItem m) {
		if(m==populate) {
			list.add(new Employee("Matt",1200));
			list.add(new Employee("Noah",1500));
			list.add(new Employee("Mike",1400));
			list.add(new Student("Jonathan",3.5));
			list.add(new Student("Nate",4.6));
			list.add(new Student("Robby",3.7));
		}
		if(m==displayEmployee) {
			columnNames[0]="Names";
			columnNames[1]="Salary";
			dataModel.setColumnCount(0);
			dataModel.setColumnIdentifiers(columnNames);
			displayObjects(getEmployees());
		}
		if(m==displayStudent) {
			columnNames[0]="Names";
			columnNames[1]="GPA";
			dataModel.setColumnCount(0);
			dataModel.setColumnIdentifiers(columnNames);
			displayObjects(getStudents());
		}
	}
	
	private void display() {
		String[] columnNames = {"1", "2"};
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
			dataRow[1] = String.format("%.2f", ((Student)(obj)).getGpa());
		}
		if(obj.getClass().equals(Employee.class)) {
			dataRow[0] = ((Employee)(obj)).getName();
			dataRow[1] = String.format("%.2f", ((Employee)(obj)).getSalary());
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
