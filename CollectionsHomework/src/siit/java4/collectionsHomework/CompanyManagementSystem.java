package siit.java4.collectionsHomework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
	public TreeSet noParkingEmployees(List<Employee> arr) {
		TreeSet<Employee> employeesWithoutParkingSpace = new TreeSet<>();
		for (int i = 0; i < arr.size(); i++) {
			Employee employee = arr.get(i);
			if (!employee.parkingSpace) {
				employeesWithoutParkingSpace.add(employee);
			}
		}
		return employeesWithoutParkingSpace;
	}
	
	ArrayList<Employee> employees = new ArrayList<Employee>();
	Employee worker1 = new Employee("John Johnnson", 6, false , 111);
	Employee worker2 = new Employee("David Davidson", 19, true, 101);
	Employee worker3 = new Employee("Paul Paulsen", 12, false, 106);
	Employee worker4 = new Employee("Paul Paulsen", 12, false, 105);
	Employee worker5 = new Employee("Vasili Vasilievici", 17, false, 102);

	LinkedList<Employee> managers = new LinkedList<Employee>();
	Manager mng1 = new Manager("Rob Robson", 7, false, 110);
	Manager mng2 = new Manager("Jaime Jameson", 11, false, 107);
	Manager mng3 = new Manager("Brad Bradsen", 13, true, 104);
	Manager mng4 = new Manager("Cristinel Cristinescu", 11, false, 112);
	
	LinkedList<Employee> engineers = new LinkedList<Employee>();
	Engineer eng1 = new Engineer("Ion Ionescu", 9, false, 108);
	Engineer eng2 = new Engineer("Stefan Stefanescu", 14, true, 103);
	Engineer eng3 = new Engineer("George Georgescu", 9, false, 109);
	/**
	 * Stores the employees without parking space
	 */
	TreeSet<Employee> employeesWithoutParkingSpace = new TreeSet<Employee>();
	/**
	 * Stores the managers without parking space
	 */
	TreeSet<Employee> managersWithoutParkingSpace = new TreeSet<Employee>();
	/**
	 * Stores the engineers without parking space
	 */
	TreeSet<Employee> engineersWithoutParkingSpace = new TreeSet<Employee>();
}
