<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	
</style>
</head>
<body>
	<center>
		<h3>Add Library Info</h3>
		<form action="getAll">
			Press here to Get All Library Details:<br><br><input type="submit" value="SUBMIT" />
		</form>
	</center>
	
</body>
</html>