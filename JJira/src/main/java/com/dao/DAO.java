
package com.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.data.Bug;
import com.data.Employee;
import com.data.Ticket;

/**
 * Project: JJira
 * 
 * @author nurali
 *
 */
public abstract class DAO {
	
	protected Connection conn; // connection to the Database
	
	protected String tablename;
	
	protected String sql_create_table;
	
	
	// Default Constructor
	public DAO() {
		tablename = "";
		sql_create_table = "";
	}
	
	public DAO(String t) {
		this();
		tablename = t;
		
		
	}
	
	
	/**
	 * Check if table exists
	 * @param targetTableName String
	 * @return boolean true if exists, false if doens't exist
	 * @throws SQLException
	 */
	public boolean tableExists(String targetTableName) throws SQLException {
		DatabaseMetaData databaseMetaData = conn.getMetaData();
		ResultSet resultSet = null;
		String tableName = null;

		try {
			resultSet = databaseMetaData.getTables(conn.getCatalog(), "%", "%", null);
			while (resultSet.next()) {
				tableName = resultSet.getString("TABLE_NAME");
				if (tableName.equalsIgnoreCase(targetTableName)) {
					return true;
				}
			}
		} finally {
			resultSet.close();
		}

		return false;
	}
	
	
	/**
	 * create a table
	 * @param sql String
	 */
	public void createTable(String sql) {
		//System.out.println("\nDatabase.createTable() called..\n");
		//connect(); // connect to DB, may have been closed
		
		try {
			Statement state = conn.createStatement();
			state.executeUpdate(sql) ;
				//System.out.println("Create Table success :> " + sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// -- abstract methods --
	public abstract boolean addNewEmployee(String fname, String lname, String email)throws SQLException;
	
	public abstract ArrayList<Employee> getAllEmployees()throws SQLException;
	
	public abstract ArrayList<Bug> getAllBugs()throws SQLException;
	
	public abstract ArrayList<Ticket> getAllTickets()throws SQLException;
	
	public abstract ArrayList<Ticket> findTitle(String s);
	
	public abstract Ticket getTicket(int id) throws SQLException;
	
	public abstract boolean addTicketNotes(String id, String notes)  throws SQLException;
	
	public abstract boolean addTicketNotes(int id, String notes)  throws SQLException ;
	
	public abstract boolean anewTicket(String title, String summary, String notes, int severity, String state) throws SQLException;
	
	public abstract boolean updateTicket(String id, String title, String summary, String sev, String state) throws SQLException;
	
	public abstract void create() throws SQLException ;
	
	public abstract void createTable() throws SQLException ;
	
	public abstract boolean add() throws SQLException;
	
	public abstract void connection(Connection c) throws SQLException;
	
	public Connection getConnect() {
		return conn;
	}
	
	public void setTable(String t) {
		this.tablename = t;
	}

}
