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
	private String title;
	private String date;
	private String state;
	private String log;
	
	
	public Bug() {
		id = "";
		title = "";
		date = "";
		state = "";
		log = "";
	}


	public Bug(String id, String title, String date, String state, String log) {
		super();
		this.id = id;
		this.title = title;
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
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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


	@Override
	public String toString() {
		return "Bug [id=" + id + ", title=" + title + ", date=" + date + ", state=" + state + "]";
	}

	
}
