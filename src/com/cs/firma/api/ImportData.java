package com.cs.firma.api;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.cs.firma.datamodel.Employee;
import com.cs.firma.util.FileLoader;

import static com.cs.firma.util.FileLoader.loadFile;;
public class ImportData {

	
	public ImportData() {
	}
	public  void importTestingTypes (){
		FileLoader f= new FileLoader();
		String  filePath = "C:/Users/slesne/git/JavaTutorial1/data/testing_types.csv";
		
		try {
			ApplicationAPI.testingTypes= f.loadFile(filePath);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public  void importDevelopingLanguages (){
		FileLoader f= new FileLoader();
		String  filePath = "C:/Users/slesne/git/JavaTutorial1/data/developing_languages.csv";
		
		try {
			ApplicationAPI.developingLanguages= f.loadFile(filePath);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public  List<Employee> importEmployee (String filePath){

		List<Employee> employeeList = new ArrayList<>();
		
		try {
			ArrayList <String[]> lines= loadFile(filePath);

			for (String[] employee : lines){
				Employee e = new Employee();
				e.setEmployerId(Integer.parseInt(employee[0]));
				e.setEmployerName(employee[1]);
				e.setEmployerSurname(employee[2]);
				e.setEmployerAge(Integer.parseInt(employee[3]));
				e.setEmployerSex(employee[4].charAt(0));	
				DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				Date date;
				try {
					date = format.parse(employee[5]);
					e.setEmployerDateOfEmployment(date);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				employeeList.add(e);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return employeeList;
	}

	
	 public void updateDevInfo(List<Employee> employeeList, String devInfoPath){
	    
	     try {
			ArrayList <String[]> lines= loadFile(devInfoPath);
			
			for (String[] developer : lines){
				String id = developer[0];
				for (Employee empl : employeeList) {
					if(empl.getEmployerId()==Integer.parseInt(id)){
						String devIds = developer[1];
						empl.setDeveloperDevelopingLanguage(getIdsFromString(devIds));
						empl.setDeveloperExperience(Integer.parseInt(developer[2]));
	
					}
					
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
	 }
	 
	 public void updateTestInfo(List<Employee> employeeList, String tstInfoPath){


	     try {
	 		List <String[]> lines= loadFile(tstInfoPath);
			
			for (String[] tester: lines){
				for (Employee empl : employeeList) {
					if(empl.getEmployerId()==Integer.parseInt(tester[0])){
						empl.setTesterTestingTypeId(getIdsFromString(tester[1]));
						empl.setTesterExperience(Integer.parseInt(tester[2]));
						
						
					}
					
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
	 }

	 
	 
	 public void updatePMInfo(List<Employee> employeeList, String pmInfoPath){

	     try {
	    		List <String[]> lines= loadFile(pmInfoPath);
			for (String[] projmanag: lines){
	
				for (Employee empl : employeeList) {
					if(empl.getEmployerId()==Integer.parseInt(projmanag[0])){
						
						empl.setProjectManagerExperience(Integer.parseInt(projmanag[1]));
					}		
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 private Integer[] getIdsFromString(String idText){
		 List<Integer> intIdList = new ArrayList<>();
		 String[] chunk = idText.split(",");
		 
		 for(String s : chunk){
			 try{
				 intIdList.add(Integer.parseInt(s));
				 
			 } catch(NumberFormatException nfe){
				 //
			 }
		 }
		 
		 return intIdList.toArray(new Integer[intIdList.size()]);
		 
		 
	 }
	 
}
