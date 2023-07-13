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
	
	
	// search Ticket by Title
	public ArrayList<Ticket> findTitle(String s){
		ArrayList<Ticket> tiks = new ArrayList<Ticket>();
		
		System.out.println("finding all Tickets from BUGDAO using " + s);
		
		String sql_search = "select * from tickets where title like ?";
		
		PreparedStatement ps;
		try {
			/* 
			 * SQLException - if a database access error occurs; this method is called 
     		 *	on a closed result set or the result set type is TYPE_FORWARD_ONLY.
     		 * So, set the ResultSet.TYPE_SCROLL_INSENSITIVE so that rs.beforeFirst() can be called.
			 */
			ps = conn.prepareStatement(sql_search, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, "%" + s + "%"); // want to use the wild character %
						
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {//check if we get any results
				rs.beforeFirst(); // move the rs before the first
				while(rs.next()) {
					String title = rs.getString("title");
					String summary = rs.getString("summary");
					String notes = rs.getString("notes");
					int id = rs.getInt("id");
					String date = rs.getString("created_at");
					int sev = rs.getInt("severity");
					
					Ticket tik = new Ticket(id, title, summary, notes, date);
					tik.setSeverity(sev);
					tiks.add(tik);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tiks;
	}
	
	public ArrayList<Ticket> getAllTickets(){
		ArrayList<Ticket> tiks = new ArrayList<Ticket>();
		
		System.out.println("getting all Tickets from BUGDAO");
		
		
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
