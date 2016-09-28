package siit.java4.exceptionshomework;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ExceptionUnitTests {
	
	StudentRepository repo = new StudentRepository();
	
	@Test(expected=ValidationException.class)
	public void testAddStudentException() throws ValidationException{
		Student student1 = new Student("Roland", "Halekor", 1988, 'p', "1988020202021");
		student1=null;

		repo.addStudent(student1);
		
	}
	
	@Test(expected=ValidationException.class)
	public void testDeleteStudentByIDException() throws ValidationException{
		Student student1 = new Student("Mattew", "Smith", 1988, 'p', "1988020202021");
		repo.deleteStudentByID("1234");
	}
	
	@Test(expected=ValidationException.class)
	public void testRetrieveStudentsByAgeException() throws ValidationException{

		repo.retrieveStudentsByAge(-2);
	}

}