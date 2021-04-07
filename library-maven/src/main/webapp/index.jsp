<html>
<head>

<style>
body{
	background-image: url("https://images.unsplash.com/photo-1507842217343-583bb7270b66?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8bGlicmFyeXxlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80");
	-webkit-background-size: cover;
}
a {
	position:relative;
	text-decoration: none;
	color: gray;
 	transition:color .15s ease-in-out;
}

a:hover {
	background-size: 100% 100%;
	cursor: pointer;
}

a:after {
	display:block;
	content:"";
	position: absolute;
 	right:0;
 	left:0;
 	width:100%;
	height:3px;
 	opacity:0;
	transform:translateY(-150%);
 	transition:transform .15s ease-in-out, opacity .15s ease-in-out;
 	background-color: #0095ff;
}

 a.is-active,
 a:active,
 a:focus,
 a:hover {
 	color: #0095ff;
}

 a.is-active:after,
 a:active:after,
 a:focus:after,
 a:hover:after {
 	transform:translateY(0);
 	opacity:1;
 
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


</style>
</head>
<body>
	<center>
		<h3> LIBRARY INFORMATION CENTER </h3>
		
		<a href="add.jsp" >ADD INFO</a><br><br>
		
		<a href="getall.jsp">GET ALL</a><br><br>
		<a href="update.jsp">UPDATE</a><br><br>
		<a href="delete.jsp">DELETE</a><br><br>
		
		
	</center>
	
</body>
</html>
