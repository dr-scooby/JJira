/**
 * 
 */
package com.data;

/**
 * @author nurali
 *
 */
public class Ticket {

	private String id; // ism101 or a101
	private String title;
	private String summary;
	private String notes;
	private String state; // open , closed, suspended
	private String date;
	
	
	public Ticket() {
		id = "";
		title = "";
		summary = "";
		notes = "";
		state = "";
		date = "";
	}


	public Ticket(String id, String title, String summary, String notes, String state, String date) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.notes = notes;
		this.state = state;
		this.date = date;
	}


	public Ticket(String id, String title, String summary, String state, String date) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.state = state;
		this.date = date;
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
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Ticket [id=" + id + ", title=" + title + ", state=" + state + "]";
	}
	
	
	
}
