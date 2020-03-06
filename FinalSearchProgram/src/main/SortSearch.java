package main;

import java.util.ArrayList;

public class SortSearch {

	public ArrayList<Comparable> selectionSort(ArrayList<Comparable> a,int size){
		for(int i=1;i<size-1;i++) {
			int max=i;
			for(int j=i+1;j<size;j++) {
				if(a.get(j).compareTo(a.get(max))>0) {
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
}
