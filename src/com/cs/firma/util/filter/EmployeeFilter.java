package com.cs.firma.util.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cs.firma.datamodel.Employee;

public class EmployeeFilter implements IFilter {


	private final List<ICriteria> filter;
	
	public EmployeeFilter(){
		filter = new ArrayList<>();
	}
	
	public void readCriteriaFromKbd (){
	
		try {
			System.out.println("Enter criteria here using ; as separator between criteria and , as separator between criteria name and values : ");
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    String line = bufferRead.readLine();
		    
		    String[] splittedLine =  line.split(";");
			for (String s: splittedLine){
				ECriteria criteria = ECriteria.getFromString(s.split(",")[0].toUpperCase());
				switch (criteria) {
				case AGE:
					AgeCriteria ageFillter = new AgeCriteria();
					ageFillter.setCriteriaName(s.split(",")[0]);
					ageFillter.setCriteriaValue(Arrays.copyOfRange(s.split(","), 1, s.split(",").length));
					ageFillter.setAge(Integer.parseInt(s.split(",")[1]));
					
					this.filter.add(ageFillter);
					//System.out.println(this.filter.get(0).getCriteriaName());
					break;
				case SEX:
					SexCriteria sexFillter = new SexCriteria();
					sexFillter.setCriteriaName(s.split(",")[0]);
                    sexFillter.setCriteriaValue(Arrays.copyOfRange(s.split(","), 1, s.split(",").length));
					sexFillter.setSex(s.split(",")[1].charAt(0));
					this.filter.add(sexFillter);
					break;
				case UNKNOWN:
					default:
						throw new RuntimeException("Unknown criteria!");
						
				}
				
			}
					
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

	public List<Employee> filterE (List<Employee> employeeList) {

		List<Employee> filteredEmployeeList = new ArrayList<>();
		for (Employee empl : employeeList) {
			boolean match = true;
			for (ICriteria cr : this.filter) {
				match = cr.matchCriterion(empl);
				if (!match) {
					break;
				}
			}
			
			if(match){
				filteredEmployeeList.add(empl);
			}
		}
		return filteredEmployeeList;

	}
	

	@Override
	public List<ICriteria> addCriterion(ICriteria criterion) {
		
		for (ICriteria c: this.filter){
			if (!c.getCriteriaName().equals(criterion.getCriteriaName())){
				this.filter.add( c);
			}
			else{
				System.out.println("Already exists!");
			}
		}
		return this.filter;
	}


	@Override
	public List<ICriteria> removeCriterion(ICriteria criterion) {
		for (ICriteria c: this.filter){
			if (c.getCriteriaName().equals(criterion.getCriteriaName())){
				this.filter.remove( c);
			}
			else {
				System.out.println("Does not exist!");
			}
		}
		return this.filter;
	}


	
}
