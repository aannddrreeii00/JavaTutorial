package com.cs.firma.util.filter;

import com.cs.firma.datamodel.Employee;

public class SexCriteria extends AbstractCriteria implements ICriteria{

	char sex;


	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	@Override
	public boolean matchCriterion(Employee e) {
		boolean match;
		if (e.getEmployerSex()==this.sex){
			match = true;
		}else{
			match = false;
		}	
		return match;
	}

}
