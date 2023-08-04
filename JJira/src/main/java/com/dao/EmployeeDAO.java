/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.data.Employee;

/**
 * @author nurali
 *
 */
public class EmployeeDAO extends DAO{

	protected Employee emp;
	
	
	
	public EmployeeDAO() {
		super();
	}
	
	
	public boolean addNewEmployee(String fname, String lname, String email)throws SQLException {
		boolean ok = false;
		
		String sql_insert = "insert into employees(fname, lname,email) value(?,?,?)";
		
		
			PreparedStatement ps = conn.prepareStatement(sql_insert);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			
			
			ok = ps.executeUpdate() > 0;
			
		
		
		return ok;
	}
	
	
	// get all Employees in the DB
	public ArrayList<Employee> getAllEmployees()throws SQLException{
		
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
			getGroup(em);
//			pst2 = conn2.prepareStatement(sql_getTeam, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//			pst2.setInt(1, id);
//			ResultSet rs2 = pst2.executeQuery();
//			while(rs2.next()) {
//				String groupname = rs2.getString(1);
//				em.setGroup(groupname);
//			}
			
			emps.add(em);
		}
		
		return emps;
	}
	
	// get a listing of employees not assigned to a Group/TEam
	public ArrayList<Employee> getUnassignedEmployees()throws SQLException{
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
			getGroup(emp);
		}
		
		
		return emp;
	}
	
	// add employees to team
	// need Team ID and employee id's
	public void addEmployeestoTeam(String teamid, String[] empids) {
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
	
	
	private void getGroup(Employee emp) {
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

}
