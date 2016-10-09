package siit.java4.collectionsHomework;

public class Employee implements Comparable<Employee>{
	String name;
	int yearsWorked;
	boolean parkingSpace;
	int identificationNumber;

	public Employee(String name, int yearsWorked, boolean parkingSpace, int identificationNumber) {
		super();
		this.name = name;
		this.yearsWorked = yearsWorked;
		this.parkingSpace = parkingSpace;
		this.identificationNumber = identificationNumber;
	}
/**
 * @param yearsWorked represents the number of years the employee worked at the company
 * sorts the objects according to the number of years worked and checks the identificationNumber for duplicates
 */
	@Override
	public int compareTo(Employee arg0) {
		if (this.yearsWorked == arg0.yearsWorked && this.identificationNumber==arg0.identificationNumber) {
			return 0;
		} else if (this.yearsWorked < arg0.yearsWorked) {
			return 1;
		} else {
			return -1;
		}
	}
}
