package com.itsci.evaluation;

public class ChoiceBean {
	private String choiceQuestion;
	private int selectedValue;
	
	public ChoiceBean() {
		
	}

	public ChoiceBean(String choiceQuestion, int selectedValue) {
		this.choiceQuestion = choiceQuestion;
		this.selectedValue = selectedValue;
	}

	public String getChoiceQuestion() {
		return choiceQuestion;
	}

	public void setChoiceQuestion(String choiceQuestion) {
		this.choiceQuestion = choiceQuestion;
	}

	public int getSelectedValue() {
		return selectedValue;
	}

	public void setSelectedValue(int selectedValue) {
		this.selectedValue = selectedValue;
	}
	
}
