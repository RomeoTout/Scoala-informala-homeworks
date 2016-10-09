package siit.java4.collectionsHomework;
import java.util.ArrayList;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

public class CompanyManagementSystemTest{

	@Test
	public void test() {
		//Given
		CompanyManagementSystem testCMS = new CompanyManagementSystem();
		ArrayList<Employee> testArray = new ArrayList<Employee>();
		Employee testWorker1 = new Employee("Johnny", 5, true, 102);
		Employee testWorker2 = new Employee("David", 11, false, 112);
		testArray.add(testWorker1);
		testArray.add(testWorker2);
		//When
		TreeSet<Employee> result = testCMS.noParkingEmployees(testArray);
		//Then
		TreeSet<Employee> expected = new TreeSet<Employee>();
		expected.add(testWorker2);
		Assert.assertEquals(expected, result);
	}

}