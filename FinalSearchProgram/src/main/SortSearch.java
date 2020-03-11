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
	
	public ArrayList<Comparable> binarySearch(ArrayList<Comparable> list, Comparable item){
		ArrayList<Comparable> results = new ArrayList<Comparable>();
			int first = 0;
			int last = list.size();
			int n = list.size()/2;
			int temp;
			System.out.println("First: "+first);
			System.out.println("n: "+n);
			System.out.println("Last: "+last);
			while(first <= last) {
				if(list.get(n).compareTo(item) < 0) {
					//right half
					first = n + 1;
					System.out.println("First: "+first);
					System.out.println("n: "+n);
					System.out.println("Last: "+last);
					System.out.println("Right");
				}
				else if (list.get(n).compareTo(item) > 0) {
					//left half
					last = n - 1;
					System.out.println("First: "+first);
					System.out.println("n: "+n);
					System.out.println("Last: "+last);
					System.out.println("Left ");
				}
				else {
					//equals
					results.add(list.get(n));
					System.out.println("added: "+list.get(n).toString());
					temp=n;
					while(n<list.size()-1&&list.get(n).compareTo(item)==0) {
						results.add(list.get(n));
						n++;
					}
					n=temp-1;
					while(n>0 && list.get(n).compareTo(item)==0) {
						results.add(list.get(n));
						n--;
					}
					break;
				}
				n = (first + last)/2;
				System.out.println("First: "+first);
				System.out.println("n: "+n);
				System.out.println("Last: "+last);
			System.out.println("NOT FOUND");
			}
		return results;
	}

	public ArrayList<Comparable> linearSearch(String key, char cd){
		ArrayList<Comparable> searchThis;
		ArrayList<Comparable> searchResults = new ArrayList<>();
			switch(cd) {
			case 'E':
				//test
				searchThis=selectionSort(getEmployees(), getEmployees().size());
				for(int i=0;i<searchThis.size();i++) {
					try {
						switch(((Employee)(searchThis.get(i))).compareTo(new Employee("COMPARE",Integer.parseInt(key)))) {
						case -1:
							//if name comes later in the array
							break;
						case 0:
							searchResults.add(searchThis.get(i));
						case 1:
							//if searching past where name should be,not found
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
						break;
					case 0:
						searchResults.add(searchThis.get(i));
					case 1:
						//if searching past where name should be,not found
						break;
					}
					
				}
				return searchResults;
			case 'W':
				selectionSort(getWidgets(), getWidgets().size());
				return searchResults;
			}
		return null;
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
