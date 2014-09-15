package com.itsci.evaluation;

import java.util.Vector;

public class EvaluationBean {
	private String evaluationName;
	
	private Vector<TopicBean> topicVector = new Vector<TopicBean>();
	
	public EvaluationBean() {
		
	}

	public EvaluationBean(String evaluationName) {
		this.evaluationName = evaluationName;
	}

	public String getEvaluationName() {
		return evaluationName;
	}
	public void setEvaluationName(String evaluationName) {
		this.evaluationName = evaluationName;
	}

	public Vector<TopicBean> getTopicVector() {
		return topicVector;
	}
	public void setTopicVector(Vector<TopicBean> topicVector) {
		this.topicVector = topicVector;
	}

}
