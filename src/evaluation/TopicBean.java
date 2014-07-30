package evaluation;

import java.util.Vector;

public class TopicBean {
	private String topicName;
	
	private SuggestionBean suggestion;
	private Vector<ChoiceBean> choiceVector = new Vector<ChoiceBean>();
	
	public TopicBean(){
		
	}
	
	public TopicBean(String topicName){
		this.topicName = topicName;
	}

	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	public SuggestionBean getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(SuggestionBean suggestion) {
		this.suggestion = suggestion;
	}
	
	public Vector<ChoiceBean> getChoiceVector() {
		return choiceVector;
	}
	public void setChoiceVector(Vector<ChoiceBean> choiceVector) {
		this.choiceVector = choiceVector;
	}
	
}
