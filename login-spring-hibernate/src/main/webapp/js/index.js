function validate() {
	
	const contactNumber = document.infoForm.contact_number.value;
	const username = document.infoForm.userName.value;
	const gender = document.infoForm.gender.value;
	const emailID = document.infoForm.emailID.value;
	const dateOfBirth = document.infoForm.dateOfBirth.value;
	const password = document.infoForm.password.value;
	const confirmPassword = document.infoForm.cpassword.value;
	
	console.log(password)
	console.log(confirmPassword)
	if (isNaN(contactNumber) == true){
		alert("Please provide only numeric characters")
		return false
	}
	if (contactNumber.length != 10){
		alert("Please enter 10 digit number..")
		return false
	}
	
	if (username == ""){
		alert("Username can not be null..")
		return false;
	}
	
	if (username.length < 3) {
		alert("Username should be greater than 3 characters")
		return false
	}
	if (username.length > 18) {
		alert("Username length can not exceed 18..")
		return false;
	}
	
	if (username.match(/\W|_/) != null) {
		alert("Only characters and numbers are allowed!!")
		return false;
	}
	
	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	if (emailID.match(reg) == null ) {
		alert("Enter valid email format")
		return false;
		
	}
	
	var lowercaseRegex = /[a-z]/g;
	var uppercaseRegex = /[A-Z]/g;
	var numericRegex = /[0-9]/g;
	var specialRegex = /[*@!#%&()^~{}]+/;
	
	if (password == "" ) {
		alert("Password can not be null")
		return false 
	}
	if (password.match(lowercaseRegex) == null) {
		alert("One lowercase letter should be there..")
		return false
	}
	if (password.match(uppercaseRegex) == null) {
		alert("One uppercase letter should be there..")
		return false
	}
	if(password.match(numericRegex) == null) {
		alert("One numeric character should be there..")
		return false
	}
	if (password.match(specialRegex) == null) {
		alert("At least one special character should be there..")
		return false
	}
	
	if (password.length < 8 ){
		alert("Password should be minimum 8 length")
		return false
	}
	if (password.length > 18){
		alert("Password can not exceed 18")
		return false
	}
	if (password != confirmPassword) {
		alert("Password should be same..")
		return false
	}
}