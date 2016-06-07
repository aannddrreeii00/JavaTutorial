package com.cs.firma.util.filter;

public enum ECriteria {

	AGE("AGE"), SEX("SEX"), UNKNOWN("");

	private final String criterie;

	private ECriteria(final String criterie) {
		this.criterie = criterie;
	}

	public String toString() {
		return criterie;
	}
	
	public static ECriteria getFromString(String s){
		for (ECriteria e: ECriteria.values()){
			if(e.toString().contentEquals(s)){
				return e;
			}
		}
		
		return UNKNOWN;
	}
	
}
