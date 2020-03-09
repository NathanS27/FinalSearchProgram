package main;

public class Employee implements Comparable  {

	private String name;
	private double salary;
	
	public Employee(String nm, double pay) throws FormatException {
		if(nm.isEmpty()) {
			throw new FormatException("Please Enter a Name");
		}
		if(pay<0) {
			throw new FormatException("Pay cannot be negative");
		}
		name=nm;
		salary=pay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int compareTo(Object obj) {
		if(((Employee)(obj)).getSalary()<(this.getSalary())){
			return -1;
		}
		if(((Employee)(obj)).getSalary()>(this.getSalary())){
			return 1;
		}
		else{
			return 0;
		}
	}
}
