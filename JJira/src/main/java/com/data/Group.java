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
	private String email;
	
	
	
	
	public Group() {
		id = 0;
		name = "";
		
	}
	
	public Group(String name) {
		this();
		this.name = name;
	}
	
	public Group(String name, String email) {
		this();
		this.name = name;
		this.email = email;
	}
	
	public Group(int id, String name) {
		this();
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


	

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + "]";
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
