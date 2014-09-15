package com.itsci.fill_register_profile;

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
	
	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public String getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(String addressNo) {
		this.addressNo = addressNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSubDistrict() {
		return subDistrict;
	}

	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
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
