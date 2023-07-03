package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DB.DBModel;

/**
 * JIRA Project
 * Java version 1.7
 * @author nurali
 *
 */
public class ControllerServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private DBModel db ; // handle to the DBModel
	

	 /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public void init() {
    	 db = new DBModel();
    }
    
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getServletPath();
		PrintWriter out = response.getWriter();
		
		if(action == null) {
		// Write the response message, in an HTML page
		// this block is to test the Servlet & web.xml is working and configure properly.
	      try {
	         out.println("<!DOCTYPE html>");
	         out.println("<html><head>");
	         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	         out.println("<title>Hello, World</title></head>");
	         out.println("<body>");
	         out.println("<h1>Hello, world! You have successfully reached this Servlet..It's working</h1>");  // says Hello
	         // Echo client's request information
	         out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
	         out.println("<p>Protocol: " + request.getProtocol() + "</p>");
	         out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
	         out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
	         // Generate a random number upon each request
	         out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
	         
	         // Servlet path from client
	         out.println("<p>Servlet path:<strong> " + action + "<strong></p>");
	         out.println("</body>");
	         out.println("</html>");
	      } finally {
	         out.close();  // Always close the output writer
	      }
		}else {
			try {
				switch(action) {
				case "/newgroup":
					newgroup(request, response);
				break;
				case "/searchgroup":
					searchgroup(request, response);
				break;
				case "/newemployee":
					newemployee(request, response);
				break;
				case "/searchemp":
					searchemp(request, response);
				break;
				case "/newbug":
					newbug(request, response);
				break;
				case "/searchbug":
					searchbug(request, response);
				break;
				case "/newticket":
					newticket(request, response);
				break;
				case "/ticketsearch":
					ticketsearch(request, response);
					break;
				default:
					gohome(request, response);
				break;
					
				}
			}catch(Exception e) {
				
			}
		}
	}
	
	private void ticketsearch(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		String notes = request.getParameter("notes");
		//severity
		String severity = request.getParameter("severity");
		
		 PrintWriter out;
		// this block is to test the Servlet & web.xml is working and configure properly.
	      try {
	    	   out = response.getWriter(); 
	    	 
				
				 out.println("<!DOCTYPE html>");
		         out.println("<html><head>");
		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		         out.println("<title>Hello, World</title></head>");
		         out.println("<body>");
		         out.println("<h1>Hello, world! You have successfully submitted to this Servlet..It's working</h1>");  // says Hello
		         out.println("<h1>Search Bug info</h1>");
		         // Echo client's submitted information
		         out.println("<p>Title: " + title + "</p>");
		         out.println("<p>Summery: " + summary + "</p>");
		         out.println("<p>Notes: " + notes + "</p>");	
		         out.println("<p>Severity Level: " + severity + "</p>");
		         
		         out.println("</body>");
		         out.println("</html>");
			
		         out.close();
	      }catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      }
	}


	private void newticket(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		String notes = request.getParameter("notes");
		//severity
		String severity = request.getParameter("severity");
		
		 PrintWriter out;
		// this block is to test the Servlet & web.xml is working and configure properly.
	      try {
	    	   out = response.getWriter(); 
	    	 
				
				 out.println("<!DOCTYPE html>");
		         out.println("<html><head>");
		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		         out.println("<title>Hello, World</title></head>");
		         out.println("<body>");
		         out.println("<h1>Hello, world! You have successfully submitted to this Servlet..It's working</h1>");  // says Hello
		         out.println("<h1>Search Bug info</h1>");
		         // Echo client's submitted information
		         out.println("<p>Title: " + title + "</p>");
		         out.println("<p>Summery: " + summary + "</p>");
		         out.println("<p>Notes: " + notes + "</p>");	
		         out.println("<p>Severity Level: " + severity + "</p>");
		         
		         out.println("</body>");
		         out.println("</html>");
			
		         out.close();
	      }catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      }
	      
	      // send data to the model to process
	      db.anewTicket(title, summary, notes, 0);
	}


	private void searchbug(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("firstname");
		String lasttname = request.getParameter("lasttname");
		String email = request.getParameter("email");
		
		
		 PrintWriter out;
		// this block is to test the Servlet & web.xml is working and configure properly.
	      try {
	    	   out = response.getWriter(); 
	    	 
				
				 out.println("<!DOCTYPE html>");
		         out.println("<html><head>");
		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		         out.println("<title>Hello, World</title></head>");
		         out.println("<body>");
		         out.println("<h1>Hello, world! You have successfully submitted to this Servlet..It's working</h1>");  // says Hello
		         out.println("<h1>Search Bug info</h1>");
		         // Echo client's submitted information
		         out.println("<p>Group Name Search: " + firstname + "</p>");
		         out.println("<p>User Name Search: " + lasttname + "</p>");
		         out.println("<p>Email search: " + email + "</p>");		                
		         
		         out.println("</body>");
		         out.println("</html>");
			
		         out.close();
	      }catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      }
	}


	private void newbug(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bugname = request.getParameter("bugname");
		String description = request.getParameter("description");
		String severity = request.getParameter("severity");
		String state = request.getParameter("state");
		
		 PrintWriter out;
		// this block is to test the Servlet & web.xml is working and configure properly.
	      try {
	    	   out = response.getWriter(); 
	    	 
				
				 out.println("<!DOCTYPE html>");
		         out.println("<html><head>");
		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		         out.println("<title>Hello, World</title></head>");
		         out.println("<body>");
		         out.println("<h1>Hello, world! You have successfully submitted to this Servlet..It's working</h1>");  // says Hello
		         out.println("<h1>New Bug info</h1>");
		         // Echo client's submitted information
		         out.println("<p>Bug Name : " + bugname + "</p>");
		         out.println("<p>Bug description: " + description + "</p>");
		         out.println("<p>severity Level: " + severity + "</p>");
		         out.println("<p>State: " + state + "</p>");
		         
		         
		         out.println("</body>");
		         out.println("</html>");
			
		         out.close();
	      }catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      }
	      
	      db.anewBug(bugname, description, severity, state);
	}


	private void searchemp(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("firstname");
		String lasttname = request.getParameter("lasttname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		 PrintWriter out;
		// this block is to test the Servlet & web.xml is working and configure properly.
	      try {
	    	   out = response.getWriter(); 
	    	 
				
				 out.println("<!DOCTYPE html>");
		         out.println("<html><head>");
		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		         out.println("<title>Hello, World</title></head>");
		         out.println("<body>");
		         out.println("<h1>Hello, world! You have successfully submitted to this Servlet..It's working</h1>");  // says Hello
		         out.println("<h1>Search Employee Page</h1>");
		         // Echo client's submitted information
		         out.println("<p>Group Name Search: " + firstname + "</p>");
		         out.println("<p>User Name Search: " + lasttname + "</p>");
		         out.println("<p>Email search: " + email + "</p>");
		         out.println("<p>Phone search: " + phone + "</p>");
		         
		         
		         out.println("</body>");
		         out.println("</html>");
			
		         out.close();
	      }catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      }
	}


	private void newemployee(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("firstname");
		String lasttname = request.getParameter("lasttname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		 PrintWriter out;
		// this block is to test the Servlet & web.xml is working and configure properly.
	      try {
	    	   out = response.getWriter(); 
	    	 
				
				 out.println("<!DOCTYPE html>");
		         out.println("<html><head>");
		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		         out.println("<title>Hello, World</title></head>");
		         out.println("<body>");
		         out.println("<h1>You have successfully submitted to this Servlet..It's working</h1>");  // says Hello
		         out.println("<h1>New Employee Page</h1>");  // says Hello
		         // Echo client's submitted information
		         out.println("<p>Group Name Search: " + firstname + "</p>");
		         out.println("<p>User Name Search: " + lasttname + "</p>");
		         out.println("<p>Email search: " + email + "</p>");
		         out.println("<p>Phone search: " + phone + "</p>");
		         
		         
		         out.println("</body>");
		         out.println("</html>");
			
		         out.close();
	      }catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      }
		
	      db.anewEmployee(firstname, lasttname, email, phone);
	}


	private void searchgroup(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String gnamesearch = request.getParameter("gnamesearch");
				String usernamesearch = request.getParameter("usernamesearch");
				String emailsearch = request.getParameter("emailsearch");
				 PrintWriter out;
				// this block is to test the Servlet & web.xml is working and configure properly.
			      try {
			    	   out = response.getWriter(); 
			    	 
						
						 out.println("<!DOCTYPE html>");
				         out.println("<html><head>");
				         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
				         out.println("<title>Hello, World</title></head>");
				         out.println("<body>");
				         out.println("<h1>Hello, world! You have successfully submitted to this Servlet..It's working</h1>");  // says Hello
				         out.println("<h1>Search Group Page</h1>");
				         // Echo client's submitted information
				         out.println("<p>Group Name Search: " + gnamesearch + "</p>");
				         out.println("<p>User Name Search: " + usernamesearch + "</p>");
				         out.println("<p>Email search: " + emailsearch + "</p>");
				         
				         
				         
				         out.println("</body>");
				         out.println("</html>");
					
				         out.close();
			      }catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
			      }
		
	}


	private void gohome(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				
				 PrintWriter out;
				// this block is to test the Servlet & web.xml is working and configure properly.
			      try {
			    	   	out = response.getWriter(); 			    	 
						
						 out.println("<!DOCTYPE html>");
				         out.println("<html><head>");
				         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
				         out.println("<title>Hello, World</title></head>");
				         out.println("<body>");
				         out.println("<h1>Hello, world! </h1>");  // says Hello 
				         out.println("<h1>You have reached the gohome page by some strange reason. </h1>");			         
				         out.println("</body>");
				         out.println("</html>");
					
				         out.close();
			      }catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
			      }
	}


	private void newgroup(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String gname = request.getParameter("groupname");
		String gtype = request.getParameter("type");
		String email = request.getParameter("email");
		 PrintWriter out;
		// this block is to test the Servlet & web.xml is working and configure properly.
	      try {
	    	   out = response.getWriter(); 
	    	 
				
				 out.println("<!DOCTYPE html>");
		         out.println("<html><head>");
		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		         out.println("<title>Hello, World</title></head>");
		         out.println("<body>");
		         out.println("<h1>Hello, world! You have successfully submitted to this Servlet..It's working</h1>");  // says Hello
		         out.println("<h1>New Group Page</h1>");
		         // Echo client's submitted information
		         out.println("<p>Group Name: " + gname + "</p>");
		         out.println("<p>Group Type: " + gtype + "</p>");
		         out.println("<p>Email: " + email + "</p>");
		         
		         
		         
		         out.println("</body>");
		         out.println("</html>");
			
		         out.close();
	      }catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      }
	      
	      db.anewTeam(gname, email);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
