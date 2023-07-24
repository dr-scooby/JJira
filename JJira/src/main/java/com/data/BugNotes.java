/**
 * 
 */
package com.data;

/**
 * @author nurali
 *
 */
public class BugNotes {
	
	private int logid;
	private int bugid;
	private String datecreated;
	private String date_updated;
	private String notes;
	
	
	public BugNotes() {
		logid = 0;
		bugid = 0;
		datecreated = "";
		date_updated = "";
		notes = "";
	}


	public BugNotes(int logid, int bugid, String date_created, String log) {
		this();
		this.logid = logid;
		this.bugid = bugid;
		this.datecreated = date_created;
		this.notes = log;
	}


	public BugNotes(int logid, int bugid, String date_created, String date_updated, String log) {
		this();
		this.logid = logid;
		this.bugid = bugid;
		this.datecreated = date_created;
		this.date_updated = date_updated;
		this.notes = log;
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
	 * @return the bugid
	 */
	public int getBugid() {
		return bugid;
	}


	/**
	 * @param bugid the bugid to set
	 */
	public void setBugid(int bugid) {
		this.bugid = bugid;
	}


	/**
	 * @return the date_created
	 */
	public String getDatecreated() {
		return datecreated;
	}


	/**
	 * @param date_created the date_created to set
	 */
	public void setDate_created(String date_created) {
		this.datecreated = date_created;
	}


	/**
	 * @return the date_updated
	 */
	public String getDate_updated() {
		return date_updated;
	}


	/**
	 * @param date_updated the date_updated to set
	 */
	public void setDate_updated(String date_updated) {
		this.date_updated = date_updated;
	}


	/**
	 * @return the log
	 */
	public String getLog() {
		return notes;
	}


	/**
	 * @param log the log to set
	 */
	public void setLog(String log) {
		this.notes = log;
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
	 * @param datecreated the datecreated to set
	 */
	public void setDatecreated(String datecreated) {
		this.datecreated = datecreated;
	}


	@Override
	public String toString() {
		return "BugLog [logid=" + logid + ", bugid=" + bugid +"]";
	}
	
	
	

}
