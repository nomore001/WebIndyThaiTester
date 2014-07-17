package fillRegisterProfile;

import java.util.Calendar;

public class RunFillRegisterProfile {

	public static void main(String[] args) {
		RegisterBean register = new RegisterBean("Qtp001", "1/7/2557", 5, "10/7/2557", 5, "20/7/2557", 2500);
		
		// 2 – ผู้ใช้กรอกชื่อ-นามสกุล
		// 3 – ระบบรับค่าชื่อ-นามสกุลจากผู้ใช้กรอก
		String inputName = "อัญชลี มณีนก";
		// 4 – ระบบค้นหาข้อมูลผู้ใช้จากฐานข้อมูล
		// 5 – ระบบคืนค่าข้อมูลผู้ใช้
		TraineeBean trainee = register.searchTraineeByName(inputName);
		// 6 – ระบบแสดงข้อมูลผู้ใช้
		if(trainee!=null){
			System.out.println(trainee.toString() + trainee.getAddress().toString());
		}
		// 7 – ผู้ใช้กรอกข้อมูลการลงทะเบียน
		// 9 – ระบบรับค่าข้อมูลการลงทะเบียนจากผู้ใช้กรอก
		String title = "นางสาว";
		String name = "อัญชลี มณีนก";
		String education = "ต่ำกว่าปริญญาตรี";
		String[] occupation = { "Tester" };
		String telNo = "0836234763";
		String email = "unchalee.fern@gmail.com";

		String workplace = "";
		String addressNo = "123/1";
		String street = "";
		String subDistrict = "หนองหาร";
		String district = "สันทราย";
		String province = "เชียงใหม่";
		String zipcode = "50290";
		
		String username = "user";
		String password = "10012536";
		String confirmPassword = "10012536";
		
		// 10 – ระบบตรวจสอบข้อมูลการเข้าสู่ระบบจากฐานข้อมูล
		// 11 – ระบบคืนค่าการตรวจสอบชื่อผู้ใช้
		boolean verifyLoginOfTrainee = register.verifyLogin(username, password);
		// 12 – ระบบตรวจสอบสถานะการคืนค่า
		if(!verifyLoginOfTrainee){
			
			Calendar calendar = Calendar.getInstance();
			
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH);
			int date = calendar.get(Calendar.DATE);
			String registerDate = date + "/" + (month + 1) + "/" + year;
			
			// 13 – ระบบค้นหาจำนวนผู้เข้าอบรมของการลงทะเบียนอบรมหลักสูตรนั้น ๆ  จากฐานข้อมูล
			// 14 – ระบบคืนค่าการค้นหาจากฐานข้อมูล
			int sumOfTrainee = register.sumOfTrainee();
			// 15 – ระบบสร้างทศนิยมค่าอบรมที่ผู้เข้าอบรมต้องชำระโดยบวกจำนวนทศนิยมไปอีก 
			String traineePayment = register.createFrangmentPayment(sumOfTrainee);
			String traineeStatus = "ยังไม่ได้ชำระเงิน";
			 
			// 16 – ระบบบันทึกข้อมูลลงบนฐานข้อมูล
			// 17 – ระบบคืนค่าสถานะการตรวจสอบจากฐานข้อมูล
			AddressBean address = new AddressBean(workplace, addressNo, street, subDistrict, district, province, zipcode);
			LoginBean login = new LoginBean(username, password);
			trainee = new TraineeBean(title, name, education, occupation, telNo, email, traineeStatus, registerDate, traineePayment);
			trainee.addAddress(address);
			trainee.addLogin(login);
			TraineeBean traineeRegisterAdd = register.addTrainee(trainee);
			
			// 18 – ระบบตรวจสอบสถานะการคืนค่า
			if(traineeRegisterAdd!=null){
				// 19 – ระบบแสดงข้อมูลการเข้าสู่ระบบให้แก่ผู้ใช้ทราบโดยระบบจะแสดงชื่อผู้ใช้เป็นข้อความ “ลงทะเบียนเรียบร้อยแล้วกรุณาตรวจสอบข้อมูลของท่าน 
				//ชื่อผู้ใช้ของคุณคือ.... และ รหัสผ่านของคุณคือ...”
				System.out.println("ลงทะเบียนเรียบร้อยแล้วกรุณาตรวจสอบข้อมูลของท่าน ชื่อผู้ใช้ของคุณคือ "
						+ traineeRegisterAdd.getLogin().getUsername()
						+ " และ รหัสผ่านของคุณคือ "
						+ traineeRegisterAdd.getLogin().getPassword());
			}else{
				System.out.println("เกิดข้อผิดพลาด : ไม่สามารถลงทะเบียนได้");
			}
		}else{
			System.out.println("ขออภัย   ชื่อผู้ใช้ที่ท่านกำหนดไม่สามารถใช้งานได้   เนื่องจากมีผู้ใช้งานแล้ว");
		}
	}
}
