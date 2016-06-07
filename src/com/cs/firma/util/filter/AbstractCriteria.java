package com.cs.firma.util.filter;

public abstract class AbstractCriteria {
	
	String criteriaName;
	String[] criteriaValue;
	
	public String getCriteriaName() {
		return criteriaName;
	}
	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}
	public String[] getCriteriaValue() {
		return criteriaValue;
	}
	public void setCriteriaValue(String[] criteriaValue) {
		this.criteriaValue = criteriaValue;
	}
	
}
