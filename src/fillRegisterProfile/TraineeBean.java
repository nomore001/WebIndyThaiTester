package fillRegisterProfile;

import java.util.Vector;

//import evaluation.Evaluation;

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
	private AddressBean address = new AddressBean();
//	private Evaluation evaluation;
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
	
	/*public Evaluation getEvaluation() {
		return evaluation;
	}*/
	
	/*
	public void addEvaluation(Evaluation evaluation){
		this.evaluation = evaluation;
	}*/
	
	public String toString() {
		String text = "ส่วนที่ 1 ข้อมูลส่วนตัว\n";
		text = text + "\tชื่อ-นามสกุล : " + this.title + " " + this.name
				+ "\n" + "\tวุฒิการศึกษา : " + this.education + "\n"
				+ "\tตำแหน่งงาน : ";
		for (int i = 0 ; i < occVector.size()-1 ; i++) {
			if(occVector.get(i).getSelected()){
				if (i == 0) {
					text = text + occVector.get(i).getOccupationName();
				} else {
					text = text + ", " + occVector.get(i).getOccupationName();
				}
			}
		}
		if(occVector.get(4).getSelected()){
			text = text + ", " + this.other;
		}
		text = text + "\n\tเบอร์โทรศัพท์ : " + this.telNo + "\n"
				+ "\tอีเมล์ : " + this.email + "\n";
		return text;
	}
	
	public void editPaymentStatus(String traineeStatus) {
		this.traineeStatus = traineeStatus;
	}
	
	public TraineeBean editTrainee(String title, String name, String education,
			boolean[] occupation, String other, String telNo, String email, 
			String workplace, String addressNo, String street, String subDistrict, String district, 
			String province, String zipcode) {
		for(int i=0 ; i<4 ; i++){
			if(this.isSelected(occupation[i])){
				this.occVector.get(i).editOccupation(occupation[i]);
			}
		}
		if(this.isOccExist(occupation[4])){
			this.occVector.get(4).editOther(other);
		}
		this.getAddress().editAddress(workplace, addressNo, street, subDistrict, district, province, zipcode);
		this.title = title;
		this.name = name;
		this.education = education;
		this.telNo = telNo;
		this.email = email;
		return this;
	}
	
	public boolean isSelected(boolean check){
		if(check){
			return true;
		}
		return false;
	}
	
	public boolean isOccExist(boolean other){
		if(other){
			return true;
		}
		return false;
	}
	
	public void addOccupation(OccupationBean occ){
		this.occVector.addElement(occ);
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
