package main;

public class Student implements Comparable {

	private String name;
	private double gpa;
	
	public Student(String nm, double grade) {
		name=nm;
		gpa=grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public int compareTo(Object obj) {
		return ((Student)(obj)).getName().compareTo(this.getName());
	}
}
