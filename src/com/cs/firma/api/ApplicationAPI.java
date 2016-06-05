package com.cs.firma.api;

import java.io.BufferedReader;

import java.io.Console;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cs.firma.datamodel.Employee;
import com.cs.firma.util.filter.AgeFilterCriteria;
import com.cs.firma.util.filter.Criteria;
import com.cs.firma.util.filter.EmployeeFilter;
import com.cs.firma.util.filter.FilterCriteria;
import com.cs.firma.util.filter.SexFilterCriteria;


public class ApplicationAPI {

	public static  ArrayList <String[]> testingTypes = new ArrayList<String[]>();
	public static  ArrayList <String[]> developingLanguages = new ArrayList<String[]>();
//	public static  ArrayList <Employee> Employees= new ArrayList<Employee>();

	public static void main(String[] args) {

		
		List<Employee> employeeList = loadEmployee();
		printEmployees(employeeList);
		List<Criteria> criteria = readCriteriaFromKbd();
		filterE(employeeList,criteria);
	}
	
	
	
	
	public static void filterE(List<Employee> employeeList, List<Criteria> criteria){
		EmployeeFilter emplFilter = new EmployeeFilter();
		List<FilterCriteria> filterCriteria = new ArrayList();
		for(Criteria cr: criteria){
			switch (cr.getCriteriaName().toUpperCase()) {
			case "AGE":
				System.out.println("Se doreste filtrarea dupa varsta");
				AgeFilterCriteria ageFillter = new AgeFilterCriteria();
				ageFillter.setAge(Integer.parseInt(cr.getCriteriaValue()[0]));
				filterCriteria.add(ageFillter);
				break;
			case "SEX":
				System.out.println("Se doreste filtrarea dupa sex");
				SexFilterCriteria sexFillter = new SexFilterCriteria();
				sexFillter.setSex(cr.getCriteriaValue()[0].charAt(0));
				filterCriteria.add(sexFillter);
				break;
			}

		}
		List<Employee> l=emplFilter.filter(employeeList, filterCriteria);
		printEmployees(l);
	}
	
	public static List<Criteria> readCriteriaFromKbd (){
		
		List<Criteria> criteria = new ArrayList<>();
		
		try {
			System.out.println("Enter criteria here using ; as separator between criteria and , as separator between criteria name and values : ");
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    String line = bufferRead.readLine();
		    
		    String[] splittedLine =  line.split(";");
			for (String s: splittedLine){
				Criteria cr = new Criteria();
				cr.setCriteriaName(s.split(",")[0]);
				System.out.println(cr.getCriteriaName());
				
				cr.setCriteriaValue(Arrays.copyOfRange(s.split(","), 1, s.split(",").length));
				for (String x: cr.getCriteriaValue()){
					System.out.println("valoare "+x);
				}
				criteria.add(cr);
			}
					
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return criteria;
	}
	
	public static List<Employee> loadEmployee(){
		String  employersFilePath = "C:/Users/slesne/git/JavaTutorial1/data/employers.csv";
		String  devInfoPath = "C:/Users/slesne/git/JavaTutorial1/data/developers.csv";
	     String  tstInfoPath = "C:/Users/slesne/git/JavaTutorial1/data/testers.csv";
	     String  pmInfoPath = "C:/Users/slesne/git/JavaTutorial1/data/project_managers.csv";
		
		
		ImportData dataImporter = new ImportData();
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
