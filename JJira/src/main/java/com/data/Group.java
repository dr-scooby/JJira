/**
 * 
 */
package com.data;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author nurali
 *
 */
public class Group {
	
	private int id;
	private String name;
	private ArrayList members;
	
	
	
	public Group() {
		id = 0;
		name = "";
		members = new ArrayList();
	}
	
	
	public Group(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the members
	 */
	public ArrayList getMembers() {
		return members;
	}


	/**
	 * @param members the members to set
	 */
	public void setMembers(ArrayList members) {
		this.members = members;
	}

	public Iterator getIt() {
		return members.iterator();
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + "]";
	}
	
	
	
	

}
