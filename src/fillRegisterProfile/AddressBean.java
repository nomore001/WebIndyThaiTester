package fillRegisterProfile;

public class AddressBean {
	private String workplace;
	private String addressNo;
	private String street;
	private String subDistrict;
	private String district;
	private String province;
	private String zipcode;
	
	public AddressBean() {
		
	}
	
	public AddressBean(String workplace, String addressNo, String street,
			String subDistrict, String district, String province, String zipcode) {
		super();
		this.workplace = workplace;
		this.addressNo = addressNo;
		this.street = street;
		this.subDistrict = subDistrict;
		this.district = district;
		this.province = province;
		this.zipcode = zipcode;
	}
	
	public void editAddress(String workplace, String addressNo,
			String street, String subDistrict, String district,
			String province, String zipcode) {
		this.workplace = workplace;
		this.addressNo = addressNo;
		this.street = street;
		this.subDistrict = subDistrict;
		this.district = district;
		this.province = province;
		this.zipcode = zipcode;
	}
	
	public String toString(){
		return "\nส่วนที่ 2 ข้อมูลที่ทำงานหรือที่อยู่ปัจจุบัน\n" + 
				"\tที่ทำงาน/ที่อยู่ปัจจุบัน : " + workplace + "\n" +
				"\tเลขที่ : " + addressNo + "\n" +
				"\tถนน : " + street + "\n" +
				"\tตำบล/แขวง : " + subDistrict + "\n" +
				"\tอำเภอ/เขต : " + district + "\n" +
				"\tจังหวัด : " + province + "\n" +
				"\tรหัสไปรษณีย์ : " + zipcode + "\n";
	}
}
