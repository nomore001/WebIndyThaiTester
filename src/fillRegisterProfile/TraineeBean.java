package fillRegisterProfile;

import java.util.Vector;

import evaluation.EvaluationBean;

public class TraineeBean {
	
	private String title;
	private String name;
	private String education;
	private String telNo;
	private String other;
	private String email;
	private String traineeStatus;
	private String registerDate;
	private String traineePayment;
	
	private LoginBean login;
	private AddressBean address;
	private EvaluationBean evaluation;
	private Vector<OccupationBean> occVector = new Vector<OccupationBean>();
	
	public TraineeBean(){
		
	}
	
	public TraineeBean(String title, String name, String education,  String telNo,  String email, 
			String traineeStatus, String registerDate, String traineePayment){
		this.title = title;
		this.name = name;
		this.education = education;
		this.telNo = telNo;
		this.email = email;
		this.traineeStatus = traineeStatus;
		this.registerDate = registerDate;
		this.traineePayment = traineePayment;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTraineeStatus() {
		return traineeStatus;
	}
	public void setTraineeStatus(String traineeStatus) {
		this.traineeStatus = traineeStatus;
	}
	
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	
	public String getTraineePayment() {
		return traineePayment;
	}
	public void setTraineePayment(String traineePayment) {
		this.traineePayment = traineePayment;
	}

	public LoginBean getLogin() {
		return login;
	}

	public AddressBean getAddress() {
		return address;
	}
	
	public EvaluationBean getEvaluation() {
		return evaluation;
	}
	
	public void setEvaluation(EvaluationBean evaluation){
		this.evaluation = evaluation;
	}

	public Vector<OccupationBean> getOccVector() {
		return occVector;
	}

	public void setOccVector(Vector<OccupationBean> occVector) {
		this.occVector = occVector;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public void setAddress(AddressBean address) {
		this.address = address;
	}
	
}
