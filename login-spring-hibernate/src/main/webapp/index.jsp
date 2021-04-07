<html>
<head>
	<script src="js/index.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<style>
	body{
		background-image: url("https://aadcdn.msauth.net/shared/1.0/content/images/backgrounds/2_bc3d32a696895f78c19df6c717586a5d.svg");
	}
	.footer{
	margin-left: 23%;
	margin-right: 23%;
	text-align:justify;
	display: flex;
	justify-content:space-between;
	}
	/*form{
	background-color:Chartreuse;
	text-align:center;
	} */
	h2{
	text-align:center;
	
	}
	
	
	:focus {
            outline: none;
        }
        
        .col-3 {
            
            width: 80%;
            margin: 40px 3%;
            position: relative;
        }
        /* necessary to give position: relative to parent. */
        
        input[type="text"] {
            font: 15px/24px "Lato", Arial, sans-serif;
            color: #333;
            width: 100%;
            box-sizing: border-box;
            letter-spacing: 1px;
        }
        
        input[type="password"] {
        	font: 15px/24px "Lato", Arial, sans-serif;
            color: #333;
            width: 100%;
            box-sizing: border-box;
            letter-spacing: 1px;
        }
        
        
        
        
        
        .effect-17 {
            border: 0;
            padding: 4px 0;
            border-bottom: 1px solid #ccc;
            background-color: transparent;
        }
        
        .effect-17~.focus-border {
            position: absolute;
            bottom: 0;
            left: 50%;
            width: 0;
            height: 2px;
            background-color: #3399FF;
            transition: 0.4s;
        }
        
        .effect-17:focus~.focus-border,
        .has-content.effect-17~.focus-border {
            width: 100%;
            transition: 0.4s;
            left: 0;
        }
        
        .effect-17~label {
            position: absolute;
            left: 0;
            width: 100%;
            top: 9px;
            color: #aaa;
            transition: 0.3s;
            z-index: -1;
            letter-spacing: 0.5px;
        }
        
        .effect-17:focus~label,
        .has-content.effect-17~label {
            top: -16px;
            font-size: 12px;
            color: #3399FF;
            transition: 0.3s;
        }
        
        .download {
  display: inline-block;
  margin-right: 10px;
  margin-bottom: 10px;
  background: #339DFF;
  color: #fff;
  text-decoration: none;
  font-size: 13px;
  line-height: 38px;
  border-radius: 50px;
  -webkit-transition: all 0.3s;
  transition: all 0.3s;
  width: 170px;
  text-align: center;
  border: none;
}

.download:hover {
  background: #fff;
  color: #339DFF;
  box-shadow: 0 4px 4px rgba(83, 100, 255, 0.32);
  cursor: pointer;
}

.footer-tag {
	decoration: none;
	color: black;
}

center{
border-radius: 5px;
  padding: 20px;

}

form{
border: 3px solid black;
margin-left: 20%;
margin-right: 20%;
}
	
	
	
	.navigation {
  width: 100%;
  background-color: black;
  
}


.logout {
  font-size: .8em;
  font-family: 'Oswald', sans-serif;
  position: relative;
  right: -18px;
  bottom: -4px;
  top: -10px;
  overflow: hidden;
  letter-spacing: 3px;
  opacity: 0;
  transition: opacity .45s;
  -webkit-transition: opacity .35s;
  
}

.button {
	text-decoration: none;
	float: right;
  padding: 12px;
  margin: 15px;
  color: white;
  width: 25px;
  background-color: black;
  transition: width .35s;
  -webkit-transition: width .35s;
  overflow: hidden;
}

.button:hover {
  width: 100px;
}

.button:hover .logout{
  opacity: .9;
}

.button {
  text-decoration: none;
}



	
	
	
	</style>
</head>
<body>
<div class = "header">
<h2>Welcome!!</h2>

<h2>Nagaratna's Login page</h2>
	<div class="navigation">
  
	<a class="button" href="">
  	
  <i class="fa fa-sign-out"></i>
  <div class="logout">LOGOUT</div>

	</a>
  
</div>

</div>


	
<center>
	<form action="login.do" name="infoForm" onSubmit="return validate()" >

<div class="col-3 input-effect">
        <input class="effect-17" type="text" placeholder="" name="contact_number">
        <label>Contact Number</label>
        <span class="focus-border"></span>
</div>
<!--  contact_number: <input type = "text" name = "contact_number">-->

<div class="col-3 input-effect">
        <input class="effect-17" type="text" placeholder="" name="userName">
        <label>UserName</label>
        <span class="focus-border"></span>
</div>
<!--  userName: <input type = "text" name = "userName"> -->
<div class="col-3">
<h4>Gender</h4>
<input type = "radio" name = "gender" value = "male">Male <input type = "radio" name = "gender" value = "female"> Female
</div>
<div class="col-3 input-effect">
        <input class="effect-17" type="text" placeholder="" name="emailID">
        <label>emailID</label>
        <span class="focus-border"></span>
</div>

<div class="col-3 input-effect">
        <input class="effect-17" type="date" placeholder="" name="dateOfBirth">
        
        <span class="focus-border"></span>
</div>

<div class="col-3 input-effect">
        <input class="effect-17" type="password" placeholder="" name="password">
        <label>Password</label>
        <span class="focus-border"></span>
</div>

<div class="col-3 input-effect">
        <input class="effect-17" type="password" placeholder="" name="cpassword">
        <label>Confirm Password</label>
        <span class="focus-border"></span>
</div>

<hr>
<input type = "submit" value ="SUBMIT" class="download">


</form>
</center>

<div class = "footer">
<h3><a class="footer-tag" href="#">Contact Us</a></h3>
<h3>@Since 2021</h3>
<h3><a class="footer-tag" href="#">Help</a></h3>
</div>
</body>
</html>
