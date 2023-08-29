<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<style>

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

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript">
$(function() {
	$('form[id="registerForm"]').validate({
		rules : {
			temppassword : 'required',
			newpassword : 'required',
			confirmpassword : 'required'
		
		},
		messages : {
			temppassword : 'Please Enter TemperoryPassword',
			newpassword : 'Please Enter New Password ',
			confirmpassword : 'Please Enter Confirm Password '
			
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});

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
<div class="container" style="margin-top:100px;margin-right:-100px">
	<div class="row">
    <div class="col col-md-5">
		<div class="modal-content">
    			<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title">
						Create an account
					</h4>
				</div>
				<div class="modal-body">
				
				<form:form action="unlockScreenAgency?email=${unlockform.email}" method="POST"  modelAttribute="unlockform" id="registerForm" novalidate="novalidate">
					
						<div id="errorSignUp">
						
						</div>
						
						<div class="form-group">
							<label class="control-label" for="email">Temperory Password</label>
							<div class="input-group">
								<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
								
								<form:input path="password" class="form-control" placeholder="Password" />
								
							</div>
						</div>
							
						<div class="form-group">
							<label class="control-label" for="password">New Password</label>
							<div class="input-group">
								<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
								<form:input path="newpassword" class="form-control" placeholder="Password"  />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label" for="password">Confirm password</label>
							<div class="input-group">
								<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
								<form:input path="confirmpassword" class="form-control" placeholder="Password"  />
							</div>
						</div>
						
						<div class="checkbox">
							<label>
								<input id="term" type="checkbox">
								I have read and accepted  <a target="_blank" href="#">the terms and conditions of use.</a>
							</label>
						</div>
						
						<input type="submit" id="btnSignUp" class="btn btn-success" style="width: 127px;"></button>
					</form:form>
					
				</div>
				<div class="modal-footer">
					<small>Already a member? <a class="alreadySignUp" href="login">Login here</a></small>
				</div>
			</div>
            </div>
	</div>
</div>
</body>
</html>