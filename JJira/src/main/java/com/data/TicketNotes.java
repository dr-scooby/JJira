/**
 * 
 */
package com.data;

/**
 * @author nurali
 *
 */
public class TicketNotes {

	private int logid;
	private int ticketid;
	private String notes;
	
	private String datecreated;
	private String dateupdated;
	
	
	
	public TicketNotes() {
		logid = 0;
		ticketid = 0;
		notes = "";
		datecreated = "";
		dateupdated = "";
		
	}
	
	
	public TicketNotes(int logid, int ticketid, String notes) {
		this();
		this.logid = logid;
		this.ticketid = ticketid;
		this.notes = notes;
	}

	

	public TicketNotes(int logid, int ticketid, String notes, String datecreated, String dateupdated) {
		this();
		this.logid = logid;
		this.ticketid = ticketid;
		this.notes = notes;
		this.datecreated = datecreated;
		this.dateupdated = dateupdated;
	}


	/**
	 * @return the logid
	 */
	public int getLogid() {
		return logid;
	}


	/**
	 * @param logid the logid to set
	 */
	public void setLogid(int logid) {
		this.logid = logid;
	}


	/**
	 * @return the ticketid
	 */
	public int getTicketid() {
		return ticketid;
	}


	/**
	 * @param ticketid the ticketid to set
	 */
	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
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
	 * @return the datecreated
	 */
	public String getDatecreated() {
		return datecreated;
	}


	/**
	 * @param datecreated the datecreated to set
	 */
	public void setDatecreated(String datecreated) {
		this.datecreated = datecreated;
	}


	/**
	 * @return the dateupdated
	 */
	public String getDateupdated() {
		return dateupdated;
	}


	/**
	 * @param dateupdated the dateupdated to set
	 */
	public void setDateupdated(String dateupdated) {
		this.dateupdated = dateupdated;
	}


	@Override
	public String toString() {
		return "TicketNotes [logid=" + logid + ", ticketid=" + ticketid + ", notes=" + notes + ", datecreated="
				+ datecreated + ", getLogid()=" + getLogid() + ", getTicketid()=" + getTicketid() + ", getNotes()="
				+ getNotes() + ", getDatecreated()=" + getDatecreated() + ", getDateupdated()=" + getDateupdated()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
}
