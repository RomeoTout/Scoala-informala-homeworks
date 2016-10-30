package siit.java4.homework9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
/**
 * readSalesTeam method reads each line of the list and creates an object of type employee out of it, by splitting 
 * the text where a "|" character is found,
 * it also prints out an error message in case the number of sales managers is not 1
 *
 */
public class SalesTeamReader extends BufferedReader {

	int managerCounter = 0;
	String error = "Incorrect number of managers! Remake sales team list!";

	public SalesTeamReader(Reader reader) {
		super(reader);
	}

	ArrayList<Employee> employees = new ArrayList<>();

	public List<Employee> readSalesTeam() throws IOException {
		String txtLine = readLine();

		while (txtLine != null) {

			String[] tokens = txtLine.split("\\|");
			Employee employee = new Employee();
			employee.setName(tokens[0]);
			employee.setJobPosition(tokens[1]);
			if (employee.jobPosition.equals("Sales Manager")) {
				managerCounter++;
			}
			employee.setWorkedHours(Integer.parseInt(tokens[2]));
			employee.setDaysOff(Integer.parseInt(tokens[3]));
			employee.setPrepaidSales(Integer.parseInt(tokens[4]));
			employee.setPostpaidSales(Integer.parseInt(tokens[5]));
			employees.add(employee);
			txtLine = readLine();
		}
		if (managerCounter != 1) {
			// TODO CODE REVIEW: Why not use an Exception?
			System.err.println(error);
		}
		return employees;
	}

}
