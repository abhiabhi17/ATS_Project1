<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<style>

.outerbx
{
 border: 1px solid;
  padding: 10px;
  box-shadow: 5px 10px  5px #888888;

}

#shadow {
  border: 1px solid;
  padding: 10px;
  box-shadow: 5px 10px 5px 10px #888888;
}
.error {
	color: #FF0000
	
}

.header {
  overflow: hidden;
  background-color: #f1f1f1;
  padding: 20px 10px;
}

.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
}

.header a.logo {
  font-size: 25px;
  font-weight: bold;
}

.header a:hover {
  background-color: #ddd;
  color: black;
}

.header a.active {
  background-color: dodgerblue;
  color: white;
}

.header-right {
  float: right;
}

</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script type="text/javascript">
$(function() {
	$('form[id="registerForm"]').validate({
		rules : {
			firstname : 'required',
			lastname : 'required',
			email : {
				required : true,
				email : true
			},
			phonum:{
			      required:true,
			  minlength:10,
			  maxlength:10,
			  number: true
			  },
			
			
			dob : 'required',
			
			gender : 'required',
			role:'required'
			
		},
		messages : {
			firstname : 'Please Enter First name',
			lastname : 'Please Enter Last Name',
			email : 'Please Enter Email',
			phonum : 'Please Enter Valid 10 Digit Phono Number',
				dob : 'Please Select Date Of Birth',
				gender : 'Please Select Gender',
			 role: 'Please Select Role'
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});

$( function() {
    $( "#datepicker" ).datepicker();
  } );
</script>
</head>
<body>
<div class="header" id="shadow">
  <a href="#default" class="logo"><h3 style:color=red">Advanced Toll Payment System</h3></a>
  <div class="header-right">
    <a class="active" href="login">Home</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
  </div>
</div>

<div class="outerbx" >
<form:form action="registerAgency" method="POST"  modelAttribute="registerform" id="registerForm">
   <fieldset style="margin-left:600px;margin-top:100px">

           <!-- Form Name -->
             <legend style="color:red">Please Fill Registration Form Details</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="fname">First Name</label>  
  <div class="col-md-4">
<!--   <input id="fname" name="fname" type="text" placeholder="John" class="form-control input-md" required=""> -->

   <form:input path="firstname" class="form-control input-lg" placeholder="First Name"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="lname">Last Name</label>  
  <div class="col-md-4">
   <form:input path="lastname" class="form-control input-lg" placeholder="Last Name"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">Email</label>  
  <div class="col-md-4">
   <form:input path="email" class="form-control input-lg" placeholder="Enter your Email"/>
    
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Phone Number</label>
  <div class="col-md-4">
    <form:input path="phonum" class="form-control input-lg" placeholder="Phono Number" />
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="email">Date Of Birth</label>  
  <div class="col-md-4">
   <form:input path="dob" class="form-control input-lg" id="datepicker" placeholder="Enter your Date Of Birth"/>
    
  </div>
</div>

<div class="form-group">
<!--   <label class="col-md-4 control-label" for="email">Gender</label>   -->
  <div class="col-md-4">
  <form:label path = "gender">Gender</form:label>&nbsp;&nbsp;&nbsp;&nbsp;
    <form:radiobutton path = "gender" value = "M" label = "Male" />
                  <form:radiobutton path = "gender" value = "F" label = "Female" />
  </div>
</div>


<div class="form-group">
<!--   <label class="col-md-4 control-label" for="email">Gender</label>   -->
  <div class="col-md-4">
  <form:label path = "role">Role</form:label>&nbsp;&nbsp;&nbsp;&nbsp;
            <form:select path="role">
             <form:option value="-" label="-Please Select-"/>
                    <form:option value="user"/>
                    <form:option value="admin"/>
                    <form:option value="agency"/>
                </form:select>
  </div>
</div>
<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="save"></label>
  <div class="col-md-8">
    <button id="save" name="save" class="btn btn-success">Register</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button id="clear" name="clear" class="btn btn-danger">Reset</button>
  </div>
</div>

</fieldset>

<h2><font color='green'>${succMsg}</font></h2>
</form:form>

</div>
</body>
</html>