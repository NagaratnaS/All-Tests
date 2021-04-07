<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*" %>
<%@ page import="com.wolken.wolkenapp.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get All</title>
</head>
<body>
	<table style="width:100%">
		<tr> 
			<th>Team id</th>
			<th> Team Name </th>
			<th> captain </th>
			<th> Number of Players </th>
		</tr>
			<% ArrayList<IplTeamsDTO> dtos = (ArrayList<IplTeamsDTO>)request.getAttribute("dtos"); %>
			<% for(IplTeamsDTO dto: dtos) {%>
				<tr>
					<td><%out.println(dto.getIplTeamID());%> </td>
					<td><%out.println(dto.getTeamName());%></td>
					<td><%out.println(dto.getCaptain()); %></td>
					<td><%out.println(dto.getNo_of_teams()); %></td>
				</tr>
			<%} %>
	</table>
</body>
</html>