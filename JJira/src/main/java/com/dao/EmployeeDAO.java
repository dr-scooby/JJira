/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.data.Bug;
import com.data.Employee;
import com.data.Ticket;

/**
 * @author nurali
 *
 */
public class EmployeeDAO extends DAO{

	protected Employee emp;
	
	
	
	public EmployeeDAO() {
		super();
		System.out.println("EmployeeDAO() constructor");
		//checkTable(); // hmmm... this method is called, but doesn't do anything in initializing
	}
	
	
	public boolean addNewEmployee(String fname, String lname, String email)throws SQLException {
		boolean ok = false;
		// call super tableExists
//		if(tableExists(IEmployee.EMPLOYEE_TABLE)) {
//			System.out.println("Table employee exists");
//		}else {
//			System.out.println("Table employee NOT exists...creating..");
//			//String create = IEmployee.create_table;
//			creatTable(IEmployee.create_table);
//		}
		checkTable();
		
		String sql_insert = "insert into employees(fname, lname,email) value(?,?,?)";
		
		
			PreparedStatement ps = conn.prepareStatement(sql_insert);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);			
			
			ok = ps.executeUpdate() > 0;		
		
		return ok;
	}
	
	
	// update the employee with new info
	public boolean updateEmployee(String id, String fname, String lname, String phone, String email) throws SQLException {
		checkTable();
		
		boolean ok = false;
		
		String sql = "update employees set fname=?, lname=?, phone=?, email=? where id=?";
		
		PreparedStatement pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pst.setString(1, fname); // set title
		pst.setString(2, lname); // description
		pst.setString(3, phone);
		pst.setString(4, email);
		pst.setInt(5, Integer.parseInt(id));
		ok = pst.executeUpdate() > 0;
		
		if(ok) {
			System.out.println("updated Employee.");
		}else {
			System.out.println("FAILED update Employee .");
		}
		return ok;
	}
	
	// get all Employees in the DB
	public ArrayList<Employee> getAllEmployees()throws SQLException{
		checkTable();
		
		ArrayList<Employee> emps = new ArrayList<Employee>();
		
		String sql = "select * from employees";
		String sql_getTeam = "select TeamGroups.name, employees.fname from TeamGroups\r\n"
				+ "inner join EmpType on TeamGroups.id = EmpType.groupid\r\n"
				+ "inner join employees on EmpType.empid = employees.id\r\n"
				+ "where employees.id = ?; ";
		PreparedStatement pst2 ;
		Connection conn2 = conn;
		
		
		
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			String fname = rs.getString("fname");
			String lname = rs.getString("lname");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			int id = rs.getInt("id");
			Employee em = new Employee();
			em.setFname(fname);
			em.setLname(lname);
			em.setEmail(email);
			em.setPhone(phone);
			em.setId(id);
			getGroup(em); // get the group this employee belongs to
//			pst2 = conn2.prepareStatement(sql_getTeam, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//			pst2.setInt(1, id);
//			ResultSet rs2 = pst2.executeQuery();
//			while(rs2.next()) {
//				String groupname = rs2.getString(1);
//				em.setGroup(groupname);
//			}
			
			emps.add(em);
			System.out.println("Emp from DB:: " + em);
		}
		
		System.out.println("Size of ArrayList:: " + emps.size());
		
		return emps;
	}
	
	// get a listing of employees not assigned to a Group/TEam
	public ArrayList<Employee> getUnassignedEmployees()throws SQLException{
		checkTable();
		ArrayList<Employee> emps = new ArrayList<Employee>();
		
		// get a listing of employees who are not assigned to a team
		String sql = "select  employees.id,employees.fname, employees.lname,employees.email, employees.phone from employees\r\n"
				+ "where employees.id not in (\r\n"
				+ "select EmpType.empid from EmpType)";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			String fname = rs.getString("fname");
			String lname = rs.getString("lname");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			//int teamid = rs.getInt("teamid");
			int id = rs.getInt("id");
			Employee em = new Employee();
			em.setFname(fname);
			em.setLname(lname);
			em.setEmail(email);
			em.setPhone(phone);
			em.setId(id);
			//em.setTeamid(teamid);
			emps.add(em);
		}
		
		
		return emps;
	}
	
	// get the Employee 
	public Employee getEmployee(String id)throws SQLException{
		checkTable();
		String sql = "select * from employees where id=?";
		Employee emp = null;
		/* 
		 * SQLException - if a database access error occurs; this method is called 
 		 *	on a closed result set or the result set type is TYPE_FORWARD_ONLY.
 		 * So, set the ResultSet.TYPE_SCROLL_INSENSITIVE so that rs.beforeFirst() can be called.
		 */
		PreparedStatement pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pst.setInt(1, Integer.parseInt(id));
		
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			String fname = rs.getString("fname");
			String lname = rs.getString("lname");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			int empid = rs.getInt("id");
			
			emp = new Employee();
			emp.setFname(fname);
			emp.setLname(lname);
			emp.setEmail(email);
			emp.setPhone(phone);
			emp.setId(empid);
			getGroup(emp); // get the group this employee belongs to
		}
		
		
		return emp;
	}
	
	// add employees to team
	// need Team ID and employee id's
	public void addEmployeestoTeam(String teamid, String[] empids) {
		checkTable();
		int teamidint = Integer.parseInt(teamid);
		
		String sql = "insert into EmpType(groupid, empid) values(?,?)";
		
		PreparedStatement pst;
		try {
			conn.setAutoCommit(false);
			pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			// add rows to the a batch in a loop. each iteration adds a new row
			for(int i=0; i < empids.length; i++) {
				pst.setInt(1, teamidint);
				pst.setInt(2, Integer.parseInt(empids[i]));
				// add row to the batch
				pst.addBatch();
			}
			
			// batch ready, execute it to insert data
			pst.executeBatch();
			
			// commit transaction
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// get the Group/Team this employee belongs to
	private void getGroup(Employee emp) {
		checkTable();
		
		String sql_getTeam = "select TeamGroups.name, employees.fname from TeamGroups\r\n"
				+ "inner join EmpType on TeamGroups.id = EmpType.groupid\r\n"
				+ "inner join employees on EmpType.empid = employees.id\r\n"
				+ "where employees.id = ?; ";
		
		PreparedStatement pst2 ;
		Connection conn2 = conn;
		
		try {
			pst2 = conn2.prepareStatement(sql_getTeam, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			pst2.setInt(1, emp.getId());
			ResultSet rs2 = pst2.executeQuery();
			while(rs2.next()) {
				String groupname = rs2.getString(1);
				emp.setGroup(groupname);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	/**
	 * Drop table from DB
	 * @param t String name of table
	 * @throws SQLException
	 */
	public void dropTable(String t)throws SQLException {
		//connect();
		
		try {
			Statement st = conn.createStatement();
			st.execute("drop table " + t);
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	// check if table exists
	private void checkTable() {
		System.out.println("checkTable()");
		
		// call super tableExists
			try {
				if(tableExists(IEmployee.EMPLOYEE_TABLE)) {
					System.out.println("Table employee exists");
				}else {
					System.out.println("Table employee NOT exists...creating..");
					//String create = IEmployee.create_table;
					createTable(IEmployee.create_employee_table);
				}
				
				if(tableExists(ITeam.TABLE_TEAM)) {
					System.out.println("Table Team exists");
				}else {
					createTable(ITeam.create_table_Team);
				}
				
				if(tableExists(IEmployee.EMP_TYPE_TABLE)) {
					System.out.println("Table Emp Type exists");
				}else {
					System.out.println("Table EmpType NOT exists...creating..");
					createTable(IEmployee.create_emptype_table);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		conn = c;
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


	@Override
	public boolean addBug(Bug b) {
		// TODO Auto-generated method stub
		return false;
	}

}
