<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Connectify-Friends</title>
<style type="text/css" >
label
{
color: white;
font: bold;

}
.data
{
float:left;
padding-top: 100px;
padding-left: 50px;
font: lighter;

}
.container
{
float:right;
}
.top
{
vertical-align:text-top;
}
.content
{
float:right;

vertical-align:top;
 
}
.hero-unit1
{
float:left;
-moz-border-radius: 20px;
    -webkit-border-radius: 20px;
    -khtml-border-radius: 20px;
    border-radius: 20px;
    padding-left:250px;
    padding-top:50px;
width:400px;
height:250px;


}
.label
{

display:block;
width:100px;
}
.mainbody
{
padding-top: 50px;
}
.body
{
background-image:url('sunrise_background.jpg');
background-repeat:repeat-y;
}
</style>
<script language="javascript">
function validateForm()
{
var x=document.forms["regform"]["email"].value;
var atpos=x.indexOf("@");
var dotpos=x.lastIndexOf(".");
if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
  {
  alert("Not a valid e-mail address");
  return false;
  }
}
$(function()
{
	  // Setup drop down menu
	  $('.dropdown-toggle').dropdown();
	 
	  // Fix input element click problem
	  $('.dropdown input, .dropdown label').click(function(e) {
	    e.stopPropagation();
	  });
	});
 
			
		


</script>

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">

</head>
<body class="body">
<div class="navbar navbar-fixed-top navbar-inverse">
  <div class="navbar-inner">
    <div class="container"><!-- Collapsable nav bar -->
      <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>
 
      <!-- Your site name for the upper left corner of the site -->
      <a class="brand" >Connectify-Friend</a>
 
      <!-- Start of the nav bar content -->
      <div class="nav-collapse"><!-- Other nav bar content -->
        
 
        <!-- The drop down menu -->
        <ul class="nav pull-right">
         <li><h4><p align="center" id="result">
    <font color="white">
    ${alert}
    
    </font>              
     </p> </h4></li>
          <li class="divider-vertical"></li>
          <li class="dropdown">
            <a class="dropdown-toggle" href="#" data-toggle="dropdown">Sign In <strong class="caret"></strong></a>
            <div class="dropdown-menu" style="padding: 15px; padding-bottom: 0px;">
              <!-- Login form here -->
              <form id="frm2" action="UserRegistrationServlet" method="post" accept-charset="UTF-8">
  <input id="user_username" style="margin-bottom: 15px;" type="text" name="email_id" size="30" placeholder="Email"/>
  <input id="user_password" style="margin-bottom: 15px;" type="password" name="user_password" size="30" placeholder="Password"/>
  <input id="user_remember_me" style="float: left; margin-right: 10px;" type="checkbox" name="user[remember_me]" value="1" />
   Remember me
 
  <input class="btn btn-primary" style="clear: left; width: 100%; height: 32px; font-size: 13px;" id="login" type="submit" name="login" value="Login" />
</form>     
            </div>
          </li>
        </ul>
      </div>
    </div>
  </div>
</div>
<div class="mainbody">
<div class="data">

 <p>
 <font color="white">
 <h3>
 Connect with ur friends in a unique way<br>
 +Follow them<br>
 +Post some message<br>
 +Get Recent updates of whom u follow
 
 </h3>
 </font>
 </p>
 
 </div>
 <div class="container1">
 <label><h3>Registration is free  and always will be</h3></label><br>
<div class="hero-unit1">
<div class="content">

    <form id="regform" class="form-horizontal" method="post" action="UserRegistrationServlet" onsubmit="return validateForm();">
    <div class="control-group">
    <label class="control-label" for="inputEmail">Name</label>
    <div class="controls">
    <input type="text" id="inputname" name="username" required="required" placeholder="Name"/>
    </div>
    </div>
    <div class="control-group">
	<label class="control-label" for="inputIcon">Email address</label>
	<div class="controls">
	<div class="input-prepend">
	<span class="add-on"><i class="icon-envelope"></i></span>
	<input class="span2" id="inputIcon" type="text" name="email" placeholder="Email address" required="required">
	</div>
	</div>
	</div>
    <div class="control-group">
    <label class="control-label" for="inputPassword">Password</label>
    <div class="controls">
    <input type="password" id="inputPassword" name="password" required="required" placeholder="Password"/>
    </div>
    </div>
    
    
    
    <div class="control-group">
    <div class="controls">
    <input type="submit" class="btn btn-primary" name="login" id="submit" value="Register" >
    </div>
    </div>
    
    </form>
    <h3>
    <p align="center" id="result">
    <font color="white">
    
    ${result}
    
    </font>              
     </p>
     </h3>
    </div>
</div>
</div>
</div>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>   
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
<script language="javascript">



$(document).ready(function() 
		{
			$("#time").datepicker();
			$("#result").fadeOut(4000);
		});
$('#submit').click(function(){
	$('#regform').validate();
	
});	

</script>


</body>
</html>