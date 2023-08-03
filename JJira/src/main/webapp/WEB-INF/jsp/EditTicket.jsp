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
  <h2>Displaying Ticket</h2>
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
      <h2>Ticket</h2>
      
      <c:if test="{errormessage != null}"> <p> <c:out value='${errormessage}'></c:out> </p> </c:if>
      <c:if test="{errormessage == null}"> <p> No Error Message, or null </p> </c:if>
      <p>
			Message from server: <%= request.getAttribute("errormessage") %> 
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
       <form name="updateticket" action="updateticket" method="post">      
      	<table class="tiktable" id="tikTable">
      		<tr>
            	 <th> ID: </th>
            	 	<td class="tikid"> <input class="tikid" type="text" name="id"  value="<c:out value='${tik.id}' />"  /> </td>
            </tr>
            <tr>
            	 <th> Severity: </th>
            	 	<td> <input type="text" name="Severity"  value="<c:out value='${tik.severity}' />"  required/></td>
            	</tr>	
            <tr>
            	 <th> Title: </th>
            	 	<td> <input type="text" name="title"  value="<c:out value='${tik.title}' />"  required/></td>
            	</tr>
            	<tr>
            	 <th> Summary: </th>
            	 	<td> <input type="text" name="summary"  value="<c:out value='${tik.summary}' />"  required/></td>
            	</tr>
            	<tr>
            	 <th> State: </th>
            	 	<td> <input type="text" name="state"  value="<c:out value='${tik.state}' />"  required/></td>
            	</tr>
            	<tr>
            	    <th> Update: </th>
            		<td> <input type="submit" value="Submit" > </td>
            	</tr>
      	</table>
      	
      	 
       </form>
      
    </div>
    </div> <!-- end empcard -->

  <!-- Form to add notes -->
   <div class="tiktoknotes">
   
   	<h1>Add Notes:</h1>
   	 <form name="formName"  action="addnotesticket" method="post" onsubmit="return validateForm()" required>
   	 	
   	 	<input type="hidden" name="tikid" value="<c:out value='${tik.id}' />">
   	 	Notes: <input type="text" name="tiknotesta" required>
   	  <!-- 	<textarea name="tiknotesta" id="tiknotes" required> </textarea>  -->
   	 	
   	 	<input type="submit" value="Submit" name="addLog">
   	 </form>
   </div>

    <div class="tikcard">
      <h2>Ticket# <c:out value='${tik.id}' /></h2>
      <h5>Date Created: <c:out value='${tik.date}' /></h5>
      <!--  <div class="fakeimg" ><i class='bx bx-cylinder'></i>Go to Ticket</div> -->
      <p> <c:out value='${tik.title}' /> </p>
      <p> <c:out value='${tik.summary}' /> </p>
    </div>
    
    <!--  use a for loop to get all the notes for this ticket -->
    <c:forEach var="tiklog" items="${tik.tiknotes}">
    	<div class="tikcard">
    		<h2>Notes</h2>
    		<p> <c:out value='${tiklog.notes}' /> </p>
    		
    		<h2>Date Created</h2>
    		<p> <c:out value='${tiklog.datecreated}' /> </p>
    		
    		<h2>Log ID</h2>
    		<p> <c:out value='${tiklog.logid}' /> </p>
    		
    	</div>
    </c:forEach>
    
    <!-- Form to add notes -->
   <div class="tiktoknotes">
   
   	<h1>Add Notes:</h1>
   	
   </div>
    
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
    
    <div class="card">
      <h3>Follow Me</h3>
      <p>Some text..</p>
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


