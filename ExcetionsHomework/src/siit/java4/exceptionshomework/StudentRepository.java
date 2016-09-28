package siit.java4.exceptionshomework;

import java.util.ArrayList;

public class StudentRepository {
	/**
	 * studentList -a list of all the students
	 * studentsByAge -a list of students by a specific age
	 */
	private ArrayList studentList = new ArrayList<>();
	private ArrayList studentsByAge = new ArrayList<>();

	public ArrayList getStudentList() {
		return studentList;
	}
	/**
	 * 
	 * @param student- object of class Student
	 * adds a student object to the studentList 
	 * @throws ValidationException if student object is null
	 */
	public void addStudent(Student student) {
		try{
		if(student==null){
			throw new ValidationException();
		}
		studentList.add(student);
		}
		catch(ValidationException e){
			System.out.println("Student does not exist");
		}
	}
	/**
	 * 
	 * @param cnp- social security number
	 * searches the list for a specific cnp and deletes the coresponding object
	 * @throws ValidationException if cnp is shorter or longer than 13 or if student object is null
	 */
	public void deleteStudentByID(String cnp) {
		try {
			if (cnp.length() < 13 || cnp.length() > 13) {
				throw new ValidationException();
			}
			 
			boolean doesStudentExist = false;
			for (int i = 0; i < studentList.size(); i++) {				
				Student student = (Student) studentList.get(i);
				if (student.cnp == cnp) {;
					studentList.remove(student);
					doesStudentExist = true;
				}
			}
		if (!doesStudentExist){
			throw new ValidationException();
		}
		} catch (ValidationException e) {
			System.out.println("The object does not exist.");
		} catch (Exception e) {
			System.out.println("CNP should be 13 characters long.");
		}
	}
	/**
	 * 
	 * @param age represents the age of a student (current year minus dateOfBirth)
	 * @returns a list with the objects that mach the age requirements
	 * @throws ValidationException if age is smaller than 0
	 */
	public ArrayList<Student> retrieveStudentsByAge(int age) throws ValidationException {
		if (age < 0) {
			throw new ValidationException("Age should be a positive integer.");
		}

		for (int i = 0; i < studentList.size(); i++) {
			int currentYear = 2016;
			Student student = (Student) studentList.get(i);
			// if(student.dateOfBirth == age){
			if (currentYear - student.dateOfBirth == age) {
				studentsByAge.add(student);
			}
		}		
		
		return studentsByAge;

	}

}
