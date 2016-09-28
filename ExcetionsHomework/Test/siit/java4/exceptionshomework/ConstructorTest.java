package siit.java4.exceptionshomework;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConstructorTest {

	@Test(expected=ValidationException.class)
	public void testConstructorGenderException() throws ValidationException {
		
		Student test = new Student("Roland", "Halekor", 1988, 'o', "1988020202021");		
	}
	
	@Test(expected=ValidationException.class)
	public void testConstructorFirstNameException() throws ValidationException {
		
		Student test = new Student("", "Halekor", 1988, 'm', "1988020202021");		
	}
	
	@Test(expected=ValidationException.class)
	public void testConstructorLastNameException() throws ValidationException {
		
		Student test = new Student("Roland", "", 1988, 'm', "1988020202021");		
	}
	
	@Test(expected=ValidationException.class)
	public void testConstructorDateOfBirthException() throws ValidationException {
		
		Student test = new Student("Roland", "Halekor", 2015, 'm', "1988020202021");		
	}
}
