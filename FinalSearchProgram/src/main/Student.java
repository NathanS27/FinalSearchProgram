package main;

public class Student {

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
}
