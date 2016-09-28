package siit.java4.exceptionshomework;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Romeo Tout
 * @version 1.0
 */
public class Main {
	
	private static Logger LOGGER = Logger.getLogger("ro.sci.logging.Logging");
	
	public static void main(String[] args) {
		LOGGER.fine("In main");
		
		LOGGER.info("start main");
		
		Student student1 = null;
		Student student2 = null;
		Student student3 = null;
		try {
			LOGGER.fine("before creating objects");
			student1 = new Student("Roland", "Halekor", 1988, 'M', "1988020202021");
			student2 = new Student("Romeo", "Tout", 1988, 'M', "1988020203639");
			student3 = new Student("Freddy", "Krueger", 1969, 'M', "1969020202021");
			LOGGER.fine("after creating objects");
		} catch (ValidationException e1) {
			LOGGER.log(Level.SEVERE, "Error during run", e1);
			e1.printStackTrace();
		}

		StudentRepository repo = new StudentRepository();
		LOGGER.fine("Created students");
		repo.addStudent(student1);
		repo.addStudent(student2);
		repo.addStudent(student3);
		repo.deleteStudentByID("1988020203639");
		LOGGER.fine("Added students");

		try {
			System.out.println(repo.retrieveStudentsByAge(28).toString());
		} catch (ValidationException e) {
			System.out.println("Age should be a number.");
		}
		System.out.println(repo.getStudentList());
		LOGGER.info("end main");
	}
	

}
