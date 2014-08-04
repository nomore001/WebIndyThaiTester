package com.itsci.evaluation;

public class SuggestionBean {
	private String answerSuggestion;
	
	public SuggestionBean(){
		
	}
	
	public SuggestionBean(String answerSuggestion){
		this.answerSuggestion = answerSuggestion;
	}
	
	public String getAnswerSuggestion() {
		return answerSuggestion;
	}
	public void setAnswerSuggestion(String answerSuggestion) {
		this.answerSuggestion = answerSuggestion;
	}
	
}
