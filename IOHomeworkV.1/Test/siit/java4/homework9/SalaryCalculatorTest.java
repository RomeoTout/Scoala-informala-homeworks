package siit.java4.homework9;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class SalaryCalculatorTest {

	@Test
	public void salaryCalculatorTotalSalaryTest() throws IOException {
		// Given
		File salesFile = new File("sales-team.txt");
		SalesTeamReader salesReader = new SalesTeamReader(new FileReader(salesFile));
		SalaryCalculator calculator = new SalaryCalculator();
		// When
		salesReader.readSalesTeam();
		calculator.calculateSalary(salesReader.employees);
		int actual = calculator.totalSalary;
		int expected = 3950;
		// Then
		assertEquals(expected, actual);

	}

	@Test
	public void salaryCalculatorManagerBonusTest() throws IOException {
		// Given
		File salesFile = new File("sales-team.txt");
		SalesTeamReader salesReader = new SalesTeamReader(new FileReader(salesFile));
		SalaryCalculator calculator = new SalaryCalculator();
		// When
		salesReader.readSalesTeam();
		calculator.calculateSalary(salesReader.employees);
		int actual = calculator.managerBonus;
		int expected = 750;
		// Then
		assertEquals(expected, actual);

	}

	@Test
	public void salaryCalculatorBonusTest() throws IOException {
		// Given
		File salesFile = new File("sales-team.txt");
		SalesTeamReader salesReader = new SalesTeamReader(new FileReader(salesFile));
		SalaryCalculator calculator = new SalaryCalculator();
		// When
		salesReader.readSalesTeam();
		calculator.calculateSalary(salesReader.employees);
		int actual = calculator.bonus;
		int expected = 175;
		// Then
		assertEquals(expected, actual);

	}

}
