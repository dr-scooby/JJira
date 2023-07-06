/**
 * PROJECT JJIRA
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	
	public ArrayList<Bug> findBug(String name){
		System.out.println("findbug in BugDAO");
		ArrayList<Bug> bugs = new ArrayList<Bug>();
		
		String sql_find = "select * from Bugs where name like ?";
		
		PreparedStatement ps;
		try {
			/* 
			 * SQLException - if a database access error occurs; this method is called 
     		 *	on a closed result set or the result set type is TYPE_FORWARD_ONLY.
     		 * So, set the ResultSet.TYPE_SCROLL_INSENSITIVE so that rs.beforeFirst() can be called.
			 */
			ps = conn.prepareStatement(sql_find, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, "%" + name + "%"); // want to use the wild character %
			
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {//check if we get any results
				rs.beforeFirst(); // move the rs before the first
				while(rs.next()) {
					String nameresult = rs.getString("name");
					String descr = rs.getString("description");
					String stateresult = rs.getString("state");
					int sev = rs.getInt("severity");
					Bug bu = new Bug(nameresult, descr, stateresult , sev);
					bugs.add(bu);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bugs;
	}
	
	// find a bug
	public ArrayList<Bug> findBug(String name, String description, String state, int severity) {
		System.out.println("findbug in BugDAO");
		
		String sql_find = "select * from Bugs where name like ? or description like ? or state like ? or severity =?";
		ArrayList<Bug> bugs = new ArrayList<Bug>();
		
		PreparedStatement ps;
		try {
			/* 
			 * SQLException - if a database access error occurs; this method is called 
     		 *	on a closed result set or the result set type is TYPE_FORWARD_ONLY.
     		 * So, set the ResultSet.TYPE_SCROLL_INSENSITIVE so that rs.beforeFirst() can be called.
			 */
			ps = conn.prepareStatement(sql_find, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, "%" + name + "%"); // want to use the wild character %
			ps.setString(2, "%" + description + "%");
			ps.setString(3, state);
			ps.setInt(4, severity);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {//check if we get any results
				rs.beforeFirst(); // move the rs before the first
				while(rs.next()) {
					String nameresult = rs.getString("name");
					String descr = rs.getString("description");
					String stateresult = rs.getString("state");
					int sev = rs.getInt("severity");
					Bug bu = new Bug(nameresult, descr, stateresult , sev);
					bugs.add(bu);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bugs;
	}

	@Override
	public void connection(Connection c) throws SQLException {
		// TODO Auto-generated method stub
		// get a handle to the Connection
		conn = c;
		
	}

}
