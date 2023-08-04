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
  <h2>Listing all Tickets</h2>
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
      <h2>Listing all Tickets</h2>
      
      <div class="dropdown">
        <span>Showing Bugs</span>
         <div class="dropdown-content">
           <p>Listing all bugs from the DB..</p>
         </div>
      </div>
      
      <div class="tablediv">
        <table class="bugtable">
            <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Summary</th>
            <th>Notes</th>
            
            </tr>
            
            <c:forEach var="tik" items="${listalltik}">
            	<tr>
            		<td><a href="editticket?id=<c:out value='${tik.id}'/>">Edit</a>     <c:out value="${tik.id}"/> </td>
            		<td><a href="editticket?id=<c:out value='${tik.id}'/>"><c:out value="${tik.title}"/> </a>      </td>
            		<td><c:out value="${tik.summary}"/></td>
            		<td><c:out value="${tik.notes}"/></td>
            		
            	</tr>
            </c:forEach>
                        
        </table> 
    </div>
    </div> <!-- end empcard -->


    <div class="empcard">
        <h2>Search Ticket</h2>
        
        <div class="dropdown">
          <span>Fill out  info to search</span>
           <div class="dropdown-content">
             <p>Enter full info, name, email, etc..</p>
           </div>
        </div>
        <div class="form">
        <form action="ticketsearch" method="post">
          <div class="formrow">
              <div class="col-25">
                  <label for="title">Title</label>
                </div>
                <div class="col-75">
                  <input type="text" id="title" name="title" placeholder="Your Title name..">
                </div>
          </div>
          
          <div class="formrow">
              <div class="col-25">
                  <label for="summary">Summary</label>
                </div>
                <div class="col-75">
                  <input type="text" id="summary" name="summary" placeholder="summary..">
                </div>
          </div>
  
          <div class="formrow">
              <div class="col-25">
                  <label for="notes">Notes</label>
                </div>
                <div class="col-75">
                  <input type="text" id="notes" name="notes" placeholder="notes..">
                </div>
          </div>
  
          <div class="formrow">
              <div class="col-25">
                  <label for="severity">Severity</label>
                </div>
                <div class="col-75">
                  <input type="text" id="severity" name="severity" placeholder="severity">
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


