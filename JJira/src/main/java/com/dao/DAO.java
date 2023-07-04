
package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
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
