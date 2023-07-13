/**
 * 
 */
package com.data;

/**
 * @author nurali
 *
 */
public class Ticket {

	private int id; 
	private String title;
	private String summary;
	private String notes;
	private String state; // open , closed, suspended
	private int severity;
	private String date_created;
	
	
	public Ticket() {
		id = 0;
		title = "";
		summary = "";
		notes = "";
		state = "";
		date_created = "";
		severity = 0;
	}


	public Ticket(int id, String title, String summary, String notes, String state, String date) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.notes = notes;
		this.state = state;
		this.date_created = date;
	}


	
	public Ticket(int id, String title, String summary, String notes, String date) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.notes = notes;
		this.date_created = date;
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
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}


	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}


	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}


	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
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
	 * @return the date
	 */
	public String getDate() {
		return date_created;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date_created = date;
	}


	@Override
	public String toString() {
		return "Ticket [id=" + id + ", title=" + title + ", state=" + state + "]";
	}
	
	
	
}
