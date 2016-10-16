package siit.java4.homework9;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;

import org.junit.Test;

public class SalesTeamReaderTest {

	@Test
	public void managerCounterTest() throws IOException {
	//Given
		File testSalesFile = new File("sales-team.txt");
		SalesTeamReader testReader = new SalesTeamReader(new FileReader(testSalesFile));
	//When
		testReader.readSalesTeam();
		int result = testReader.managerCounter;
		int expected = 1;
	//Then
		assertEquals(expected, result);
		
	}
	@Test
	public void employeeListSizeTest() throws IOException {
	//Given
		File testSalesFile = new File("sales-team.txt");
		SalesTeamReader testReader = new SalesTeamReader(new FileReader(testSalesFile));
		// When
		testReader.readSalesTeam();
		int result = testReader.employees.size();
		int expected = 4;
	//Then
		assertEquals(expected, result);
		
	}

}
