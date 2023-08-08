<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isErrorPage="true"
%>

<%@ page import="java.io.*" %>
    
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Jira Project</title>
<link rel='stylesheet'       href="css/style2a.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>

<div class="header">
  <h1>Jira - Bug Tracking and Inventory DB</h1>
  <h2><p>Error Page</p></h2>
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
          <p>New Bug.
             List all Bugs.
             <div class="dropdown">
              <span><a href="bugpage.html"><i class='bx bxs-bug bx-md'></i></a></span>
               <div class="dropdown-content">
                 <p>List all bugs, also search for bugs in DB.</p>
               </div>
            </div>
          </p>
          
      </div> 
 </div>
</div>

<div class="row">
  <div class="leftcolumn">
    
    <!--  Error -->
     <div class="errorcard">
        <h2 class="errorh2">Error</h2>
        
        <p>
			Message from server: <%= request.getAttribute("exception") %> 
		</p>		
        <br>
        
        <br>
        <p> <%= request.getAttribute("error") %>
        
      </div>
    
        
  </div>  


   

  
  

<!-- 
<div class="footer">
  <h2>Footer</h2>
</div>
-->
</body>
</html>


    