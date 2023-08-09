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
import com.data.Employee;
import com.data.Ticket;
import com.data.TicketNotes;

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
	
	// add a new Ticket to the DB
	public boolean anewTicket(String title, String summary, String notes, int severity, String state) throws SQLException{
		boolean ok = false;
		
		String sql_insert = "insert into tickets(title, summary,notes, severity, state) value(?,?,?,?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql_insert);
		ps.setString(1, title);
		ps.setString(2, summary);
		ps.setString(3, notes);
		ps.setInt(4, severity);
		ps.setString(5, state);
		
		ok = ps.executeUpdate() > 0;
		
		return ok;
	}
	
	// search Ticket by Title
	public ArrayList<Ticket> findTitle(String s){
		checkTable();
		
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
					String state = rs.getString("state");
					
					Ticket tik = new Ticket(id, title, summary, notes, date);
					tik.setSeverity(sev);
					tik.setState(state);
					tiks.add(tik);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tiks;
	}
	
	public ArrayList<Ticket> getAllTickets() throws SQLException{
		checkTable();
		
		ArrayList<Ticket> tiks = new ArrayList<Ticket>();
		
		System.out.println("getting all Tickets from BUGDAO");
		
		
		String sql_all = "select * from tickets";
		
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
		
		
		
		return tiks;
	}
	
	// get ticket from the id
	public Ticket getTicket(int id) throws SQLException {
		checkTable();
		
		Ticket tik = null;
		
		System.out.println("Ticket ID: " + id);
		
		String sql_search = "select * from tickets where id=?";
		
		//PreparedStatement pstate = conn.prepareStatement(sql_search);
		/* 
		 * SQLException - if a database access error occurs; this method is called 
 		 *	on a closed result set or the result set type is TYPE_FORWARD_ONLY.
 		 * So, set the ResultSet.TYPE_SCROLL_INSENSITIVE so that rs.beforeFirst() can be called.
		 */
		PreparedStatement pstate = conn.prepareStatement(sql_search, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pstate.setInt(1, id); // exact match
		ResultSet rs = pstate.executeQuery(); // execute query
		while(rs.next()) {
			String title = rs.getString("title");
			String summary = rs.getString("summary");
			String notes = rs.getString("notes");
			int xid = rs.getInt("id");
			int sev = rs.getInt("severity");
			String state = rs.getString("state");
			String date = rs.getString("created_at");
			tik = new Ticket();
			tik.setId(xid);
			tik.setTitle(title);
			tik.setSummary(summary);
			tik.setNotes(notes);
			tik.setSeverity(sev);
			tik.setState(state);
			tik.setDate(date);
			
		}
		
		// SQL query to get the ticket logs
		String sql_tiklog = "select tickets.title, ticketlog.log, ticketlog.datecreated, ticketlog.logid from tickets\r\n"
				+ "inner join ticketlog on tickets.id = ticketlog.ticketid\r\n"
				+ "where tickets.id = ?;";
		
		
		pstate = conn.prepareStatement(sql_tiklog, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pstate.setInt(1, id); // exact match
		rs = pstate.executeQuery(); // execute query
		while(rs.next()) {
			TicketNotes tiknotes = new TicketNotes();
			String lognotes = rs.getString("log");
			System.out.println(lognotes);
			String datecreated = rs.getString("datecreated");
			int logid = rs.getInt("logid");
			tiknotes.setNotes(lognotes);
			tiknotes.setDatecreated(datecreated);
			tiknotes.setTicketid(id);
			tiknotes.setLogid(logid);
			tik.addTicketNote(tiknotes);
		}
		
		
		
				
		return tik;
	}
	
	// add Notes, need ID - String
	public boolean addTicketNotes(String id, String notes)  throws SQLException {
		checkTable();
		
		boolean ok = false;
		
		String sql = "insert into ticketlog(ticketid, log) values(?,?)";
		
		PreparedStatement pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pst.setInt(1, Integer.parseInt(id)); // convert the String to Int
		pst.setString(2, notes);
		ok = pst.executeUpdate() > 0;
		
		
		return ok;
	}
	
	// add Notes, need ID - int. Method overload
	public boolean addTicketNotes(int id, String notes)  throws SQLException {
		checkTable();
		boolean ok = false;
		
		String sql = "insert into ticketlog(ticketid, log) values(?,?)";
		
		PreparedStatement pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pst.setInt(1, id); 
		pst.setString(2, notes);
		ok = pst.executeUpdate() > 0;
		
		
		return ok;
	}
	
	// update ticket with the info
	public boolean updateTicket(String id, String title, String summary, String sev, String state) throws SQLException {
		checkTable();
		boolean ok = false;
		
		String sql = "update tickets set title=?, summary=?, severity=?, state=? where id=?";
		
		PreparedStatement pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pst.setString(1, title); // set title
		pst.setString(2, summary); // summary
		pst.setString(3, sev);
		pst.setString(4, state);
		pst.setInt(5, Integer.parseInt(id));
		
		ok = pst.executeUpdate() > 0;
		
		return ok;
	}

	@Override
	public void connection(Connection c) throws SQLException {
		// TODO Auto-generated method stub
		// get a handle to the Connection
		conn = c;
	}
	
	
	private void checkTable() {
		System.out.println("checkTable()");
		
		try {
			if(tableExists(ITicket.table_name_Ticket)) {
				System.out.println("Ticket table exists");
			}else {
				createTable(ITicket.create_table_Ticket);
			}
			
			if(tableExists(ITicket.table_name_TicketLog)) {
				System.out.println("TicketLog exists");
			}else {
				createTable(ITicket.create_table_TicketLog);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean addNewEmployee(String fname, String lname, String email) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Employee> getAllEmployees() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Bug> getAllBugs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Employee> getUnassignedEmployees() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addBug(Bug b) {
		// TODO Auto-generated method stub
		return false;
	}

}
