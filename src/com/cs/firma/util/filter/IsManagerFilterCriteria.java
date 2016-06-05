package com.cs.firma.util.filter;

import java.util.List;

import com.cs.firma.datamodel.Employee;

public class IsManagerFilterCriteria implements FilterCriteria {

	@Override
	public boolean matchCriterion(Employee e) {

		return (e.getProjectManagerExperience()>0);
	}

	@Override
	public List<String> addFilterCriterion(String criterion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> removeFilterCriterion(String criterion) {
		// TODO Auto-generated method stub
		return null;
	}



}
