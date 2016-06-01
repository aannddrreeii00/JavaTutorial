package com.cs.firma.util.filter;

import java.util.List;

import com.cs.firma.datamodel.Employee;

public class SexFilterCriteria implements FilterCriteria {

	char sex;
	@Override
	public boolean matchCriterion(Employee e) {
		// TODO Auto-generated method stub
		return e.getEmployerSex()== sex;
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

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}



}
