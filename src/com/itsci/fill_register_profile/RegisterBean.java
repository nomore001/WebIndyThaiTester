package com.itsci.fill_register_profile;

import java.util.Vector;

public class RegisterBean {
	private String registerNo;
	private String courseRegisterStartDate;
	private int courseRegisterDuration;
	private String paymentStartDate;
	private int paymentDuration;
	private String trainingStartDate;
	private int courseDuration;
	private int courseRegisterCosts;
	private Vector<TraineeBean> traineeVector = new Vector<TraineeBean>();

	public RegisterBean() {
		
	}

	public RegisterBean(String registerNo, String courseRegisterStartDate,
			int courseRegisterDuration, String paymentStartDate,
			int paymentDuration, String trainingStartDate, int courseDuration,
			int courseRegisterCosts) {
		this.registerNo = registerNo;
		this.courseRegisterStartDate = courseRegisterStartDate;
		this.courseRegisterDuration = courseRegisterDuration;
		this.paymentStartDate = paymentStartDate;
		this.paymentDuration = paymentDuration;
		this.trainingStartDate = trainingStartDate;
		this.courseDuration = courseDuration;
		this.courseRegisterCosts = courseRegisterCosts;
	}

	public String getCourseRegisterStartDate() {
		return courseRegisterStartDate;
	}

	public void setCourseRegisterStartDate(String courseRegisterStartDate) {
		this.courseRegisterStartDate = courseRegisterStartDate;
	}

	public int getCourseRegisterDuration() {
		return courseRegisterDuration;
	}

	public void setCourseRegisterDuration(int courseRegisterDuration) {
		this.courseRegisterDuration = courseRegisterDuration;
	}

	public String getPaymentStartDate() {
		return paymentStartDate;
	}

	public void setPaymentStartDate(String paymentStartDate) {
		this.paymentStartDate = paymentStartDate;
	}

	public int getPaymentDuration() {
		return paymentDuration;
	}

	public void setPaymentDuration(int paymentDuration) {
		this.paymentDuration = paymentDuration;
	}

	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}

	public void setTrainingStartDate(String trainingStartDate) {
		this.trainingStartDate = trainingStartDate;
	}

	public void setCourseRegisterCosts(int courseRegisterCosts) {
		this.courseRegisterCosts = courseRegisterCosts;
	}

	public void setTraineeVector(Vector<TraineeBean> traineeVector) {
		this.traineeVector = traineeVector;
	}

	public String getRegisterNo() {
		return registerNo;
	}
	
	public String getTrainingStartDate() {
		return trainingStartDate;
	}
	
	public int getCourseRegisterCosts() {
		return courseRegisterCosts;
	}

	public Vector<TraineeBean> getTraineeVector() {
		return traineeVector;
	}

	public TraineeBean addTrainee(TraineeBean trainee){
		traineeVector.addElement(trainee);
		return trainee;
	}
	
	public TraineeBean searchTraineeByName(String name) {
		int i=0;
		while (i<traineeVector.size()) {
			if(name.equals(traineeVector.elementAt(i).getName())){
				return traineeVector.elementAt(i);
			}
			i++;
		}
		return null;
	}

	public TraineeBean searchTraineeByUsername(String username) {
		int i=0;
		while (i<traineeVector.size()) {
			if(username.equals(traineeVector.elementAt(i).getLogin().getUsername())){
				return traineeVector.elementAt(i);
			}
			i++;
		}
		return null;
	}

	public int sumOfTrainee() {
		return traineeVector.size();
	}
	
	public String createFrangmentPayment(int sumOfTrainee) {
		String traineePayment = "";
		sumOfTrainee = sumOfTrainee+1;
		if(sumOfTrainee<100){
			traineePayment = courseRegisterCosts + "." + (sumOfTrainee);
		}else{
			int modCountTrainee = sumOfTrainee%100;
			int divideCountTrainee = sumOfTrainee/100;
			traineePayment = (courseRegisterCosts+divideCountTrainee)+"."+modCountTrainee;
		}
		return traineePayment;
	}
	/*
	public double[] calculateTotalAllEvaluation(int countTrainee) {
		double[] totalAllEvaluation = new double[traineeVector.elementAt(0).getEvaluation().calculateAllTopic().length] ;
		for(int i=0 ; i<countTrainee ; i++){
			double[] topicChoice = traineeVector.elementAt(i).getEvaluation().calculateAllTopic();
			for(int j=0 ; j<topicChoice.length ; j++){
				totalAllEvaluation[j] += topicChoice[j];
			}
		}
		for(int k=0 ; k<totalAllEvaluation.length ; k++){
			totalAllEvaluation[k] = totalAllEvaluation[k]/countTrainee;
		}
		return totalAllEvaluation;
	}
	
	public String totalSuggestion(int sumOfTrainee) {
		String totalSuggestion = "";
		int sizeTopic = traineeVector.elementAt(0).getEvaluation().getTopicVector().size()-1;
		for(int i=0 ; i<sumOfTrainee ; i++){
			totalSuggestion += traineeVector.elementAt(i).getEvaluation().getTopicVector().elementAt(sizeTopic).getSuggestion().getAnswerSuggestion() + ", ";
		}
		return totalSuggestion;
	}*/
	
	public double[] calculateGraph(double[] totalTopic){
		double[] totalGraph = new double[totalTopic.length];
		double sumTopic = 0.0;
		for(int i=0 ; i<totalTopic.length ; i++){
			sumTopic += totalTopic[i];
		}
		for(int j=0 ; j<totalTopic.length ; j++){
			totalGraph[j] = (totalTopic[j]*100)/sumTopic;
		}
		return totalGraph;
	}
	
	public Vector<TraineeBean> listTrainee() {
		return traineeVector;
	}

	public boolean removeInvalidTrainee(String name) {
		for(int i=0 ; i<traineeVector.size() ; i++){
			if(name.equals(traineeVector.elementAt(i).getName())){
				traineeVector.removeElementAt(i);
				return true;
			}
		}
		return false;
	}

	public boolean verifyLogin(String username, String password){
		for(int i = 0;i<traineeVector.size();i++){			
			if(this.traineeVector.elementAt(i).getLogin().getUsername().equals(username)&&
					this.traineeVector.elementAt(i).getLogin().getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}
	
}
