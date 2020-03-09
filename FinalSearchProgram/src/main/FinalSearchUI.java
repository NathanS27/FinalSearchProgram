package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BreezySwing.*;

public class FinalSearchUI extends GBFrame {

	JMenuItem addEmployee = addMenuItem("Add","Employee");
	JMenuItem addStudent = addMenuItem("Add","Student");
	JMenuItem addWidget = addMenuItem("Add","Widget");
	JMenuItem populate = addMenuItem("Add","Populate");
	
	JMenuItem displayEmployee = addMenuItem("Display","Employees");
	JMenuItem displayStudent = addMenuItem("Display","Students");
	JMenuItem displayWidget = addMenuItem("Display","Widgets");
	
	JPanel dataLayout = addPanel(1,1,2,1);
	JTable dataTable = null;
	DefaultTableModel dataModel = null;
	
	JButton insertionSort = addButton("Insertion Sort",2,1,1,1);
	JButton selectionSort = addButton("Selection Sort",2,2,1,1);
	private char currentDisplay;
	
	String[] columnNames = new String[2];
	
	ArrayList<Comparable> list = new ArrayList<>();
	
	SortSearch sorter=new SortSearch();
	
	public FinalSearchUI(){
		display();
		dataLayout.setBackground(Color.black);
		dataTable.setGridColor(new Color(232, 72, 60));
		populate.setBackground(new Color(232, 72, 60));;
	}
	
	public ArrayList<Comparable> getStudents() {
		ArrayList<Comparable> students = new ArrayList<>();
		for(Comparable s:list) {
			if(s.getClass().equals(Student.class)) {
				students.add((Student)s);
			}
		}
		return students;
	}
	
	public ArrayList<Comparable> getEmployees() {
		ArrayList<Comparable> employees = new ArrayList<>();
		for(Comparable s:list) {
			if(s.getClass().equals(Employee.class)) {
				employees.add((Employee)s);
			}
		}
		return employees;
	}
	
	public ArrayList<Comparable> getWidgets() {
		ArrayList<Comparable> widgets = new ArrayList<>();
		for(Comparable s:list) {
			if(s.getClass().equals(Widget.class)) {
				widgets.add((Widget)s);
			}
		}
		return widgets;
	}
	
	public void menuItemSelected(JMenuItem m) {
		if(m==populate) {
			try {
			list.add(new Employee("Matt",1200));
			list.add(new Employee("Noah",1500));
			list.add(new Employee("Terrian",3));
			list.add(new Employee("Mike",1400));
			list.add(new Student("Nate",4.6));
			list.add(new Student("Jonathan",3.5));
			list.add(new Student("Nate",4));
			list.add(new Student("Robby",3.7));
			int i=0;
			Random rand = new Random();
			while(i<8) {
				list.add(new Widget(String.format("%d", rand.nextInt(999)),rand.nextInt(9999)));
				i++;
			}
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
			}
			populate.setVisible(false);
		}
		if(m==displayEmployee) {
			columnNames[0]="Names";
			columnNames[1]="Salary";
			dataModel.setColumnCount(0);
			dataModel.setColumnIdentifiers(columnNames);
			currentDisplay='E';
			displayComparables(getEmployees());
		}
		if(m==displayStudent) {
			columnNames[0]="Names";
			columnNames[1]="GPA";
			dataModel.setColumnCount(0);
			dataModel.setColumnIdentifiers(columnNames);
			currentDisplay='S';
			displayComparables(getStudents());
		}
		if(m==displayWidget) {
			columnNames[0]="Product Num";
			columnNames[1]="Number Sold";
			dataModel.setColumnCount(0);
			dataModel.setColumnIdentifiers(columnNames);
			currentDisplay='W';
			displayComparables(getWidgets());
		}
		if(m==addStudent) {
			AddDlg dlg = new AddDlg(this,1,list);
		}
		if(m==addEmployee) {
			AddDlg dlg = new AddDlg(this,0,list);
		}
		if(m==addWidget) {
			AddDlg dlg = new AddDlg(this,9,list);
		}
	}
	
	public void buttonClicked(JButton b) {
		if(b==insertionSort) {
			if(currentDisplay=='E') {
				displayComparables(sorter.insertionSort(getEmployees(), getEmployees().size()));
			}
			if(currentDisplay=='S') {
				displayComparables(sorter.insertionSort(getStudents(), getStudents().size()));
			}
			if(currentDisplay=='W') {
				displayComparables(sorter.insertionSort(getWidgets(), getWidgets().size()));
			}
		}
		if(b==selectionSort) {
			if(currentDisplay=='E') {
				displayComparables(sorter.selectionSort(getEmployees(), getEmployees().size()));
			}
			if(currentDisplay=='S') {
				displayComparables(sorter.selectionSort(getStudents(), getStudents().size()));
			}
			if(currentDisplay=='W') {
				displayComparables(sorter.selectionSort(getWidgets(), getWidgets().size()));
			}
		}
	}
	
	private void display() {
		String[] columnNames = {"", ""};
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

	private void displayComparables(ArrayList<Comparable> list) {
		dataModel.setRowCount(0);
		for(Comparable obj:list) {
			displayComparable(obj);
		}
	}
	
	private void displayComparable(Comparable obj) {
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
