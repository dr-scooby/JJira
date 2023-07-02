/**
 * 
 */
package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
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
	private static final String DBNAME = "MGWDB";
	private String dburl = "jdbc:mysql://194.168.2.69:3306/"+DBNAME;
	private String dbuser = "nurali";
	private String dbpass = "java1973";
	
	private Connection conn; // connection to DB
	private Connection tempconn ; // a temp conn to be used as secondary
	
	
	
	// DEFAULT CONSTRUCTOR
	public DBModel() {
		System.out.println("init DBModel..");		
	}

	
	// connect to DB
	public void connect() throws SQLException{
		System.out.println("\nconnect called...");
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver"); // new mysql driver version
			Class.forName("com.mysql.jdbc.Driver"); // old mysql driver version
			conn = DriverManager.getConnection(dburl, dbuser, dbpass);
			tempconn = DriverManager.getConnection(dburl, dbuser, dbpass);
		}catch(ClassNotFoundException e) {
			System.err.println(e);
		}
	}
	
	
	// get a Connection
	public Connection getConnection() {
		return conn;
	}
	
	public String getDBName() {
		return DBNAME;
	}
}
