package siit.java4.collectionsHomework;

import java.util.TreeSet;


public class Main {

	public static void main(String[] args) {
		CompanyManagementSystem cms = new CompanyManagementSystem();
		
		cms.employees.add(cms.worker1);
		cms.employees.add(cms.worker2);
		cms.employees.add(cms.worker3);
		cms.employees.add(cms.worker4);
		cms.employees.add(cms.worker5);

		cms.managers.add(cms.mng1);
		cms.managers.add(cms.mng2);
		cms.managers.add(cms.mng3);
		cms.managers.add(cms.mng4);
		
		cms.engineers.add(cms.eng1);
		cms.engineers.add(cms.eng2);
		cms.engineers.add(cms.eng3);
		
		cms.employeesWithoutParkingSpace = cms.noParkingEmployees(cms.employees);
		for (Employee employee : cms.employeesWithoutParkingSpace) {
			System.out.println(employee.name);
		}

		cms.managersWithoutParkingSpace = cms.noParkingEmployees(cms.managers);
		for (Employee manager : cms.managersWithoutParkingSpace) {
			System.out.println(manager.name);
		}

		cms.engineersWithoutParkingSpace = cms.noParkingEmployees(cms.engineers);
		for (Employee engineer : cms.engineersWithoutParkingSpace) {
			System.out.println(engineer.name);
		}
	}

}
