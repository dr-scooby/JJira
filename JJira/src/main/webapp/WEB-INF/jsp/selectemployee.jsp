<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>


<html>
<head>
<style>

table{
	width: 100%;
	border: 1px solid black;
	border-collapse: collapse;
}

table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 15px;
}

th{
	background-color: red;
}

</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Jira Project</title>
<link rel="stylesheet" href="css/style2a.css">

<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>

<div class="header">
  <h1>Jira - Bug Tracking and Inventory DB</h1>
  <h2>Listing all Groups/Teams</h2>
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
      <h2>Listing all Groups/Teams</h2>
      
      <div class="dropdown">
        <span>Showing Groups</span>
         <div class="dropdown-content">
           <p>Listing all Groups/Teams from the DB..</p>
         </div>
      </div>
      
      <div class="tablediv">
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
            	          	
            	
      	</table>
    </div>
    
    
    <br>
    <h2>Select an Employee, multiple selection allowed</h2>
    <br>
    
    <div class="formB">
        
        <form  action="addemployeetoteam" method="post">  
         <!-- groupid is hidden -->
         <input  type="hidden" name="teamid"  value="<c:out value='${group.id}' />" />    
      	<table >
      		<tr>
      		  <th> ID: </th> <th> First Name: </th> <th> Last Name: </th>  <th> Email: </th> <th> Select: </th>
      		</tr>
      		
      		  <c:forEach var="emp" items="${emps}">
      		<tr>
            	 <td class="tikid"> <input class="tikid" type="text" name="id"  value="<c:out value='${emp.id}' />" readonly /> </td>
            	 <td> <input type="text" name="fname"  value="<c:out value='${emp.fname}' />"  readonly/></td>
            	 <td> <input type="text" name="lname"  value="<c:out value='${emp.lname}' />"  readonly/></td>
            	 <td> <input type="text" name="lname"  value="<c:out value='${emp.email}' />"  readonly/></td>
            	 <td> <input type="checkbox"  name="chk_emp"   value="<c:out value='${emp.id}' />" > </td>
            </tr>
      
            	 </c:forEach>
      	</table>
      	<br>
      	 <input type="submit" value="Submit" >
       </form>
        
    </div>
    
    
    
    
    </div> <!-- end empcard -->

 <!-- show the employees in this group -->
 
 
    <div class="empcard">
        <h2>Listing Employees in this Group</h2>
        
        <table >
      		<tr>
      		  <th> ID: </th> <th> First Name: </th> <th> Last Name: </th>  <th> Email: </th> 
      		</tr>
      		
      		  <c:forEach var="em" items="${group.allemps}">
      		<tr>
            	 <td class="tikid"> <input class="tikid" type="text" name="id"  value="<c:out value='${em.id}' />" readonly /> </td>
            	 <td> <input type="text" name="fname"  value="<c:out value='${em.fname}' />"  readonly/></td>
            	 <td> <input type="text" name="lname"  value="<c:out value='${em.lname}' />"  readonly/></td>
            	 <td> <input type="text" name="lname"  value="<c:out value='${em.email}' />"  readonly/></td>
            	 
            </tr>
      
            	 </c:forEach>
      	</table>
        
        
    </div>

    <div class="card">
      <h2>Ticket# 102</h2>
      <h5>Created, Sep 2, 2017</h5>
      <div class="fakeimg" ><i class='bx bx-cylinder'></i>Go to Ticket</div>
      <p>Server 2008 virus</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
    </div>
    <div class="card">
      <h2>Ticket# 102</h2>
      <h5>Created, Sep 2, 2017</h5>
      <div class="fakeimg" ><i class='bx bx-cylinder'></i>Go to Ticket</div>
      <p>Jira Bug</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
    </div>
  </div>

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


