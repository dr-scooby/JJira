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
import com.data.BugNotes;

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
	
	
	public BugDAO(Connection c) {
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
	
	// find bug based on description
	public ArrayList<Bug> findBugDescription(String description){
		System.out.println("findbug in BugDAO");
		
		String sql_find = "select * from Bugs where description like ? ";
		ArrayList<Bug> bugs = new ArrayList<Bug>();
		
		PreparedStatement ps;
		try {
			/* 
			 * SQLException - if a database access error occurs; this method is called 
     		 *	on a closed result set or the result set type is TYPE_FORWARD_ONLY.
     		 * So, set the ResultSet.TYPE_SCROLL_INSENSITIVE so that rs.beforeFirst() can be called.
			 */
			ps = conn.prepareStatement(sql_find, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, "%" + description + "%"); // want to use the wild character %
			
			
			
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
	
	// find bug based on name or description
	public ArrayList<Bug> findBug(String name, String description){
		System.out.println("findbug in BugDAO");
		
		String sql_find = "select * from Bugs where name like ? or description like ? ";
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
	
	// get all bugs, list all
	public ArrayList<Bug> getAllBugs() {
		System.out.println("getting all bugs from BUGDAO");
		
		ArrayList<Bug> allb = new ArrayList<Bug>();
		Bug b;
		String sql_all = "select * from Bugs";
		try {
		PreparedStatement ps = conn.prepareStatement(sql_all);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String name = rs.getString("name");
			String description = rs.getString("description");
			int severity = rs.getInt("severity");
			String state = rs.getString("state");
			int id = rs.getInt("id");
			String date = rs.getString("created_at");
			b = new Bug(id, name, description);
			b.setSeverity(severity);
			b.setState(state);
			b.setDate_created_at(date);
			allb.add(b);
		}
		}catch(SQLException s) {
			System.err.println(s);
		}
		
		
		
		return allb;
	}
	
	
	// get a Bug from the ID
	public Bug getBug(String id) {
		String sql = "select * from Bugs where id=?";
		Bug bug = null;
		PreparedStatement ps;
		try {
			/* 
			 * SQLException - if a database access error occurs; this method is called 
     		 *	on a closed result set or the result set type is TYPE_FORWARD_ONLY.
     		 * So, set the ResultSet.TYPE_SCROLL_INSENSITIVE so that rs.beforeFirst() can be called.
			 */
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setInt(1, Integer.parseInt(id)); 
			
			
			ResultSet rs = ps.executeQuery();
			
				while(rs.next()) {
					String nameresult = rs.getString("name");
					String descr = rs.getString("description");
					String stateresult = rs.getString("state");
					int sev = rs.getInt("severity");
					String date = rs.getString("created_at");
					int bid = rs.getInt("id");
					bug = new Bug();
					bug.setName(nameresult);
					bug.setDescription(descr);
					bug.setState(stateresult);
					bug.setSeverity(sev);
					bug.setId(bid);
					bug.setDate_created_at(date);
					bug.setId(bid);
				}
				
				// SQL query to get the Bug logs
				String sql_buglog = "select Bugs.id, BugLog.bugid, Bugs.name, BugLog.notes, BugLog.created_at, BugLog.logid from Bugs\r\n"
						+ "inner join BugLog on Bugs.id = BugLog.bugid \r\n"
						+ "where Bugs.id = ?;";
				
				PreparedStatement ps2 = conn.prepareStatement(sql_buglog, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ps2.setInt(1, Integer.parseInt(id)); // exact match
				if(ps2.isClosed()) {
					System.out.println("PS is closed");
				}else {
					System.out.println("PS NOT closed, Open");
				}
				ResultSet rs2 = ps2.executeQuery(); // execute query
				if(rs2.first()) {
					System.out.println("first");
				}
				if(rs2.isClosed()) {
					System.out.println("closed");
				}
				rs2.beforeFirst();
				while(rs2.next()) {
					System.out.println("inside RS...");
					BugNotes bun = new BugNotes(); // make a BugNotes object
					// get data from the DB, and set to BugNotes
					String notes = rs2.getString("notes");
					System.out.println("Notes: " + notes);
					bun.setLog(notes);
					String datecreated = rs2.getString("created_at");
					bun.setDate_created(datecreated);
					bun.setBugid(rs2.getInt("id"));
					bun.setLogid(rs2.getInt("logid"));
					System.out.println("BugNotes:: " + bun);
					bug.addBugNote(bun); // add it to the Bug
					System.out.println("Bug DB: "+ bug);
				}
				System.out.println("done");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return bug;
	}
	
	// add notes to the Bug
	public boolean addBugNotes(String id, String notes) throws SQLException {
		boolean ok = false;
		
		String sql = "insert into BugLog(bugid, notes) values(?,?)";
		
		PreparedStatement pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pst.setInt(1, Integer.parseInt(id)); // convert the String to Int
		pst.setString(2, notes);
		ok = pst.executeUpdate() > 0;
		
		return ok;
	}

	@Override
	public void connection(Connection c) throws SQLException {
		// TODO Auto-generated method stub
		// get a handle to the Connection
		conn = c;
		
	}

}
