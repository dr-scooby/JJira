<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>


<html>
<head>
<style>

</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Jira Project</title>
<link rel="stylesheet" href="css/style2.css">

<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>

<div class="header">
  <h1>Jira - Bug Tracking and Inventory DB</h1>
  <h2>Listing all Bugs</h2>
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
      <h2>Added Bug</h2>
      
      <div class="dropdown">
        <span>Showing Bugs</span>
         <div class="dropdown-content">
           <p>Listing all bugs from the DB..</p>
         </div>
      </div>
      
      <div class="tablediv">
        <table class="bugtable">
            <tr>
            
            <th>Name</th>
            <th>Severity</th>
            
            <th>Description</th>
            </tr>
            
           
            	<tr>
            		
            		<td><c:out value="${bug.name}"/></td>
            		<td><c:out value="${bug.severity}"/></td>
            		
            		<td><c:out value="${bug.description}"/></td>
            	</tr>
         
                        
        </table> 
    </div>
    </div> <!-- end empcard -->


    <div class="empcard">
        <h2>Search Bug</h2>
        
        <div class="dropdown">
          <span>Fill out  info to search</span>
           <div class="dropdown-content">
             <p>Enter full info, name, email, etc..</p>
           </div>
        </div>
        <div class="form">
        <form action="searchbug" method="post">
          <div class="formrow">
              <div class="col-25">
                  <label for="name">Name</label>
                </div>
                <div class="col-75">
                  <input type="text" id="name" name="name" placeholder="Bug name..">
                </div>
          </div>
          
          <div class="formrow">
              <div class="col-25">
                  <label for="description">Description</label>
                </div>
                <div class="col-75">
                  <input type="text" id="description" name="description" placeholder="enter some words..">
                </div>
          </div>
  
          <div class="formrow">
              <div class="col-25">
                  <label for="severity">Severity Level</label>
                </div>
                <div class="col-75">
                  <input type="text" id="severity" name="severity" placeholder="severity level..">
                </div>
          </div>
  
                  
          <br>
      <div class="formrow">
          <input type="submit" value="Submit">
      </div>
        </form> 
      </div>
        
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
      <h2>About Me</h2>
      <div class="fakeimg" ><i class='bx bx-cylinder'></i>Go to Ticket</div>
      <p>Some text about me in culpa qui officia deserunt mollit anim..</p>
    </div>
    <div class="card">
      <h3>Popular Post</h3>
      <div class="fakeimg"><p>Image</p></div>
      
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


