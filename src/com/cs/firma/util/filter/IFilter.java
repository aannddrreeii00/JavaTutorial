package com.cs.firma.util.filter;

import java.util.List;

import com.cs.firma.datamodel.Employee;

public interface IFilter {
	

	
	
	
	public List<ICriteria> addCriterion(ICriteria criterion);
	
	public List<ICriteria> removeCriterion(ICriteria criterion);
	
	public List<Employee> filterE(List<Employee> employeeList);
	

}
