/**
 * 
 */
package com.data;

import java.util.ArrayList;

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
	private String log;
	private int severity;
	private ArrayList<BugLog> buglogs;
	
	
	public Bug() {
		id = 0;
		name = "";
		date_created_at = "";
		date_updated_at = "";
		state = "";
		log = "";
		description = "";
		severity = 1;
		buglogs = new ArrayList<BugLog>();
	}


	
	// get ID, name, description
	public Bug(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

//  nameresult, descr, stateresult , sev
	
	

	public Bug(String name, String description, int severity) {
		super();
		this.name = name;
		this.description = description;
		this.severity = severity;
	}



	public Bug(String name, String description, String state, int severity) {
		super();
		this.name = name;
		this.description = description;
		this.state = state;
		this.severity = severity;
	}



	// get ID, name, description, severity
	public Bug(int id, String name, String description, int severity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.severity = severity;
	}



	public Bug(int id, String title, String date, String state, String log) {
		super();
		this.id = id;
		this.name = title;
		this.date_created_at = date;
		this.state = state;
		this.log = log;
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
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.date_created_at = date_created_at;
		this.state = state;
		this.severity = severity;
	}


	

	/**
	 * @return the buglogs
	 */
	public ArrayList<BugLog> getBuglogs() {
		return buglogs;
	}



	/**
	 * @param buglogs the buglogs to set
	 */
	public void setBuglogs(ArrayList<BugLog> buglogs) {
		this.buglogs = buglogs;
	}

	
	public boolean addLog(int bugid   ,String log) {
		boolean ok = false;		
		
		BugLog bl = new BugLog();
		bl.setBugid(bugid);
		bl.setLog(log);
		if(buglogs.add(bl))
			ok = true;
		
		
		return ok;
	}
	
	
	public boolean addLog(int logid, int bugid, String log) {
		boolean ok = false;
		BugLog bl = new BugLog();
		bl.setBugid(bugid);
		bl.setLogid(logid);
		bl.setLog(log);
		if(buglogs.add(bl))
			ok = true;
		
		return ok;
	}
	
	
	public boolean addLog(String log) {
		boolean ok = false;
		
		BugLog bl = new BugLog();
		bl.setBugid(this.getId());
		if(buglogs.add(bl))
			ok = true;
		
		
		return ok;
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
	 * @return the log
	 */
	public String getLog() {
		return log;
	}


	/**
	 * @param log the log to set
	 */
	public void setLog(String log) {
		this.log = log;
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
