package siit.java4.collectionsHomework;

/**
 * @author Romeo Tout
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {

		ArrayList<Employee> employees = new ArrayList<Employee>();
		Employee worker1 = new Employee("John Johnnson", 6, true);
		Employee worker2 = new Employee("David Davidson", 19, false);
		Employee worker3 = new Employee("Paul Paulsen", 12, false);
		Employee worker4 = new Employee("Peter Peterson", 15, true);
		Employee worker5 = new Employee("Vasili Vasilievici", 17, false);
		employees.add(worker1);
		employees.add(worker2);
		employees.add(worker3);
		employees.add(worker4);
		employees.add(worker5);
		ArrayList<Employee> managers = new ArrayList<Employee>();
		Manager mng1 = new Manager("Rob Robson", 7, true);
		Manager mng2 = new Manager("Jaime Jameson", 11, false);
		Manager mng3 = new Manager("Brad Bradsen", 12, false);
		managers.add(mng1);
		managers.add(mng2);
		managers.add(mng3);

		TreeSet<Employee> employeesWithoutParkingSpace = CompanyManagementSystem.noParkingEmployees(employees);
		for (Employee employee : employeesWithoutParkingSpace) {
			System.out.println(employee.name);
		}
		TreeSet<Employee> managersWithoutParkingSpace = CompanyManagementSystem.noParkingEmployees(managers);
		for (Employee manager : managersWithoutParkingSpace) {
			System.out.println(manager.name);
		}
	}
}
