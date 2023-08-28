/**
 * 
 */
package com.DB;

import com.dao.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

//import javax.swing.text.html.HTMLDocument.Iterator;

import com.dao.BugDAO;
import com.dao.EmployeeDAO;
import com.dao.GroupDAO;
import com.dao.TikDAO;
import com.data.Bug;
import com.data.Employee;
import com.data.Group;
import com.data.Ticket;

/**
 * JIRA PROJECT
 * 
 * @author Dr.Scooby
 *
 */
public class DBModel {
	
	/* DB INFO 
	 * TESTING ONLY, MOVE TO PROPERTIES FILE 
	 * 
	 */
	private static final String DBNAME = "JiraDB";
	private String dburl = "jdbc:mysql://194.168.2.69:3306/";
	private String dbuser = "nurali";
	private String dbpass = "java1973";
	private String dbname ;
	
	private Connection conn; // connection to DB
	private Connection tempconn ; // a temp conn to be used as secondary
	
	
	
	// DEFAULT CONSTRUCTOR
	public DBModel() throws SQLException {
		System.out.println("init DBModel..");	
		
			dburl +=DBNAME;
			connect();
		
	}
	
	// get a DB user and password
	public DBModel(String user, String pass) throws SQLException {
		this.dbuser = user;
		this.dbpass = pass;
		dburl +=DBNAME;
		System.out.println("init DBModel..");	
		
			connect();
		
	}
	
