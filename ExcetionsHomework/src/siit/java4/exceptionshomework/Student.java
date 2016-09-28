package siit.java4.exceptionshomework;
/**
 * @param first name of student
 * @param last name of student
 * @param year of birth
 * @param male or female
 * @param social security number
 */
public class Student {
	String firstName;
	String lastName;
	int dateOfBirth;
	char gender;
	String cnp;
	int currentYear = 2016;
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 * @param gender
	 * @param cNP
	 * @throws ValidationException if: 
	 *          -year of birth is smaller than 1900 or greater than current year-18
	 *          -firstaname or lastname is empty
	 *          -if gender is other than the symbols for male or female
	 */
	public Student(String firstName, String lastName, int dateOfBirth, char gender, String cNP)
			throws ValidationException {
		super();

		if (dateOfBirth < 1900 || dateOfBirth > currentYear - 18) {
			throw new ValidationException("Date of birth must be between 1900 and current year - 18.");
		}
		if (firstName == "" || lastName == "") {
			throw new ValidationException("The first name and last name should not be empty.");
		}
		if (gender != 'M' && gender != 'F' && gender != 'm' && gender != 'f') {
			throw new ValidationException("Gender should be male or female (M,m,f or F)");
		}
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		cnp = cNP;
	}
}
