/**
* TeamController - used for the AJAX to get Group/Team listing
* Moved away from the ControllerServlet  
*/
package com.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DB.DBModel;
import com.data.Employee;
import com.data.Group;
import com.google.gson.Gson;

public class TeamController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DBModel db ; // handle to the DBModel
	private String dbname;
	private String dbuser;
	private String dbpass;
	
	
	
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public void init() {
    	// get the configs from the web.xml
    	dbname = "JiraDB";
    	dbuser = "nurali";
    	dbpass = "java1973";
    	// pass the info to the DBModel
//    	try {
//			db = new DBModel(dbname, dbuser, dbpass);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			db = new DBModel(dbname, dbuser, dbpass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String teamid = request.getParameter("techteamid");
		String techid = request.getParameter("techid");
		String ticketid = request.getParameter("ticketID");
		
		if(teamid !=null || techid!=null || ticketid!=null) {
			if( (!teamid.isEmpty() || !techid.isEmpty() || !ticketid.isEmpty())  ) {
				System.out.println("Got data:");
				System.out.println("teamid:" + teamid);
				System.out.println("techid:" + techid);
				System.out.println("ticketid:" + ticketid);
				if(teamid.equals("Select Team") || techid.equals("Select Tech")) {
					response.setContentType("text/html");
					response.getWriter().write("Fail, make selection");
					response.flushBuffer();
				}else {
				
					response.setContentType("text/html");
					response.getWriter().write("success, data received");
					response.flushBuffer();
				}
			}
		}
		
		
		
		// get the operation, used for the JQuery/ajax
    	String operation = request.getParameter("operation");
    	if(operation != null) {
    		System.out.println("\nOperation not null\n");
	    	if(operation.equals("teamlisting")) {
	    		try {
					ArrayList<Group> grplist = db.getallGroups();
					Gson json = new Gson();
					String list = json.toJson(grplist);
					response.setContentType("text/html");
					response.getWriter().write(list);
					response.flushBuffer();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	}
	    	
	    	if(operation.equals("teamtech")) {
	    		String groupid = request.getParameter("id");
	    		System.out.println("groupid:: " + groupid);
	    		try {
					ArrayList<Employee> emplist = db.getEmployeeforGroup(groupid);
					Gson json = new Gson();
					String sempslist = json.toJson(emplist);
					response.setContentType("text/html");
					response.getWriter().write(sempslist);
					response.flushBuffer();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
    	}
    	
    	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
