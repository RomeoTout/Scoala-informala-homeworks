package siit.java4.homework9;
/**
 *a class created to acces the wage/hour information of each job position
 */
public enum JobDescription {

	SALES_MANAGER(40), SENIOR_SALES_OFFICER(20), SALES_OFFICER(10);
	
	private int hourlyWage;

	private JobDescription(int hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public int wageValue() {
		return hourlyWage;
	}
}
