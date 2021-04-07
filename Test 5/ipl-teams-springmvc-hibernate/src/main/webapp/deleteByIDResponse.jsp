<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete By ID</title>
<!-- <script>
	function validateForm() {
		const iplTeamID = document.forms["deleteForm"]["iplTeamID"].value;
		
		if (iplTeamID == ""){
			alert("id can not be null")
			return false;
		}
		
		if (parseInt(iplTeamID < 0)){
			alert("id should be > 0")
			return false;
		}
		
		return true; 
			}
</script>
-->
			
		
		

</head>
<body>
	<h2><% out.println(request.getAttribute("message")); %> </h2>
	<a href="http://localhost:8080/ipl-teams-springmvc-hibernate/" >HOME</a>
</body>
</html>