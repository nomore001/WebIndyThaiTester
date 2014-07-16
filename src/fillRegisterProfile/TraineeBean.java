package fillRegisterProfile;

//import evaluation.Evaluation;

public class TraineeBean {
	
	private String title;
	private String name;
	private String education;
	private String[] occupation;
	private String telNo;
	private String email;
	private String traineeStatus;
	private String registerDate;
	private String trainePayment;
	
	private LoginBean login;
	private AddressBean address;
//	private Evaluation evaluation;
	
	public TraineeBean(){
		
	}
	
	public TraineeBean(String title, String name, String education, String[] occupation, String telNo, 
			String email, String traineeStatus, String registerDate, String trainePayment){
		this.title = title;
		this.name = name;
		this.education = education;
		this.occupation = occupation;
		this.telNo = telNo;
		this.email = email;
		this.traineeStatus = traineeStatus;
		this.registerDate = registerDate;
		this.trainePayment = trainePayment;
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
	
	public String[] getOccupation() {
		return occupation;
	}
	public void setOccupation(String[] occupation) {
		this.occupation = occupation;
	}
	
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
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
	
	public String getTrainePayment() {
		return trainePayment;
	}
	public void setTrainePayment(String trainePayment) {
		this.trainePayment = trainePayment;
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
	
	public TraineeBean editTrainee(String title, String name, String education,
			String[] occupation, String telNo, String email, String workplace, 
			String addressNo, String street, String subDistrict, String district, 
			String province, String zipcode) {
		this.getAddress().editAddress(workplace, addressNo, street, subDistrict, district, province, zipcode);
		this.setTitle(title);
		this.setName(name);
		this.setEducation(education);
		this.setOccupation(occupation);
		this.setTelNo(telNo);
		this.setEmail(email);
		return this;
	}
	
	public void addAddress(AddressBean address){
		this.address = address;
	}
	
	public void addLogin(LoginBean login){
		this.login = login;
	}
	/*
	public void addEvaluation(Evaluation evaluation){
		this.evaluation = evaluation;
	}*/
	
	public String toString() {
		String text = "ส่วนที่ 1 ข้อมูลส่วนตัว\n";
		text = text + "\tชื่อ-นามสกุล : " + getTitle() + " " + getName()
				+ "\n" + "\tวุฒิการศึกษา : " + getEducation() + "\n"
				+ "\tตำแหน่งงาน : ";
		for (int i = 0; i < getOccupation().length; i++) {
			if (i == 0) {
				text = text + occupation[i];
			} else {
				text = text + ", " + occupation[i];
			}
		}
		text = text + "\n\tเบอร์โทรศัพท์ : " + getTelNo() + "\n"
				+ "\tอีเมล์ : " + getEmail() + "\n";
		return text;
	}
	
	public void editPaymentStatus(String traineeStatus) {
		this.traineeStatus = traineeStatus;
	}
}
