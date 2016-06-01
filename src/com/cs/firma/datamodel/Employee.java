package com.cs.firma.datamodel;
import java.util.Date;

public class Employee extends EmployeeQualification {
	int employerId;
    String employerName;
    String employerSurname;
    int employerAge;
	char employerSex;
	Date employerDateOfEmployment;


	public int getEmployerId() {
		return employerId;
	}


	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}


	public String getEmployerName() {
		return employerName;
	}


	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}


	public String getEmployerSurname() {
		return employerSurname;
	}


	public void setEmployerSurname(String employerSurname) {
		this.employerSurname = employerSurname;
	}


	public int getEmployerAge() {
		return employerAge;
	}


	public void setEmployerAge(int employerAge) {
		this.employerAge = employerAge;
	}


	public char getEmployerSex() {
		return employerSex;
	}


	public void setEmployerSex(char employerSex) {
		this.employerSex = employerSex;
	}


	public Date getEmployerDateOfEmployment() {
		return employerDateOfEmployment;
	}


	public void setEmployerDateOfEmployment(Date employerDateOfEmployment) {
		this.employerDateOfEmployment = employerDateOfEmployment;
	}
	
	
	
}
