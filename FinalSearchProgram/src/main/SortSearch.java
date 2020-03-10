package main;

import java.util.ArrayList;

public class SortSearch {
	
	ArrayList<Comparable> list = new ArrayList<>();
	
	public SortSearch(ArrayList<Comparable> b) {
		list=b;
	}
	
	public ArrayList<Comparable> selectionSort(ArrayList<Comparable> a,int size){
		for(int i=0;i<size-1;i++) {
			int max=i;
			for(int j=i+1;j<size;j++) {
				if(a.get(j).compareTo(a.get(max))<=0) {
					max=j;
				}
			}
			if(max!=i) {
				Comparable temp=a.get(max);
				a.set(max, a.get(i));
				a.set(i, temp);
			}
		}
		return a;
	}
	
	public ArrayList<Comparable> insertionSort(ArrayList<Comparable> a,int size){
		int holePosition;
		Comparable valueToInsert;
		  for(int i=1;i<size;i++) {
			  valueToInsert=a.get(i);
			  holePosition=i;
			  while(holePosition>0 && (a.get(holePosition-1).compareTo(valueToInsert)>0)) {
				  a.set(holePosition, a.get(holePosition-1));
				  holePosition-=1;
			  }
			  a.set(holePosition, valueToInsert);
		  }
		  return a;
	}

	public ArrayList<Comparable> linearSearch(String key, char cd) {
		ArrayList<Comparable> searchThis;
		ArrayList<Comparable> searchResults = new ArrayList<>();
			switch(cd) {
			case 'E':
				searchThis=selectionSort(getEmployees(), getEmployees().size());
				for(int i=0;i<searchThis.size();i++) {
					try {
						switch(((Employee)(searchThis.get(i))).compareTo(new Employee("COMPARE",Integer.parseInt(key)))) {
						case -1:
							//if name comes later in the array
							System.out.println("-1");
							break;
						case 0:
							System.out.println("Added to display");
							searchResults.add(searchThis.get(i));
						case 1:
							//if searching past where name should be,not found
							System.out.println("not found");
							break;
						}
					}
					catch(FormatException e) {
						
					}
				}
				return searchResults;
			case 'S':
				searchThis=selectionSort(getStudents(), getStudents().size());
				for(int i=0;i<searchThis.size();i++) {
					switch(((Student)(searchThis.get(i))).getName().compareToIgnoreCase(key)) {
					case -1:
						//if name comes later in the array
						System.out.println("-1");
						break;
					case 0:
						System.out.println("Added to display");
						searchResults.add(searchThis.get(i));
					case 1:
						//if searching past where name should be,not found
						System.out.println("not found");
						break;
					}
				}
				break;
			case 'W':
				selectionSort(getWidgets(), getWidgets().size());
				break;
			}
			
		//ran out of items to search, key not found
		return searchResults;
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
}
