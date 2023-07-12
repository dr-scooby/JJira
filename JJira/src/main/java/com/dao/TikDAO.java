/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author nurali
 *
 */
public class TikDAO extends DAO{
	
	
	
	public TikDAO() {
		super();
	}
	
	// get a Connection
	public TikDAO(Connection c) {
		super();
		conn = c;
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
		// get a handle to the Connection
		conn = c;
	}

}
