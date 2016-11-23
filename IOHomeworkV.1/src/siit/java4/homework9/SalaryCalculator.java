package siit.java4.homework9;

import java.util.ArrayList;

public class SalaryCalculator {
	int salary;
	int bonus;
	int totalSalary;
	int managerPrepaidSales = 0;
	int managerPostpaidSales = 0;
	int managerBonus = 0;
/**
 * @param employees= a List of employee objects
 * calculateSalary calculates the total salary for each employee from the list separately calculating the basic
 * salary and the bonus and adding them togheter
 */
	public void calculateSalary(ArrayList<Employee> employees) {

		for (int i = 0; i < employees.size(); i++) {
			managerBonus = managerBonus + employees.get(i).prepaidSales * 15 + employees.get(i).postpaidSales * 30;
		}
		/* TODO CODE REVIEW: This methd is a bit large and could be refactored.
		 * if(isSeniorSalesOfficer(employees.get(i)){
		 * 	 computeSeniorSalesOfficerSalary();
		 * } else if(isSalesOfficer(employees.get(i)){
		 *  // extracted method
		 * } else if(isDalesManager(employees.get(i)){
		 * // extracted method
		 * }
		 *  
		 */
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).jobPosition.equals("Senior Sales Officer")) {
				salary = employees.get(i).workedHours * 20 + employees.get(i).daysOff * 8 * 20;
				bonus = employees.get(i).prepaidSales * 25 + employees.get(i).postpaidSales * 50;
				totalSalary = salary + bonus;
				managerPrepaidSales = managerPrepaidSales + employees.get(i).prepaidSales;
				managerPostpaidSales = managerPostpaidSales + employees.get(i).postpaidSales;
				System.out.println(employees.get(i).name + "-" + totalSalary);
			} else if (employees.get(i).jobPosition.equals("Sales Officer")) {
				salary = employees.get(i).workedHours * 10 + employees.get(i).daysOff * 8 * 10;
				bonus = employees.get(i).prepaidSales * 10 + employees.get(i).postpaidSales * 25;
				totalSalary = salary + bonus;
				managerPrepaidSales = managerPrepaidSales + employees.get(i).prepaidSales;
				managerPostpaidSales = managerPostpaidSales + employees.get(i).postpaidSales;
				System.out.println(employees.get(i).name + "-" + totalSalary);
			} else if (employees.get(i).jobPosition.equals("Sales Manager")) {
				salary = employees.get(i).workedHours * 40 + employees.get(i).daysOff * 8 * 40;
				totalSalary = salary + managerBonus;
				System.out.println(employees.get(i).name + "-" + totalSalary);
			}

		}
	}

}
