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
public class Bug {
	
	private int id;
	private String name;
	private String description;
	private String date_created_at;
	private String date_updated_at;
	private String state;
	
	private int severity;
	private ArrayList<BugNotes> bugnotes;
	
	
	public Bug() {
		id = 0;
		name = "";
		date_created_at = "";
		date_updated_at = "";
		state = "";
		
		description = "";
		severity = 1;
		bugnotes = new ArrayList<BugNotes>();
	}


	
	// get ID, name, description
	public Bug(int id, String name, String description) {
		this();
		this.id = id;
		this.name = name;
		this.description = description;
	}

//  nameresult, descr, stateresult , sev
	
	

	public Bug(String name, String description, int severity) {
		this();
		this.name = name;
		this.description = description;
		this.severity = severity;
	}



	public Bug(String name, String description, String state, int severity) {
		this();
		this.name = name;
		this.description = description;
		this.state = state;
		this.severity = severity;
	}



	// get ID, name, description, severity
	public Bug(int id, String name, String description, int severity) {
		this();
		this.id = id;
		this.name = name;
		this.description = description;
		this.severity = severity;
	}



	public Bug(int id, String title, String date, String state) {
		this();
		this.id = id;
		this.name = title;
		this.date_created_at = date;
		this.state = state;
		
	}


	public Bug(String name2, String description2, int severity2, String state2) {
		// TODO Auto-generated constructor stub
		this();
		this.name = name2;
		this.description = description2;
		this.severity = severity2;
		this.state = state2;
	}

	


	public Bug(int id, String name, String description, String date_created_at, String state, int severity) {
		this();
		this.id = id;
		this.name = name;
		this.description = description;
		this.date_created_at = date_created_at;
		this.state = state;
		this.severity = severity;
	}


	

	


	/**
	 * @param buglogs the buglogs to set
	 */
	public void setBuglogs(ArrayList<BugNotes> buglogs) {
		this.bugnotes = buglogs;
	}
	
	
	// add Note for the Bug
	public boolean addNote(String s) {
		boolean ok = false;
		
		BugNotes bn = new BugNotes();
		bn.setBugid(this.id);
		bn.setNotes(s);
		
		ok = bugnotes.add(bn);
		
		return ok;
	}
	
	// add a BugNote object
	public void addBugNote(BugNotes b) {
		if( bugnotes.add(b)) {
			System.out.println("success adding bugnotes");
		}else {
			System.out.println("failed to add bugnotes");
		}
		
	}
	
	// get the BugNotes
	public ArrayList<BugNotes> getBugnotes() {
		return bugnotes;
	}

	

	/**
	 * @return the date_created_at
	 */
	public String getDate_created_at() {
		return date_created_at;
	}



	/**
	 * @param date_created_at the date_created_at to set
	 */
	public void setDate_created_at(String date_created_at) {
		this.date_created_at = date_created_at;
	}



	/**
	 * @return the date_updated_at
	 */
	public String getDate_updated_at() {
		return date_updated_at;
	}



	/**
	 * @param date_updated_at the date_updated_at to set
	 */
	public void setDate_updated_at(String date_updated_at) {
		this.date_updated_at = date_updated_at;
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
	 * @return the title
	 */
	public String getTitle() {
		return name;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.name = title;
	}


	/**
	 * @return the date
	 */
	public String getDate() {
		return date_created_at;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date_created_at = date;
	}


	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}



	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}



	/**
	 * @return the severity
	 */
	public int getSeverity() {
		return severity;
	}



	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(int severity) {
		this.severity = severity;
	}



	@Override
	public String toString() {
		return "Bug [id=" + id + ", title=" + name + ", date=" + date_created_at + ", state=" + state + "]";
	}

	
}
