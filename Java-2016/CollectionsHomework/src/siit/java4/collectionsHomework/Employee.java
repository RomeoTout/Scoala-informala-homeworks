package siit.java4.collectionsHomework;

import siit.java4.collectionsHomework.Employee;
/**
 * @param name of the employee
 * @param yearsWorked represents seniority
 * @param parkingSpace 
 */
public class Employee implements Comparable<Employee> {
	String name;
	int yearsWorked;
	boolean parkingSpace;

	public Employee(String name, int yearsWorked, boolean parkingSpace) {
		super();
		this.name = name;
		this.yearsWorked = yearsWorked;
		this.parkingSpace = parkingSpace;
	}
/**
 * @param yearsWorked represents the number of years the employee worked at the company
 * sorts the objects according to the number of years worked
 */
	@Override
	public int compareTo(Employee arg0) {
		if (this.yearsWorked == arg0.yearsWorked) {
			return 0;
		} else if (this.yearsWorked < arg0.yearsWorked) {
			return 1;
		} else {
			return -1;
		}
	}
}
