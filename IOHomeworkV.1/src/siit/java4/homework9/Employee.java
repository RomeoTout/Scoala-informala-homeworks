package siit.java4.homework9;

import java.io.Serializable;

public class Employee implements Serializable{
	String name;
	String jobPosition;
	int workedHours;
	int daysOff;
	int prepaidSales;
	int postpaidSales;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobPosition() {
		return jobPosition;
	}
	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}
	public double getWorkedHours() {
		return workedHours;
	}
	public void setWorkedHours(int workedHours) {
		this.workedHours = workedHours;
	}
	public int getDaysOff() {
		return daysOff;
	}
	public void setDaysOff(int daysOff) {
		this.daysOff = daysOff;
	}
	public int getPrepaidSales() {
		return prepaidSales;
	}
	public void setPrepaidSales(int prepaidSales) {
		this.prepaidSales = prepaidSales;
	}
	public int getPostpaidSales() {
		return postpaidSales;
	}
	public void setPostpaidSales(int postpaidSales) {
		this.postpaidSales = postpaidSales;
	}

	
	@Override
	public String toString() {
		return name + jobPosition + workedHours + daysOff + prepaidSales + postpaidSales;
	}

}
