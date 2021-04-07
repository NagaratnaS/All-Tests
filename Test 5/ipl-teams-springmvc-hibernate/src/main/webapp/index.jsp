<html>
<body>


<form action = "teams.do">
<h4>Add Team</h4>
Team ID : <input type="number" name="iplTeamID">
TeamName:<input type = "text" name = "teamName">
captain:<input type = "text" name = "captain">
no_of_teams:<input type = "text" name ="no_of_teams">
<input type = "submit" value = "SUBMIT">
</form><br>


<form action = "update.do">
<h4>Update Team</h4>
Team ID : <input type="number" name="iplTeamID">
TeamName:<input type = "text" name = "teamName">
<input type = "submit" value = "SUBMIT">
</form><br><br>

<form action = "getall.do">
<h4>Get All</h4>
<input type = "submit" value = "SUBMIT">
</form>

<form action = "delete.do">
<h4>Delete By ID</h4>
Team ID : <input type="number" name="iplTeamID">
<input type = "submit" value = "SUBMIT">
</form><br><br>
</body>
</html>
