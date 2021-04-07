<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
	function validateForm() {
		const libraryID = document.forms["addForm"]["libraryID"].value;
		const libraryName = document.forms["addForm"]["libraryName"].value;
		const noOfBooks = parseInt(document.forms["addForm"]["noOfBooks"].value);
		
		if (libraryID == ""){
			alert("id can not be null")
			return false;
		}
		if (parseInt(libraryID) < 0){
			alert("id should be > 0")
			return false;
		}
		
		if (libraryName == ""){
			alert("Library name can not be null")
			return false;
		}
		if (noOfBooks < 0) {
			alert("noOfBooks should be > 0")
			return false;
		}
		return true;
			
		
		
	}
</script>
<style>
	body{
		background-image: url("https://images.unsplash.com/photo-1507842217343-583bb7270b66?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8bGlicmFyeXxlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80");
	-webkit-background-size: cover;
	}
	center{
	margin-top:10%;
	background-color: #7FF3A9;
	box-shadow: 7px 7px 5px grey;
	border-radius: 15px;
	margin-left: 35%;
	margin-right: 40%;
	padding: 1rem;
}

input{
	width: 80%;
	height: 30px;
	border: none;
  	border-bottom: 2px solid gray;
	
}

input[type="text"]:focus{
	border: 3px solid #555;;
}

HTML CSSResult Skip Results Iframe
body {
  background: #44c4e7 url("https://38.media.tumblr.com/d23deac40b06633b79520a8552f40b94/tumblr_nb1uhrRrge1st5lhmo1_1280.jpg") no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  font-family: "Roboto";
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
body::before {
  z-index: -1;
  content: '';
  position: fixed;
  top: 0;
  left: 0;
  background: #44c4e7;
  /* IE Fallback */
  background: rgba(68,196,231, 0.8);
  width: 100%;
  height: 100%;
}
.form {
  position: absolute;
  top: 50%;
  left: 50%;
  background: #fff;
  width: 285px;
  margin: -140px 0 0 -182px;
  padding: 40px;
  box-shadow: 0 0 3px rgba(0, 0, 0, 0.3);
}
.form h2 {
  margin: 0 0 20px;
  line-height: 1;
  color: #44c4e7;
  font-size: 18px;
  font-weight: 400;
}
.form input[type="text"] {
  outline: none;
  display: block;
  width: 100%;
  margin: 0 0 20px;
  padding: 10px 15px;
  border: 1px solid #ccc;
  color: #ccc;
  font-family: "Roboto";
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
  font-size: 14px;
  font-wieght: 400;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  -webkit-transition: 0.2s linear;
  -moz-transition: 0.2s linear;
  -ms-transition: 0.2s linear;
  -o-transition: 0.2s linear;
  transition: 0.2s linear;
}
.form input[type="text"]:focus {
  color: #333;
  border: 1px solid #44c4e7;
}
.form input[type="submit"] {
  cursor: pointer;
  background: #44c4e7;
  width: 100%;
  padding: 10px 15px;
  border: 0;
  color: #fff;
  font-family: "Roboto";
  font-size: 14px;
  font-weight: 400;

}
.form input[type="submit"]:hover {
  background: #369cb8;
}

Resources1× 0.5× 0.25×Rerun
</style>
</head>
<body>
	<div class="form animated flipInX">
  <h2>Add Library Info</h2>
  <form action="add" name="addForm" onsubmit="return validateForm()">
    <input placeholder="Library ID" type="text" name="libraryID"></input>
    <input placeholder="Library Name" type="text" name="libraryName"></input>
    <input placeholder="Number of Books" type="text" name="noOfBooks">
	<input type="submit" value="SUBMIT">
</form>
</div>
	
</body>
</html>