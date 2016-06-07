package com.cs.firma.util.filter;

import com.cs.firma.datamodel.Employee;

public class AgeCriteria extends AbstractCriteria implements ICriteria {

	int age;


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean matchCriterion(Employee e){
		boolean match;
		if (e.getEmployerAge()==this.age){
			match = true;
		}else{
			match = false;
		}	
		return match;
	}
	
}
