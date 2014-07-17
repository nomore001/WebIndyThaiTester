package fillRegisterProfile;

public class LoginBean {
	private String username;
	private String password;
	
	public LoginBean() {
		
	}

	public LoginBean(String username, String password) {
		this.username = username;
		this.password = password;
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
	
	public String toString(){
		String text = "ส่วนที่ 3 ข้อมูลการเข้าสู่ระบบ" + 
					"\n\tชื่อผู้ใช้ : " + getUsername() + 
					"\n\tรหัสผ่าน : " + getPassword();
		return text;
	}
}
