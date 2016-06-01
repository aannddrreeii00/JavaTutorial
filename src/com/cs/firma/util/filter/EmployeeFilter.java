package com.cs.firma.util.filter;

import java.util.ArrayList;
import java.util.List;

import com.cs.firma.datamodel.Employee;

public class EmployeeFilter implements FilterCriteria {

	public enum Criterii {
		AGE("AGE"), SEX("SEX");

		private final String criterie;

		private Criterii(final String criterie) {
			this.criterie = criterie;
		}

		public String toString() {
			return criterie;
		}
	}

	List<String> criteria;

	public List<Employee> filter(List<Employee> employeeList, List<FilterCriteria> criteria) {

		List<Employee> filteredEmployeeList = new ArrayList<>();
		for (Employee empl : employeeList) {
			boolean match = true;
			for (FilterCriteria cr : criteria) {
				match = cr.matchCriterion(empl);
				if (!match) {
					break;
				}
			}
			
			if(match){
				filteredEmployeeList.add(empl);
			}
		}
		return filteredEmployeeList;

	}


	@Override
	public List<String> addFilterCriterion(String criterion) {

		for (String cr : this.criteria) {
			if (cr.equalsIgnoreCase(criterion)) {
				System.out.println("This criterion already exists!");
			} else {
				this.criteria.add(criterion);
			}
		}
		return this.criteria;
	}

	@Override
	public List<String> removeFilterCriterion(String criterion) {
		boolean criterionExists = false;
		int index = -1;
		for (String cr : this.criteria) {
			if (cr.equalsIgnoreCase(criterion)) {
				criterionExists = true;
				index = this.criteria.indexOf(cr);
			} else {
			}
			if (criterionExists) {
				this.criteria.remove(index);
			} else {
				System.out.println("This criterion doesn't exists!");
			}

		}
		return this.criteria;
	}

	@Override
	public boolean matchCriterion(Employee e) {

		return false;
	}
}
