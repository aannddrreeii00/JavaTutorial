package com.cs.firma.util.filter;

import java.util.List;

import com.cs.firma.datamodel.Employee;

public class AgeFilterCriteria implements FilterCriteria {

	int age;
	@Override
	public boolean matchCriterion(Employee e) {
		
		return (e.getEmployerAge()==age);
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
}
