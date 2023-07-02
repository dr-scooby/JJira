/**
 * 
 */
package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	private String dburl = "jdbc:mysql://194.168.2.69:3306/"+DBNAME;
	private String dbuser = "nurali";
	private String dbpass = "java1973";
	
	private Connection conn; // connection to DB
	private Connection tempconn ; // a temp conn to be used as secondary
	
	
	
	// DEFAULT CONSTRUCTOR
	public DBModel() {
		System.out.println("init DBModel..");	
		try {
			connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	// create a new ticket
	public boolean anewTicket(String title, String summary, String notes, int severity) {
		System.out.println("\n a New ticket called in DBModel..");
		boolean ok = false;
		
		String sql_insert = "insert into tickets(title, summary,notes, severity) value(?,?,?,?)";
		
		if(conn == null) {
			try {
				connect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql_insert);
			ps.setString(1, title);
			ps.setString(2, summary);
			ps.setString(3, notes);
			ps.setInt(4, severity);
			
			ok = ps.executeUpdate() > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ok;
	}
	
	// get a Connection
	public Connection getConnection() {
		return conn;
	}
	
	public String getDBName() {
		return DBNAME;
	}
}
