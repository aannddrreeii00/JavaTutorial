package com.cs.firma.util.filter;

public interface CriteriaI {
	
	
	public void setCriteriaName (String criteriaName);
	public String getCriteriaName();
	
	public void setCriteriaValue(String[] criteriaValue);
	public String[] getCriteriaValue ();
}
