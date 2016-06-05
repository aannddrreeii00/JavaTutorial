package com.cs.firma.datamodel;

public class EmployeeQualification implements Tester, Developer, ProjectManager {
	Integer testerTestingTypeId[];
	int testerExperience; 
	Integer developerDevelopingLanguageId[];
	int developerExperience; 
	int projectManagerExperience;
	
	@Override
	public void setProjectManagerExperience(int projectManagerExperience) {
		this.projectManagerExperience=projectManagerExperience; 
		
	}
	@Override
	public int getProjectManagerExperience() {
		
		return this.projectManagerExperience;
	}
	@Override
	public void setDeveloperDevelopingLanguage(Integer[] developerDevelopingLanguageId) {
		
		this.developerDevelopingLanguageId = developerDevelopingLanguageId;
		
	}
	@Override
	public Integer[] getDeveloperDevelopingLanguageId() {
		
		return this.developerDevelopingLanguageId;
	}
	@Override
	public void setDeveloperExperience(int developerExperience) {
		
		this.developerExperience = developerExperience;
		
	}
	@Override
	public int getDeveloperExperience() {
		
		return this.developerExperience;
	}
	@Override
	public void setTesterTestingTypeId(Integer[] testerTestingTypeId) {
		
		this.testerTestingTypeId= testerTestingTypeId;
		
	}
	@Override
	public Integer[] getTesterTestingTypeId() {
		
		return this.testerTestingTypeId;
	}
	@Override
	public void setTesterExperience(int testerExperience) {
		
		this.testerExperience= testerExperience;
		
	}
	@Override
	public int getTesterExperience() {
	
		return this.testerExperience;
	}	

}
