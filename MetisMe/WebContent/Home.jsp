<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
<title>Home</title>
<style type="text/css">
[class^="post-"]
 {
  font-family: Arial;
}

.post-card {
  display: block;
  margin: 20px auto;
  width: 400px;
  padding: 5px;
  border-radius: 4px;
  box-shadow: 0px 1px 2px rgba(0,0,0,.5);
  background: #F7F7F7;
}

.post-user
 {
  float: left;
  font-size: 18px;
  font-weight: bold;
}

.post-date {
  float: right;
  color: grey;
}

.post-body {
  padding-top: 20px;
}
textarea
 {
resize: none;
}
.modal
 {
  height: 60%;
}
.Body2
 {
   height: 80%;
   overflow-y: scroll;
  }



}
#follow
{
overflow-y: auto; 
height:600px;

}

#picture
{
height:150px;

}
.span3
{
color: white;
background-color: white;


}
.span4
{

-moz-border-radius: 20px;
    -webkit-border-radius: 20px;
    -khtml-border-radius: 20px;
    border-radius: 20px;
    border: none;

}

.updatebtn
{
padding-left: 10px;
padding-bottom:10px; 
}
.modal 
{
width:400px; 
height:300px;
}
.msg
{
padding-left: 5px;

}
.heading
{
text-align: center;

}
a
{
float: left;

}
body
{
background-image:url('HomeBackground.jpg');

background-repeat:no-repeat;

}
.span10
{

width:200px;
background-color:maroon;
color:white; 
	-moz-border-radius: 20px;
    -webkit-border-radius: 20px;
    -khtml-border-radius: 20px;
    border-radius: 20px;
    border: none;
}
.span2
{
background-color: aqua;
border: thin;
border-color: black;
-moz-border-radius: 10px;
    -webkit-border-radius: 10px;
    -khtml-border-radius: 10px;
    border-radius: 10px;
    border: none;
}
.time
{
text-align:right; 
}
</style>
</head>
<body>
<div class="navbar navbar-fixed-top navbar-inverse">
  <div class="navbar-inner">
    <div class="container"><!-- Collapsable nav bar -->
    <label class="brand">Connectify-Friend</label>
      <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
     </a>
      <!-- Your site name for the upper left corner of the site -->
     
      <!-- Start of the nav bar content -->
      <div class="nav-collapse" align="right"><!-- Other nav bar content -->
      
       
    <div id="drop" class="btn-group">
    <a class="btn btn-primary btn-small" href="#"><i class="icon-user icon-white"></i>${username}</a>
    <a class="btn btn-primary btn-medium dropdown-toggle" data-toggle="dropdown" href="#"> <span class="caret"></span></a>
    <ul class="dropdown-menu">
    <li><a href="UserDataForHomePage"><i class="icon-home"></i>Home</a></li>
    <li><a href="#picture" data-toggle="modal" role="button" data-target="#picture"><i class="icon-picture"></i>Change Profile Picture</a></li>
    <li><a href="#"><i class="icon-hand-right"></i> Follower:${follower}</a></li>
    <li><a href="#"><i class="icon-hand-right"></i> Following:${following}</a></li>
    
    <li><a href="logout" class="" id="logout"><i class="icon-off"></i>Sign out</a>
    </ul>
    </div>
      
  
     
      
      </div>
    </div>
  </div>
</div>
<br>
<br>
<br>
<div class="mainbody">
<div align="center">
<img src="ProfileImages/${image_path}" class="img-rounded" height="140" width="140">

</div>
    <div class="container-fluid">
    <div class="heading">
     <p class="lead">Updates of whom you follow</p>
    </div>
    <div class="row-fluid">
    <div class="span2" align="left" >
    <div align="left">
    
    <dl class="dl-horizontal">
    <dt>Follower:</dt>
    <dd>${follower}</dd>
    <dt>Following:</dt>
    <dd>${following}</dd>
    </dl>
</div>

    
<div id="modelbtn" class="updatebtn">      
<a href="#myModal" role="button"  class="btn btn-link"  data-toggle="modal"><i class="icon-hand-right"></i> Create Message</a><br>
<a href="#follow" role="button"  class="btn btn-link"  data-toggle="modal"><i class="icon-hand-right"></i>Your Friend Follow</a><br>
<form id="fpeople" method="post" action="FollowPeopleServlet">
<button name="FollowPeople" class="btn btn-link"><i class="icon-hand-right"></i> Follow people</button>
<input type="hidden" value="${userid}" name="userid">
 </form>
 </div>
 




<!-- Message Modal -->
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i class="icon-remove"></i></button>
<h3 id="myModalLabel">Create Message</h3>
</div>
<form id="form1" method="post" action="UpdateMessageServlet">
<div class="modal-body">
<textarea rows="5" cols="20" name="status"></textarea>
</div>
<div class="modal-footer">

<input type="hidden" value="${userid}" name="user_id">
<button class="btn btn-primary" id="savebtn">Post</button>
</div>
</form>
</div>
 </div>
    

 
 
 
 
 
    <!--Sidebar content-->
  
<div class="span4" >
<c:forEach  items="${messages}" var="msg" >
<div class="post-card" >
  <div class="post-title">
    <span class="post-user">${msg.getUsername()}</span>
    <span class="post-date"> ${msg.getTime()}</span>
  </div>
  <br>
  <span>${msg.getDate()}</span>
  <div class="post-body">
    <p>${msg.getMessage()}</p>
  </div>
</div>
</c:forEach>
   </div>
   


<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>   
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
<script type="text/javascript">


	
$('#savebtn').click(function(){
	$('#form1').validate();
	
});	
$("#modelbtn").on("click", function(e) {
	e.preventDefault();
	$("#follow").dialog('show');
	});



$("#modelbtn").on("click", function(e) {
	e.preventDefault();
	$("#myModal").dialog('show');
	});
var el = document.getElementById('logout');
el.onclick = showFoo;


function showFoo()
{
var log=confirm('Are you sure you want to logout');
if(log==true)
	return true;
	else
  return false;
}
</script>
</body>
<!--Pic modal -->
<div id="picture" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i class="icon-remove"></i></button>
<h3 id="myModalLabel1">Upload Profile pic</h3>
</div>
<form id="form_pic" method="post" action="FileUploadServlet" enctype="multipart/form-data">
<div class="modal-body">
<input type="file" name="file"/>
</div>
<div class="modal-footer">
<button class="btn btn-primary" id="upload">Upload</button>
</div>
</form>
</div>
    
<!--Friend follow modal-->
<div id="follow" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i class="icon-remove"></i></button>
<h3 id="myModalLabel2">Your Friend Follow</h3>
</div>
<div class="Body2">
<c:forEach items="${people_list}" var="follow_list">
<ul type="none"><li type="none">
<form id="follow_people" method="post" action="FollowPeopleServlet">
<div class="modal-body">
<img src="ProfileImages/${follow_list.getPath()}" height="50" width="50"  class="img-rounded"><br>
${follow_list.getUsername()}<br>
${follow_list.getEmail()}<br>
<input type="hidden" value="${follow_list.getUserid()}" name="follow_id">
<input type="hidden" value="${userid}" name="person_id">
<button class="btn btn-primary" name="req_type" id="follow_too" value="Follow_mutual" >Follow</button>
</div>
</form>
</li>
</ul>
</c:forEach>
</div>
</div>



</html>