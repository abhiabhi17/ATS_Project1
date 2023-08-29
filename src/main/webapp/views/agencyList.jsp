<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>

.outerbx
{
 border: 10x solid;
  padding: 10px;
  box-shadow: 5px 10px  5px #888888;
  margin-top:50px;


}
#shadow {
  border: 1px solid;
  padding: 10px;
  box-shadow: 5px 10px 5px 10px #888888;
}
.header {
  overflow: hidden;
  background-color: #f1f1f1;
  padding: 20px 10px;
}

.header a {
  float: left;

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
<meta charset="ISO-8859-1">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap.min.css">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
<script src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<sciprt src="https://code.jquery.com/jquery-3.3.1.js"></sciprt>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap.min.js"></script>


<script>
$(document).ready(function () {
	  $('#dtBasicExample').DataTable();
	  $('.dataTables_length').addClass('bs-select');
	  
	});




function confirmDelete() {
	var status = confirm("Are you sure, you want to delete?");
	if (status) {
		return true;
	} else {
		return false;
	}
}
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

<div class=outerbx>
	<table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%" >
	<thead>
	<tr>
	<th>S.no</th>
		<th  class="th-sm">FirstName</th>
		<th  class="th-sm">LastName</th>
		<th  class="th-sm">Email</th>
		<th  class="th-sm">PhonoNumber</th>
		<th  class="th-sm">Action</th>
     </tr>
   </thead>
	
	<tbody>
	<c:forEach items="${agencyList}" var="agency" varStatus="index">
	<tr>
	    <td>${index.count}</td>
	    <td>${agency.firstname}</td>
	     <td>${agency.lastname}</td>
	    
	              
	    <td>${agency.email }</td>
	    <td>${agency.phonum }</td>
	    <td>
	     <c:choose>
	             <c:when test="${agency.activestatus == 'N'}">
	                        
	                      <a href="updateToactive?id=${agency.id}"  > <span style='font-size:20px;color:red'>&#10006;</span></a>
	                            
	           </c:when>
	        
                <c:otherwise>  
                         <a href="updateToInactive?id=${agency.id}"  > <span style='font-size:20px;color:green'>&#10004;</span></a>
                 </c:otherwise>
                 
                 </c:choose>
              
          
            
            
         </td>
	    <!-- <td><a href="" >
	    
	    
<span style='font-size:20px;color:red'>&#10006;</span></a></td> -->



	 </c:forEach>

	 
	 </tbody>
	 </table>
	<c:if test="${cp>1}">
	<a href="viewAgencies?pn=${cp-1}">Previous</a>
	</c:if>
	<c:forEach begin="1" end="${tp}" var="i">
        <c:choose>
           <c:when test="${cp==i }">
        
                 <c:out value="${i}"/>
                  </c:when>
                  <c:otherwise>
                        <a href="viewAgencies?pn=${i}">
                         <c:out value="${i}"/></a>
                  </c:otherwise>
     </c:choose>
	 </c:forEach> 
 <c:if test="${cp<tp}">
 <a href="viewAgencies?pn=${cp+1}">Next</a>
 </c:if>
	</div>
</body>
</html>