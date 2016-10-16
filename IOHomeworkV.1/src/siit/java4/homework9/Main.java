package siit.java4.homework9;
/**
 * @author Romeo Tout
 * @version 1.1
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		File salesFile = new File("sales-team.txt");
		SalesTeamReader salesReader = new SalesTeamReader(new FileReader(salesFile));
		SalaryCalculator calculator = new SalaryCalculator();

		salesReader.readSalesTeam();
		calculator.calculateSalary(salesReader.employees);
		salesReader.close();
		JobDescription job1 = JobDescription.SALES_MANAGER;
		System.out.println("The hourly wage for a " + job1 + " is " + job1.wageValue());


	}

}
