package com.cs.firma.util.filter;

import java.util.List;

import com.cs.firma.datamodel.Employee;

public interface FilterCriteria {
	

	
	public boolean matchCriterion(Employee e);
	
	public List<String> addFilterCriterion(String criterion);
	
	public List<String> removeFilterCriterion(String criterion);
	
	

	

}
