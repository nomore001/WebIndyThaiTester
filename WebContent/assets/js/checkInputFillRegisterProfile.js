function validate(formCheck) {

	if ((formCheck.radiotitle[0].checked == 0)
			&& (formCheck.radiotitle[1].checked == 0)
			&& (formCheck.radiotitle[2].checked == 0)) {
		alert("ข้อมูลผิดพลาด : กรุณาเลือกคำนำหน้าชื่อ");
		formCheck.radiotitle[0].focus();
		return false;
	}

	if (formCheck.textname.value == "") {
		alert("ข้อมูลผิดพลาด : กรุณาระบุชื่อ-นามสกุล");
		formCheck.txtname.focus();
		return false;
	}

	if (formCheck.textname.value != "") {
		var chkname = /^([ก-๙]{2,})\s{1,}?([ก-๙]{2,})+$/;
		if (!chkname.test(formCheck.textname.value)) {
			alert("ข้อมูลผิดพลาด : กรุณากรอกชื่อ-นามสกุลให้ถูกต้อง");
			formCheck.txtname.focus();
			return false;
		}
	}

	if (formCheck.selecteducation.value == 0) {
		alert("ข้อมูลผิดพลาด : กรุณาเลือกวุฒิการศึกษา");
		formCheck.selecteducation.focus();
		return false;
	}

	if ((formCheck.checkboxjob[0].checked == 0)
			&& (formCheck.checkboxjob[1].checked == 0)
			&& (formCheck.checkboxjob[2].checked == 0)
			&& (formCheck.checkboxjob[3].checked == 0)
			&& (formCheck.checkboxjob[4].checked == 0)) {
		alert("ข้อมูลผิดพลาด : กรุณาเลือกตำแหน่งงาน");
		formCheck.checkboxjob[0].focus();
		return false;
	}

	if ((formCheck.checkboxjob[4].checked == 1)
			&& (formCheck.textjobOther.value == "")) {
		alert("ข้อมูลผิดพลาด : กรุณากรอกงานอื่น ๆ ");
		formCheck.textjobOther.focus();
		return false;
	}

	if ((formCheck.checkboxjob[4].checked == 0)
			&& (formCheck.textjobOther.value != "")) {
		alert("ข้อมูลผิดพลาด : กรุณาเลือกงานอื่น ๆ ");
		formCheck.checkboxjob[4].focus();
		return false;
	}

	if (formCheck.textjobOther.value != "") {
		var chkjobOther = /^([ก-๙a-zA-Z]{2,})+$/;
		if (!chkjobOther.test(formCheck.textjobOther.value)) {
			alert("ข้อมูลผิดพลาด : กรุณากรอกงานอื่น ๆให้ถูกต้อง");
			formCheck.textjobOther.focus();
			return false;
		}
	}

	if (formCheck.texttelno.value == "") {
		alert("ข้อมูลผิดพลาด : กรุณากรอกเบอร์โทรศัพท์");
		formCheck.texttelno.focus();
		return false;
	}

	// if(formCheck.txttelno.value.length < 9){
	// alert("กรุณากรอกเบอร์โทรศัพท์ 9-10 หลัก ให้ถูกต้อง");
	// formCheck.txttelno.focus();
	// return false;
	// }

	if (formCheck.texttelno.value != "") {
		var chktelno = /^08[0-9][-\s]?[0-9]{7}$/;
		var chktelno2 = /^02[-\s]?[0-9]{7}$/;
		var chktelno3 = /^0[3-9]{2}[-\s]?[0-9]{6}$/;
		if (!chktelno.test(formCheck.texttelno.value)
				&& !chktelno2.test(formCheck.texttelno.value)
				&& !chktelno3.test(formCheck.texttelno.value)) {
			alert("ข้อมูลผิดพลาด : กรุณากรอกเบอร์โทรศัพท์ให้ถูกต้อง");
			formCheck.texttelno.focus();
			return false;
		}
	}

	if (formCheck.textemail.value == "") {
		alert("ข้อมูลผิดพลาด : กรุณากรอกอีเมล์");
		formCheck.textemail.focus();
		return false;
	}

	if (formCheck.textemail.value != "") {
		var chkemail = /^([\w-\.]+)@((?:[\w]+\.)+)([a-zA-Z]{2,4})$/;
		if (!chkemail.test(formCheck.textemail.value)) {
			alert("ข้อมูลผิดพลาด : กรุณากรอกอีเมล์ให้ถูกต้อง");
			formCheck.textemail.focus();
			return false;
		}
	}

	var str9 = '!ํ#$%^&ฺ*()+=<>?/\{}[:;],฿1234567890';
	var v9 = formCheck.textworkplace;
	var keyV1OK9 = 0;
	for (var i = 0; i < str9.length; i++) {
		if (v9.value.indexOf(str9.charAt(i)) != -1)
			keyV1OK9 = 1;
	}
	if (keyV1OK9 == 1 || v9.value.indexOf("\"") != -1
			|| v9.value.indexOf("'") != -1) {
		alert("ข้อมูลผิดพลาด : กรุณากรอกที่ทำงาน/ที่อยู โดยไม่มีอักขระพิเศษหรือตัวเลขให้ถูกต้อง");
		formCheck.textworkplace.focus();
		return (false);
	}

	if (formCheck.textworkplace.value != "") {
		if (formCheck.textworkplace.value.length < 3) {
			alert("ข้อมูลผิดพลาด : กรุณากรอกที่ทำงาน/ที่อยู่ ให้ถูกต้อง");
			formCheck.textworkplace.focus();
			return false;
		}
	}

	if (formCheck.textno.value == "") {
		alert("ข้อมูลผิดพลาด : กรุณากรอกเลขที่");
		formCheck.textno.focus();
		return false;
	}

	if (formCheck.textno.value != "") {
		// 1/1 ,1-1 ,123
		var chkno = /^(\d{0,5}([\/\-]?)\d{1,5})$/;
		// 123 หมู่ 4,12-15 หมู่ 4,12/3 หมู่ 4
		var chkno2 = /^(\d{0,5}([\/\-]?)\d{1,5}\s{1,}(หมู่)\s{1,2}\d{1,3})$/;
		// 12-15/7
		var chkno3 = /^(\d{0,5}([\-]?)\d{1,5}([\/]?)\d{1,5})$/;
		// 15-16/1 หมู่ 45
		var chkno4 = /^(\d{0,5}([\-]?)\d{1,5}([\/]?)\d{1,5}\s{1,}(หมู่)\s{1,2}\d{1,3})$/;
		// 123/15-123/16 หมู่ 4
		var chkno5 = /^(\d{0,5}([\/]?)\d{1,5}([\-])\d{1,5}([\/])\d{1,5}\s{1,}(หมู่)\s{1,2}\d{1,3})$/;
		// 123/15-123/16
		var chkno6 = /^(\d{0,5}([\/]?)\d{1,5}([\-])\d{1,5}([\/])\d{1,5})$/;

		if (!chkno.test(formCheck.textno.value)
				&& !chkno2.test(formCheck.textno.value)
				&& !chkno3.test(formCheck.textno.value)
				&& !chkno4.test(formCheck.textno.value)
				&& !chkno5.test(formCheck.textno.value)
				&& !chkno6.test(formCheck.textno.value)) {
			alert("ข้อมูลผิดพลาด : กรุณากรอกบ้านเลขที่ซึ่งสามารถกรอกตามแบบฟอร์มต่อไปนี้\n"
					+ " 1. (99)\n 2. (1/1)\n 3. (1-2)\n 4. (123 หมู่ 1)\n 5. (12-15/2)\n 6. (15-16/1 หมู่ 1)\n 7. (123/15-123/16)\n 8. (123/15-123/16 หมู่ 4)");
			formCheck.textno.focus();
			return false;
		}
	}

	// if(formCheck.txtno.value !=""){
	// var chkno=/^([0-9]{1,}([\/]?)[0-9]{1,})$/;
	// var chkno2=/^([0-9]{1,})$/;
	// if(!chkno.test(formCheck.txtno.value)&&!chkno2.test(formCheck.txtno.value)){
	// alert("ข้อมูลผิดพลาด :
	// กรุณากรอกเลขที่ซึ่งสามารถประกอบด้วยตัวเลขและเครื่องหมาย /เท่านั้น
	// ให้ถูกต้อง");
	// formCheck.txtno.focus();
	// return false;
	// }
	// }
	// var str11 = '!ํ#$%^&ฺ*()+=<>?\{}[:;],฿';
	// var v11 = formCheck.txtno;
	// var keyV1OK11 = 0;
	// for (var i=0;i<str11.length;i++){
	// if (v11.value.indexOf(str11.charAt(i))!= -1) keyV1OK11 = 1;
	// }
	// if(keyV1OK11==1|| v11.value.indexOf("\"")!= -1 ||
	// v11.value.indexOf("'")!= -1) {
	// alert("กรุณากรอกเลขที่ โดยไม่มีอักขระพิเศษให้ถูกต้อง");
	// formCheck.txtno.focus();
	// return(false);
	// }

	// var str12 = '!ํ#$%^&ฺ*()+=.<>?/\{}[:;],฿';
	// var v12 = formCheck.txtstreet;
	// var keyV1OK12 = 0;
	// for (var i=0;i<str12.length;i++){
	// if (v12.value.indexOf(str12.charAt(i))!= -1) keyV1OK12 = 1;
	// }
	// if(keyV1OK12==1|| v12.value.indexOf("\"")!= -1 ||
	// v12.value.indexOf("'")!= -1) {
	// alert("กรุณากรอกถนนโดยไม่มีอักขระพิเศษให้ถูกต้อง");
	// formCheck.txtstreet.focus();
	// return(false);
	// }
	//	
	if (formCheck.textstreet.value != "") {
		var chkemail = /^([ก-๙a-zA-Z0-9]{1,15}[-\s]?[ก-๙a-zA-Z0-9]{1,15})$/;
		if (!chkemail.test(formCheck.textstreet.value)) {
			alert("ข้อมูลผิดพลาด : กรุณากรอกถนนให้ถูกต้อง");
			formCheck.textstreet.focus();
			return false;
		}
	}

	if (formCheck.textsubdistrict.value == "") {
		alert("ข้อมูลผิดพลาด : กรุณากรอกตำบล/แขวง");
		formCheck.textsubdistrict.focus();
		return false;
	}

	if (formCheck.textsubdistrict.value != "") {
		var chksubdistrict = /^([ก-๙]{2,})+$/;
		if (!chksubdistrict.test(formCheck.textsubdistrict.value)) {
			alert("ข้อมูลผิดพลาด : กรุณากรอกตำบล/แขวงให้ถูกต้อง");
			formCheck.textsubdistrict.focus();
			return false;
		}
	}

	// var str4 = '!ํ#$%^&ฺ*()+=.<>?/\{}[:;],฿1234567890';
	// var v4 = formCheck.txtsubdistrict;
	// var keyV1OK4 = 0;
	// for (var i=0;i<str4.length;i++){
	// if (v4.value.indexOf(str4.charAt(i))!= -1) keyV1OK4 = 1;
	// }
	// if(keyV1OK4==1|| v4.value.indexOf("\"")!= -1 || v4.value.indexOf("'")!=
	// -1) {
	// alert("กรุณากรอกตำบล/แขวงโดยไม่มีอักขระพิเศษหรือตัวเลขให้ถูกต้อง");
	// formCheck.txtsubdistrict.focus();
	// return(false);
	// }

	if (formCheck.textdistrict.value == "") {
		alert("ข้อมูลผิดพลาด : กรุณากรอกอำเภอ/เขต");
		formCheck.textdistrict.focus();
		return false;
	}

	if (formCheck.textdistrict.value != "") {
		var chkdistrict = /^([ก-๙]{2,})+$/;
		if (!chkdistrict.test(formCheck.textdistrict.value)) {
			alert("ข้อมูลผิดพลาด : กรุณากรอกอำเภอ/เขต ให้ถูกต้อง");
			formCheck.textdistrict.focus();
			return false;
		}
	}
	// var str5 = '!ํ#$%^&ฺ*()+=-.<>?/\{}[:;],฿1234567890';
	// var v5 = formCheck.txtdistrict;
	// var keyV1OK5 = 0;
	// for (var i=0;i<str5.length;i++){
	// if (v5.value.indexOf(str5.charAt(i))!= -1) keyV1OK5 = 1;
	// }
	// if(keyV1OK5==1|| v5.value.indexOf("\"")!= -1 || v5.value.indexOf("'")!=
	// -1) {
	// alert("กรุณากรอกอำเภอ/เขตโดยไม่มีอักขระพิเศษหรือตัวเลขให้ถูกต้อง");
	// formCheck.txtdistrict.focus();
	// return(false);
	// }

	if (formCheck.textprovince.value == "") {
		alert("ข้อมูลผิดพลาด : กรุณากรอกจังหวัด");
		formCheck.textprovince.focus();
		return false;
	}

	if (formCheck.textprovince.value != "") {
		var chkprovince = /^([ก-๙]{3,}([\.]?))+$/;
		if (!chkprovince.test(formCheck.textprovince.value)) {
			alert("ข้อมูลผิดพลาด : กรุณากรอกจังหวัดให้ถูกต้อง");
			formCheck.textprovince.focus();
			return false;
		}
	}

	// var str6 = '!ํ#$%^&ฺ*()+=-.<>?/\{}[:;],฿1234567890';
	// var v6 = formCheck.txtprovince;
	// var keyV1OK6 = 0;
	// for (var i=0;i<str6.length;i++){
	// if (v6.value.indexOf(str6.charAt(i))!= -1) keyV1OK6 = 1;
	// }
	// if(keyV1OK6==1|| v6.value.indexOf("\"")!= -1 || v6.value.indexOf("'")!=
	// -1) {
	// alert("กรุณากรอกจังหวัดโดยไม่มีอักขระพิเศษหรือตัวเลขให้ถูกต้อง");
	// formCheck.txtprovince.focus();
	// return(false);
	// }

	if (formCheck.textzipcode.value == "") {
		alert("ข้อมูลผิดพลาด : กรุณากรอกรหัสไปรษณีย์");
		formCheck.textzipcode.focus();
		return false;
	}

	if (formCheck.textzipcode.value != "") {
		var format = /^[12345]\d{4}$/;
		if (!format.test(formCheck.textzipcode.value)) {
			alert("ข้อมูลผิดพลาด : กรุณากรอกรหัสไปรษณีย์ให้ถูกต้อง");
			formCheck.textzipcode.focus();
			return false;
		}
	}

	if (formCheck.textusername.value == "") {
		alert("ข้อมูลผิดพลาด : กรุณากรอกชื่อผู้ใช้");
		formCheck.textusername.focus();
		return false;
	}

	if (formCheck.textusername.value != "") {
		var format = /^[a-zA-Z0-9]{4,16}$/;
		if (!format.test(formCheck.textusername.value)) {
			alert("ข้อมูลผิดพลาด : กรุณากรอกชื่อผู้ใช้เป็นตัวอักษรภาษาอังกฤษหรือตัวเลข  ที่มีความยาวตั้งแต่  4-16 ตัวอักษรเท่านั้น");
			formCheck.textusername.focus();
			return false;
		}
	}

	if (formCheck.textpassword.value == "") {
		alert("ข้อมูลผิดพลาด : กรุณากรอกรหัสผ่าน");
		formCheck.textpassword.focus();
		return false;
	}

	if (formCheck.textpassword.value != "") {
		var format = /^[\w_-]{8,16}$/;
		if (!format.test(formCheck.textpassword.value)) {
			alert("ข้อมูลผิดพลาด : กรุณากรอกรหัสผ่านป็นอักษรภาษาอังกฤษหรือตัวเลข ที่มี ความยาวตั้งแต่  8-16  ตัวอักษร");
			formCheck.textpassword.focus();
			return false;
		}
	}

	if (formCheck.textconfirmpassword.value == "") {
		alert("ข้อมูลผิดพลาด : กรุณากรอกยืนยันรหัสผ่าน");
		formCheck.textconfirmpassword.focus();
		return false;
	}

	if (formCheck.textpassword.value != formCheck.textconfirmpassword.value) {
		alert("ข้อมูลผิดพลาด : ยืนยันรหัสผ่านไม่ถูกต้อง");
		formCheck.textconfirmpassword.focus();
		return false;
	}

}

function check_number(ch) {
	var len, digit;
	if (ch == " ") {
		return false;
		len = 0;
	} else {
		len = ch.length;
	}
	for (var i = 0; i < len; i++) {
		digit = ch.charAt(i);
		if (digit >= "0" && digit <= "9") {
			;
		} else {
			return false;
		}
	}
	return true;
}
function CheckNum() {
	if (event.keyCode < 48 || event.keyCode > 57) {
		event.returnValue = false;
	}
}
