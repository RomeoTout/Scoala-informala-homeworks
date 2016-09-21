package siit.java4.collectionsHomework;

import java.util.ArrayList;
import java.util.TreeSet;

public class CompanyManagementSystem {

	/**
	 * iterates through an array of objects and copies the objects with
	 * !parkingSpace into a treeSet
	 * 
	 * @param arrthe ArrayList that contains the objects
	 *            
	 * @return a treeSet containing the object with boolean parkingSpace false
	 */
	public static TreeSet noParkingEmployees(ArrayList<Employee> arr) {
		TreeSet<Employee> employeesWithoutParkingSpace = new TreeSet<>();
		for (int i = 0; i < arr.size(); i++) {
			Employee employee = arr.get(i);
			if (!employee.parkingSpace) {
				employeesWithoutParkingSpace.add(employee);
			}
		}
		return employeesWithoutParkingSpace;
	}

}