/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.data.Group;

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
		boolean ok = false;
		
		String sql_insert = "insert into TeamGroups(name, email) value(?,?)";
		
		PreparedStatement ps = conn.prepareStatement(sql_insert);
		ps.setString(1, g.getName() );
		ps.setString(2, g.getEmail());
					
		
		ok = ps.executeUpdate() > 0;
		
		return ok;
	}
	
	
	public ArrayList<Group> getAllGroups()throws SQLException{
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

}
