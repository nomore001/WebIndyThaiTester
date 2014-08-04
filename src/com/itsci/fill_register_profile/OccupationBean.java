package com.itsci.fill_register_profile;

public class OccupationBean {
	private boolean selected;
	private String occName;
	
	public OccupationBean(){
		
	}
	
	public OccupationBean(boolean selected, String occName){
		this.selected = selected;
		this.occName = occName;
	}
	
	public boolean getSelected(){
		return this.selected;
	}
	
	public String getOccupationName(){
		return this.occName;
	}

	public void editOccupation(boolean selected) {
		this.selected = selected;
	}

	public void editOther(String other) {
		this.occName = other;
	}

	public String getOccName() {
		return occName;
	}

	public void setOccName(String occName) {
		this.occName = occName;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
