package com.itsci.fill_register_profile;

public class LoginBean {
	private String username;
	private String password;
	private String status;
	
	public LoginBean() {
		
	}

	public LoginBean(String username, String password, String status) {
		this.username = username;
		this.password = password;
		this.status = status;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toString(){
		String text = "ส่วนที่ 3 ข้อมูลการเข้าสู่ระบบ" + 
					"\n\tชื่อผู้ใช้ : " + getUsername() + 
					"\n\tรหัสผ่าน : " + getPassword();
		return text;
	}
}
