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
	
	public ArrayList<Employee> getAllEmployees()throws SQLException{
		
		ArrayList<Employee> emps = new ArrayList<Employee>();
		
		String sql = "select * from employees";
		
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
			emps.add(em);
		}
		
		return emps;
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
