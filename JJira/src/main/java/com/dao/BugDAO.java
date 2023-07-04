/**
 * PROJECT JJIRA
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.data.Bug;

/**
 * @author nurali
 *
 */
public class BugDAO extends DAO{
	
	protected Bug abug;
	
	protected String createTable = "create table Bugs(id int primary key auto_increment, name varchar(50), description varchar(50), severity int, state varchar(15))";
	
	
	
	
	public BugDAO() {
		super();
	}
	
	
	

	@Override
	public void create() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createTable() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	
	// add a Bug to the DB
	public boolean addBug(Bug b) {
		boolean ok = false;
		
		String sql_insert = "insert into Bugs(name, description ,state, severity) value(?,?,?,?)";
		
//		if(conn == null) {
//			try {
//				connect();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql_insert);
			ps.setString(1, b.getName());
			ps.setString(2, b.getDescription());
			ps.setString(3, b.getState());
			ps.setInt(4, b.getSeverity());
			
			ok = ps.executeUpdate() > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ok;
	}

	@Override
	public void connection(Connection c) throws SQLException {
		// TODO Auto-generated method stub
		// get a handle to the Connection
		conn = c;
		
	}

}
