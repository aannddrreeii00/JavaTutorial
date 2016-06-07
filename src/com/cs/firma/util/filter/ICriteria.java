package com.cs.firma.util.filter;

import com.cs.firma.datamodel.Employee;

public interface ICriteria {
	
	
	public void setCriteriaName (String criteriaName);
	public String getCriteriaName();
	
	public void setCriteriaValue(String[] criteriaValue);
	public String[] getCriteriaValue ();
	
	public boolean matchCriterion(Employee e);

}
