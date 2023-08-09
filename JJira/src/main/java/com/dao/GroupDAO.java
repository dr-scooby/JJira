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
import com.data.Group;
import com.data.Ticket;

/**
 * @author nurali
 *
 */
public class GroupDAO extends DAO{
	
	protected Group group;
	
	
	
	public GroupDAO(){
		super();
	}
	
	
	public GroupDAO(Connection c){
		super();
		conn = c;
	}
	
	
	// add new Group
	public boolean addGroup(Group g) throws SQLException{
		checkTable();
		
		boolean ok = false;
		
		String sql_insert = "insert into TeamGroups(name, email) value(?,?)";
		
		PreparedStatement ps = conn.prepareStatement(sql_insert);
		ps.setString(1, g.getName() );
		ps.setString(2, g.getEmail());
					
		
		ok = ps.executeUpdate() > 0;
		
		return ok;
	}
	
	
	public ArrayList<Group> getAllGroups()throws SQLException{
		checkTable();
		System.out.println("getting all Groups in DAO");
		
		ArrayList<Group> grps = new ArrayList<Group>();
		
	
		
		String sql = "select * from TeamGroups";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println("inside RS");
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String email = rs.getNString("email");
			System.out.println(name + "  " + email);
			Group gp = new Group(name, email);			
			gp.setId(id);
			
			System.out.println("Group :: " + gp);
			grps.add(gp);
		}
		
		return grps;
	}
	
	// get by ID
	public Group getGroup(String id)throws SQLException {
		checkTable();
		
		System.out.println("DAO getting group id:" + id);
		
		String sql = "select * from TeamGroups where id=?";
		Group grp = null;
		PreparedStatement ps;
		
		/* 
		 * SQLException - if a database access error occurs; this method is called 
 		 *	on a closed result set or the result set type is TYPE_FORWARD_ONLY.
 		 * So, set the ResultSet.TYPE_SCROLL_INSENSITIVE so that rs.beforeFirst() can be called.
		 */
		ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ps.setInt(1, Integer.parseInt(id)); 
		
		
		ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				
				
				int bid = rs.getInt("id");
				grp = new Group();
				grp.setId(bid);
				grp.setName(name);
				grp.setEmail(email);
//				bug = new Bug();
//				bug.setName(nameresult);
//				bug.setDescription(descr);
//				bug.setState(stateresult);
//				bug.setSeverity(sev);
//				bug.setId(bid);
//				bug.setDate_created_at(date);
//				bug.setId(bid);
			}
			
			// get Employees for this group
			String sql_emps = "select TeamGroups.name, employees.fname, employees.lname, employees.email, employees.id from TeamGroups\r\n"
					+ "inner join EmpType on TeamGroups.id = EmpType.groupid \r\n"
					+ "inner join employees on EmpType.empid = employees.id\r\n"
					+ "where TeamGroups.id = ?";
			
			ps = conn.prepareStatement(sql_emps, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setInt(1, Integer.parseInt(id)); 
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				// get DB data
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String email = rs.getString("email");
				int i = rs.getInt("id");
				// make the employee object
				Employee emp = new Employee();
				emp.setId(i);
				emp.setFname(fname);
				emp.setLname(lname);
				emp.setEmail(email);
				grp.addEmployee(emp); // add employee to the Group
			}
			
		return grp;
	}
	
	// update the group with new info
	public boolean updateGroup(String id, String name, String email)throws SQLException {
		checkTable();
		
		boolean ok = false;
		
		String sql = "update TeamGroups set name=?, email=? where id=?";
		
		PreparedStatement pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pst.setString(1, name); // set title
		pst.setString(2, email); // summary
		pst.setInt(3, Integer.parseInt(id));
		
		ok = pst.executeUpdate() > 0;
		
		return ok;
	}
	
	
	// check if table exists
		private void checkTable() {
			System.out.println("checkTable()");
			
			try {
				if(tableExists(IGroup.Group_table_name)) {
					System.out.println("Table Group exists");
				}else {
					createTable(IGroup.create_table_Group);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	/* --- Abstract methods --- */

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
		conn = c; 
		
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
	public ArrayList<Ticket> getAllTickets() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<Ticket> findTitle(String s) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Ticket getTicket(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean addTicketNotes(String id, String notes) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean updateTicket(String id, String title, String summary, String sev, String state) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addTicketNotes(int id, String notes) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean anewTicket(String title, String summary, String notes, int severity, String state)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
