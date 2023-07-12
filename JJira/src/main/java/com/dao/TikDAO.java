/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.data.Bug;
import com.data.Ticket;

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
	
	
	public ArrayList<Ticket> getAllTickets(){
		ArrayList<Ticket> tiks = new ArrayList<Ticket>();
		
		System.out.println("getting all bugs from BUGDAO");
		
		
		String sql_all = "select * from tickets";
		try {
			PreparedStatement ps = conn.prepareStatement(sql_all);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String summar = rs.getString("summary");
				String notes = rs.getString("notes");
				
				Ticket tik = new Ticket();
				tik.setId(id);
				tik.setTitle(title);
				tik.setSummary(summar);
				tik.setNotes(notes);
				
				tiks.add(tik);
		}
		}catch(SQLException s) {
			System.err.println(s);
		}
		
		
		return tiks;
	}

	@Override
	public void connection(Connection c) throws SQLException {
		// TODO Auto-generated method stub
		// get a handle to the Connection
		conn = c;
	}

}