	public DBModel(String dbname, String user, String pass) throws SQLException {
		this.dbname = dbname;
		this.dbuser = user;
		this.dbpass = pass;
		dburl += dbname;
		
		System.out.println("init DBModel..");	
		
			connect();
		
	}

	
	// connect to DB
	public void connect() throws SQLException{
		System.out.println("\nconnect called...");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // new mysql driver version
			//Class.forName("com.mysql.jdbc.Driver"); // old mysql driver version
			conn = DriverManager.getConnection(dburl, dbuser, dbpass);
			tempconn = DriverManager.getConnection(dburl, dbuser, dbpass);
		}catch(ClassNotFoundException e) {
			System.err.println(e);
		}
	}
	
	
	// add notes to the TicketLog
	public boolean addTicketNotes(String id, String notes)throws SQLException{
		boolean ok = false;
		
		if(conn == null || conn.isClosed()) {
			connect();
		}
		
		DAO tik = new TikDAO(conn);
		
		
		return ok = tik.addTicketNotes(id, notes);
	}
	
	// add notes to the TicketLog
	public boolean addTicketNotes(int id, String notes)throws SQLException{
		boolean ok = false;
		
		if(conn == null || conn.isClosed()) {
			connect();
		}
		
		DAO tik = new TikDAO(conn);
		
		
		return ok = tik.addTicketNotes(id, notes);
	}
	
	
	// assign a team and tech to ticket
	public boolean assignTeam(String teamid, String techid, String ticketid) throws SQLException {
		boolean ok = false;
		
		if(conn == null || conn.isClosed()) {
			connect();
		}
		
		TikDAO tik = new TikDAO(conn);
		ok = tik.assignTeam(teamid, techid, ticketid);
		
		
		return ok;
	}
	
	// update a ticket with new info
	public boolean updateTicket(String id, String title, String summary, String sev, String state) throws SQLException {
		boolean ok = false;
		
		connect();
		
		DAO tik = new TikDAO(conn);
		
		
		return ok = tik.updateTicket(id, title, summary, sev, state);
	}
	
	// create a new ticket
	public boolean anewTicket(String title, String summary, String notes, int severity, String state) throws SQLException {
		System.out.println("\n a New ticket called in DBModel..");
		boolean ok = false;
		
		//String sql_insert = "insert into tickets(title, summary,notes, severity, state) value(?,?,?,?, ?)";
		
		try {
			if(conn == null || conn.isClosed()) {
				try {
					connect();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//			PreparedStatement ps = conn.prepareStatement(sql_insert);
//			ps.setString(1, title);
//			ps.setString(2, summary);
//			ps.setString(3, notes);
//			ps.setInt(4, severity);
//			ps.setString(5, state);
//			
//			ok = ps.executeUpdate() > 0;
			
		DAO da = new TikDAO();
		da.connection(conn);
		ok = da.anewTicket(title, summary, notes, severity, state);
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ok;
	}
	
	
	// get a ticket from the id
	public Ticket getTicket(int id) throws SQLException {
		
		if(conn == null || conn.isClosed()) {
			connect();
		}
		
		DAO tdao = new TikDAO(conn);
		Ticket t = tdao.getTicket(id);
		
		return t;
	}
	
	
	// search ticket by title
	public ArrayList<Ticket> searchTicketTitle(String s) {
		
		System.out.println("Search Ticket Title: " + s);
		
		
		
		try {
			if(conn == null || conn.isClosed()) {
				try {
					connect();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TikDAO tikd = new TikDAO(conn);
		ArrayList<Ticket> tiks = tikd.findTitle(s);
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tiks;
		
	}
	
	// create new employee
	public boolean anewEmployee(String fname, String lname, String email) throws SQLException{
		boolean ok = false;
		
		System.out.println("\n a New Employee called in DBModel..");
		
		
		//String sql_insert = "insert into employees(fname, lname,email, phone) value(?,?,?,?)";
		
		try {
			if(conn == null || conn.isClosed()) {
				try {
					connect();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DAO dao = new EmployeeDAO();
		dao.connection(conn);
		ok = dao.addNewEmployee(fname, lname, email);
		
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql_insert);
//			ps.setString(1, fname);
//			ps.setString(2, lname);
//			ps.setString(3, email);
//			ps.setString(4, phone);
//			
//			ok = ps.executeUpdate() > 0;
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ok;
	}
	
	
	// get listing of employees
	public ArrayList<Employee> getAllEmployees() throws SQLException{
		System.out.println("DBModel getAllEmployees()");
		
		
			connect();
		
		
		DAO dd = new EmployeeDAO();
		dd.connection(conn);
		
		//EmployeeDAO dao = new EmployeeDAO();
		//dao.connection(conn);
		
		//return dao.getAllEmployees();
		return dd.getAllEmployees();
	}
	
	// get a listing of employees not assigned to a Group/TEam
	public ArrayList<Employee> getUnassignedEmployees()throws SQLException{
		
		if(conn == null || conn.isClosed()) {
			connect();
		}
		
		DAO dao = new EmployeeDAO();
		dao.connection(conn);
		
		ArrayList<Employee> emps = dao.getUnassignedEmployees();
		
		
		return emps;
		
		
	}
	
	// create a new bug
	public boolean anewBug(String name, String description, String severity, String state)throws SQLException {
		boolean ok = false;
		
		System.out.println("\n a New Bug called in DBModel..");
		int number = Integer.parseInt(severity);
	
				if(conn == null || conn.isClosed()) {
					
						connect();
						
					
				}
			
			
			Bug b = new Bug(name, description, number, state);
			DAO bd = new BugDAO();
			bd.connection(conn);
			if(bd.addBug(b)) {
				ok = true;
				System.out.println("success adding bug to DB");
			}
		
		

		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ok;
	}
	
	// get a listing of all bugs
	public ArrayList<Bug> listallBugs() throws SQLException{
		System.out.println("list all bugs called with:> "  );
		ArrayList<Bug> bugs = null;
						
		connect();	
		
		DAO bd  = new BugDAO();
	
		bd.connection(conn);
		
		bugs = bd.getAllBugs();
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bugs;
	}
	
	// add notes to the Bug
	public boolean addBugNotes(String id, String notes) throws SQLException {
		boolean ok = false;
		
		if(conn == null || conn.isClosed()) {
			connect();
		}
		
		BugDAO bd = new BugDAO(conn);
		
		
		return ok = bd.addBugNotes(id, notes);
	}
	
	// get a Bug from the ID
	public Bug getBug(String id) {
		System.out.println("DBModel getBug()..");
		
		try {
			if(conn == null || conn.isClosed()) {
				try {
					connect();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BugDAO bugd = new BugDAO(conn);
		return bugd.getBug(id);
	}
	
	// update the employee details
	public boolean updateEmployee(String id, String fname, String lname, String phone, String email) throws SQLException {
		boolean ok = false;
		
		if(conn == null || conn.isClosed()) {
			connect();
		}
		
		EmployeeDAO dao = new EmployeeDAO();
		dao.connection(conn);
		ok = dao.updateEmployee(id, fname, lname, phone, email);
		
		return ok;
	}
	
	//update Bug details
	public boolean updateBug(String id, String name, String description, String state, String sev) throws SQLException {
		boolean ok = false;

		try {
			if(conn == null || conn.isClosed()) {
				try {
					connect();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BugDAO bd = new BugDAO(conn);
		ok = bd.updateBug(id, name, description, state, sev);
		return ok;
	}
	
	// get all Tickets
	public ArrayList<Ticket> listallTickets()throws SQLException{
		System.out.println("listing all tickets from DBModel...");
		ArrayList<Ticket> tiks = null;
		
		
					connect();
					
				
		
		DAO tdao = new TikDAO(conn);
		tiks = tdao.getAllTickets();
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tiks;
				
	}
	
	// find description
	public ArrayList<Bug> searchBugDescription(String descr){
		System.out.println("searchBug called with:> " +  descr);
		ArrayList<Bug> bugs = null;
		
		try {
			if(conn == null || conn.isClosed()) {
				try {
					connect();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			BugDAO bd = new BugDAO();
			bd.connection(conn);
			 bugs   =  bd.findBugDescription(descr);
			if(bugs.isEmpty()) {
				System.out.println("Array Empty");
				bugs = new ArrayList<Bug>();
			}else {
				Iterator<Bug> it = bugs.iterator();
				while(it.hasNext()) {
					Bug b = (Bug)it.next();
					System.out.println(b);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bugs;
	}
	
	// name & descr
	public ArrayList<Bug> searchBug(String name, String descr){
		System.out.println("searchBug called with:> " + name + " " + descr);
		ArrayList<Bug> bugs = null;
		
		try {
			if(conn == null || conn.isClosed()) {
				try {
					connect();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			BugDAO bd = new BugDAO();
			bd.connection(conn);
			 bugs   =  bd.findBug(name, descr);
			if(bugs.isEmpty()) {
				System.out.println("Array Empty");
				bugs = new ArrayList<Bug>();
			}else {
				Iterator<Bug> it = bugs.iterator();
				while(it.hasNext()) {
					Bug b = (Bug)it.next();
					System.out.println(b);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bugs;
	}
	
	public ArrayList<Bug> searchBug(String name){
		System.out.println("searchBug called with:> " + name );
		ArrayList<Bug> bugs = null;
		
		try {
			if(conn == null || conn.isClosed()) {
				try {
					connect();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			BugDAO bd = new BugDAO();
			bd.connection(conn);
			 bugs   =  bd.findBug(name);
			if(bugs.isEmpty()) {
				System.out.println("Array Empty");
			}else {
				Iterator<Bug> it = bugs.iterator();
				while(it.hasNext()) {
					Bug b = (Bug)it.next();
					System.out.println(b);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bugs;
	}
	
	
	// find a bug based on info
	public ArrayList<Bug> searchBug(String name, String description,String state, int severity) {
		System.out.println("searchBug called with:> " + name + " " + description + " " + severity);
		ArrayList<Bug> bugs = null;
		
		try {
			if(conn == null || conn.isClosed()) {
				try {
					connect();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			BugDAO bd = new BugDAO();
			bd.connection(conn);
			 bugs   =  bd.findBug(name, description, state, severity);
			if(bugs.isEmpty()) {
				System.out.println("Array Empty");
			}else {
				Iterator<Bug> it = bugs.iterator();
				while(it.hasNext()) {
					Bug b = (Bug)it.next();
					System.out.println(b);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bugs;
		
	}
	
	
	// create a new Team Group
	public boolean anewTeam(String name, String email) throws SQLException {
		boolean ok = false;
		
		System.out.println("\n a New Team creation called in DBModel..");
		
		Group g = new Group(name, email);
		
		//String sql_insert = "insert into TeamGroups(name, email) value(?,?)";
		
		try {
			if(conn == null || conn.isClosed()) {
				try {
					connect();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// pass Group info the to the DAO
		GroupDAO gdo = new GroupDAO();
		gdo.connection(conn);
		gdo.addGroup(g);
		
		
		
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql_insert);
//			ps.setString(1, name);
//			ps.setString(2, email);
//						
//			
//			ok = ps.executeUpdate() > 0;
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ok;
	}
	
	
	// list all groups
	public ArrayList<Group> getallGroups() throws SQLException{
		ArrayList<Group> groups ;
		
		
			if(conn == null || conn.isClosed()) {
				try {
					connect();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		GroupDAO dao = new GroupDAO();
		dao.connection(conn);
		groups = dao.getAllGroups();
		System.out.println("Size of Groups:>> " + groups.size());
		return groups;
	}
	
	// get a Group from ID - String
	public Group getGroup(String id)throws SQLException {
		if(conn == null || conn.isClosed()) {
			connect();
		}
		
		GroupDAO dao = new GroupDAO();
		dao.connection(conn);
		return dao.getGroup(id);
		
	}
	
	// get Team member for the Group
	public ArrayList<Employee> getEmployeeforGroup(String groupid) throws SQLException{
		ArrayList<Employee> emps = null;
		
		if(conn == null || conn.isClosed()) {
			try {
				connect();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		GroupDAO dao = new GroupDAO();
		dao.connection(conn);
		emps = dao.getEmployeeforGroup(groupid);
		
		return emps;
	}
	
	// edit Group with new info
	public boolean editGroup(String id, String name, String email) throws SQLException {
		boolean ok = false;
		if(conn == null || conn.isClosed()) {
			connect();
		}
		GroupDAO dao = new GroupDAO();
		dao.connection(conn);
		ok = dao.updateGroup(id, name, email);
		
		return ok;
	}
	
	// get Employee by String id
	public Employee getEmployee(String id)throws SQLException{
		if(conn == null || conn.isClosed()) {
			connect();
		}
		
		EmployeeDAO dao = new EmployeeDAO();
		dao.connection(conn);
		
		return dao.getEmployee(id);
	}
	
	
	// add employees to team
	// need Team ID and employee id's
	public void addEmployeestoTeam(String teamid, String[] empids) throws SQLException{
		if(conn == null || conn.isClosed()) {
			connect();
		}
		
		EmployeeDAO dao = new EmployeeDAO();
		dao.connection(conn);
		
		dao.addEmployeestoTeam(teamid, empids);
		
		
	}
	
	// get a Connection
	public Connection getConnection() {
		return conn;
	}
	
	public String getDBName() {
		return DBNAME;
	}
}
