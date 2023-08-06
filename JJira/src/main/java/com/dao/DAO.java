
package com.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
