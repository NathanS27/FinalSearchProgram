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
	
	public ArrayList<Comparable> binarySearch(ArrayList<Comparable> arr, Comparable item,char c) throws FormatException{
		ArrayList<Comparable> result = new ArrayList<>();
		ArrayList<Comparable> searchArr = new ArrayList<>(selectionSort(arr,arr.size()));
		int start = 0;
		int end = searchArr.size()-1;
		int mid = (end-start)/2;
		switch(c) {
		case 'E':
			while(start <= end) {
				if(((Employee)(searchArr.get(mid))).compareTo(item) < 0) {
					start = mid + 1;
				}
				else if(((Employee)(searchArr.get(mid))).compareTo(item) > 0) {
					end = mid - 1;
				}
				else {
					result.add(searchArr.get(mid));
					searchArr.remove(mid);
					start = 0;
					end = searchArr.size()-1;
					mid = (start+end)/2;
					continue;
				}
				mid = (start+end)/2;
			}
			break;
		case 'S':
			while(start <= end) {
				if(((Student)(searchArr.get(mid))).compareTo(item) < 0) {
					start = mid + 1;
				}
				else if(((Student)(searchArr.get(mid))).compareTo(item) > 0) {
					end = mid - 1;
				}
				else {
					result.add(searchArr.get(mid));
					searchArr.remove(mid);
					start = 0;
					end = searchArr.size()-1;
					mid = (start+end)/2;
					continue;
				}
				mid = (start+end)/2;
			}
			break;
		case 'W':
			while(start <= end) {
				if(((Widget)(searchArr.get(mid))).compareTo(item) < 0) {
					start = mid + 1;
				}
				else if(((Widget)(searchArr.get(mid))).compareTo(item) > 0) {
					end = mid - 1;
				}
				else {
					result.add(searchArr.get(mid));
					searchArr.remove(mid);
					start = 0;
					end = searchArr.size()-1;
					mid = (start+end)/2;
					continue;
				}
				mid = (start+end)/2;
			}
			break;
		}
		
		if(result.size()>0) {
			return result;
		}
		throw new FormatException("Search unsuccessful.");
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
				searchThis=selectionSort(getWidgets(), getWidgets().size());
				for(int i=0;i<searchThis.size();i++) {
					try {
						switch(((Widget)(searchThis.get(i))).compareTo(new Widget("111",Integer.parseInt(key)))) {
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
