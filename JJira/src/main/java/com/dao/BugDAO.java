/**
 * PROJECT JJIRA
 */
package com.dao;

import java.sql.Connection;
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


	@Override
	public void connection(Connection c) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
