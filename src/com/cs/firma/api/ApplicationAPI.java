package com.cs.firma.api;

import java.io.BufferedReader;

import java.io.Console;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cs.firma.datamodel.Employee;
import com.cs.firma.util.filter.AgeCriteria;
import com.cs.firma.util.filter.AbstractCriteria;
import com.cs.firma.util.filter.EmployeeFilter;
import com.cs.firma.util.filter.IFilter;
import com.cs.firma.util.filter.SexCriteria;


public class ApplicationAPI {

	public static  ArrayList <String[]> testingTypes = new ArrayList<String[]>();
	public static  ArrayList <String[]> developingLanguages = new ArrayList<String[]>();
//	public static  ArrayList <Employee> Employees= new ArrayList<Employee>();

	public static void main(String[] args) {

		
		List<Employee> employeeList = loadEmployee();
		printEmployees(employeeList);
		filterEmployee(employeeList);
		System.out.println("End of execution!");
	}
	
	
	
	
	public static void filterEmployee(List<Employee> employeeList){
		try{
			EmployeeFilter filter = new EmployeeFilter();
			filter.readCriteriaFromKbd();
			List<Employee> l=filter.filterE(employeeList);
			printEmployees(l);
		} catch(RuntimeException re){
			System.out.println(re.getMessage());
		}
	     
	}
	

	
	public static List<Employee> loadEmployee(){
		String  employersFilePath = "C:/My Stuff/_developing/workspace/ExercitiuFirmaProgramare/data/employers.csv";
		String  devInfoPath = "C:/My Stuff/_developing/workspace/ExercitiuFirmaProgramare/data/developers.csv";
	     String  tstInfoPath = "C:/My Stuff/_developing/workspace/ExercitiuFirmaProgramare/data/testers.csv";
	     String  pmInfoPath = "C:/My Stuff/_developing/workspace/ExercitiuFirmaProgramare/data/project_managers.csv";
		
		
		DataImporter dataImporter = new DataImporter();
		List<Employee> employeeList = dataImporter.importEmployee(employersFilePath);
		dataImporter.updateDevInfo(employeeList, devInfoPath);
		dataImporter.updateTestInfo(employeeList, tstInfoPath);
		dataImporter.updatePMInfo(employeeList, pmInfoPath);
		//...
		
		return employeeList;
	}
	
	public static void printEmployees(List<Employee> employeeList){
		
		for (Employee e : employeeList){
			System.out.println("employee ID "+ e.getEmployerId());
			System.out.println("employee Name "+ e.getEmployerName());
			System.out.println("employee Surname "+ e.getEmployerSurname());
			System.out.println("employee Age "+ e.getEmployerAge());
			System.out.println("employee Sex "+ e.getEmployerSex());
			
			if (e.getDeveloperDevelopingLanguageId()!=null){
				System.out.print("Developing languages for employee "+e.getEmployerId()+" are: ");
			for (int k=0;k<e.getDeveloperDevelopingLanguageId().length;k++){
				System.out.print(" " + e.getDeveloperDevelopingLanguageId()[k]);
			}
			System.out.println();
			}
			else {
				System.out.println("No developing language for this employee!");
			}
			System.out.println("employee Developing Experience "+e.getDeveloperExperience());
			
			if (e.getTesterTestingTypeId()!=null){
				System.out.print("Testing methods for employee "+e.getEmployerId()+" are: ");
				for (int k=0;k<e.getTesterTestingTypeId().length;k++){
					System.out.print(" " + e.getTesterTestingTypeId()[k]);
				}
				System.out.println();
				}
			else {
				System.out.println("No testing methods for this employee!");
			}
				System.out.println("employee testing experience "+e.getTesterExperience());

				System.out.println("employee managing experience "+e.getProjectManagerExperience());
				
				System.out.println("------------------------------------------------------------ ");
				
				
		}
		
	}

}
