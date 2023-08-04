<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>


<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Jira Project</title>
<link   rel="stylesheet" href="css/style2a.css">

<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

<script>
function validateForm() {
  var x = document.forms["formName"]["tiknotesta"].value;
  if (x == "" || x == null) {
    alert("Name must be filled out");
    return false;
  }
}
</script>

</head>
<body>

<div class="header">
  <h1>Jira - Bug Tracking and Inventory DB</h1>
  <h2>Displaying Group Details</h2>
</div>

<div class="topnav">
  <a href="html4.html">Home</a>
  <a href="grouppage.html">New Group</a>
  <a href="bugpage.html">New Bug</a>
  <a href="newticket.html">New Ticket</a>
  <a href="#" style="float:right">Login</a>
</div>

<div class="row">
 <div class="columna">
    <div class="carda">
     <h2>Group</h2>
     <p>Technical Groups. 
        Create new group. 
        List Group
        <div class="dropdown">
          <span><a href="grouppage.html"><i class='bx bxs-factory bx-md'></i></a></span>
           <div class="dropdown-content">
             <p>Create New Group, list all groups.</p>
           </div>
        </div>
      </p>
        
    </div> 
 </div>
 <div class="columna">
    <div class="carda">
        <h2>Employee</h2>
          <p>New employee.
             List all employees.
             <div class="dropdown">
              <span><a href="employeepage.html"><i class='bx bxs-book-content bx-md'></i></a></span>
               <div class="dropdown-content">
                 <p>List all Employees, create new employees.</p>
               </div>
            </div>
          </p>
          
      </div> 
 </div>
 <div class="columna">
    <div class="carda">
        <h2>Bug</h2>
       <div class="buglinks">
         <a class="buggya" href="bugpage.html">New Bug.</a>  
         <a class="buggya" href="listallbugs">List all bugs</a>
         <a class="buggya" href="bugpage.html">Search for Bug.</a> 
       </div>
        
        
         <!-- 
             <div class="dropdown">
              <span><a href="bugpage.html"><i class='bx bxs-bug bx-md'></i></a></span>
               <div class="dropdown-content">
                 <p><a href="listallbugs">List all bugs</a>, also search for bugs in DB.</p>
               </div>
            </div>
        -->
         
      </div> 
 </div>
</div>

<div class="row">
  <div class="leftcolumn">
    <div class="empcard">
      <h2>Team</h2>
      
      <c:if test="{message != null}"> <p> <c:out value='${message}'></c:out> </p> </c:if>
      <c:if test="{message == null}"> <p> No Error Message, or null </p> </c:if>
      <p>
			Message from server: <%= request.getAttribute("message") %> 
	  </p>
      <!-- 
      <div class="dropdown">
        <span>Showing Ticket#   <c:if test="${tik != null}"> <c:out value='${tik.id}' />	</c:if></span>
         <div class="dropdown-content">
           <p>Listing ticket from the DB..</p>
         </div>
      </div>
       -->
      
      <div class="tablediv">   
       <form name="updatebug" action="updategroup" method="post">      
      	<table class="tiktable" id="tikTable">
      		<tr>
            	 <th> ID: </th>
            	 	<td class="tikid"> <input class="tikid" type="text" name="id"  value="<c:out value='${group.id}' />" readonly required/> </td>
            </tr>
            <tr>
            	 <th> Name: </th>
            	 	<td> <input type="text" name="name"  value="<c:out value='${group.name}' />"  required/></td>
            	</tr>	
            <tr>
            	 <th> Email: </th>
            	 	<td> <input type="text" name="email"  value="<c:out value='${group.email}' />"  required/></td>
            	</tr>
            	
            	<tr>
            	    <th> Update: </th>
            		<td> <input type="submit" value="Submit" > </td>
            	</tr>
            	
      	</table>
      	
      	 
       </form>
       <br>
       <br>
       
      
    </div>
    </div> <!-- end empcard -->

  <!-- Form to add notes -->
   
    
   
    
   
   <!-- Form to add Employee to Group -->
     
   <div class="tiktoknotes"> 
   
    	<h1>Select Employee:</h1> 
   	 <form action="selectemployee" method="post"> 
   	 <input class="tikid" type="hidden" name="id"  value="<c:out value='${group.id}' />" readonly required/>
   	 <input type="submit" value="Add Employee" > </form>
    </div> 
   
    <br> 
    
<!--      use a for loop to get all the notes for this ticket -->
     <c:forEach var="emp" items="${group.emps}">
    	<div class="tikcard"> 
     		<h2>First Name:</h2> 
    		<p> <c:out value='${emp.fname}' /> </p>
    		
     		<h2>Last Name:</h2> 
    		<p> <c:out value='${emp.lname}' /> </p>
    		
     		<h2>Email:</h2> 
    		<p> <c:out value='${emp.email}' /> </p>
    		
    		<h2>ID:</h2> 
    		<p> <c:out value='${emp.id}' /> </p>
    		
    		<h2>ID:</h2> 
    		<p> <c:out value='${emp.id}' /> </p>
   		</div> 
    </c:forEach> 
     
     
     
    
  </div> <!-- END leftcolumn card -->

 
 
 <!-- Right Column -->
  <div class="rightcolumn">
    <div class="card">
      <h2>Ticket</h2>
      <p><a href="listalltickets">List all tickets</a></p>
      <p><a href="newticket.html">New ticket</a></p>
      <p><a href="searchticket.html">Search ticket</a></p>
    </div>
    <div class="card">
     <h2>Groups/Teams</h2>
      <p><a href="listallgroups">List all teams</a></p>
      <p><a href="grouppage.html">New team</a></p>
      <p><a href="grouppage.html">Search teams</a></p>
      
    </div>
    <div class="card">
      <h2>Employee</h2>
      <p><a href="listallemployees">List all Employees</a></p>
      <p><a href="employeepage.html">New Employee</a></p>
      <p><a href="employeepage.html">Search Employee</a></p>
    </div>
  </div>
</div>
<!-- 
<div class="footer">
  <h2>Footer</h2>
</div>
-->


</body>
</html>


