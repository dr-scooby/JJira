/**
 * 
 */
package com.data;

/**
 * @author nurali
 *
 */
public class Bug {
	
	private String id;
	private String name;
	private String description;
	private String date;
	private String state;
	private String log;
	private int severity;
	
	
	public Bug() {
		id = "";
		name = "";
		date = "";
		state = "";
		log = "";
		description = "";
		severity = 1;
	}


	
	// get ID, name, description
	public Bug(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}


	

	// get ID, name, description, severity
	public Bug(String id, String name, String description, int severity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.severity = severity;
	}



	public Bug(String id, String title, String date, String state, String log) {
		super();
		this.id = id;
		this.name = title;
		this.date = date;
		this.state = state;
		this.log = log;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
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
		return "Bug [id=" + id + ", title=" + name + ", date=" + date + ", state=" + state + "]";
	}

	
}
