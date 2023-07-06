/**
 * 
 */
package com.data;

/**
 * @author nurali
 *
 */
public class BugLog {
	
	private int logid;
	private int bugid;
	private String date_created;
	private String date_updated;
	private String log;
	
	
	public BugLog() {
		logid = 0;
		bugid = 0;
		date_created = "";
		date_updated = "";
		log = "";
	}


	public BugLog(int logid, int bugid, String date_created, String log) {
		this();
		this.logid = logid;
		this.bugid = bugid;
		this.date_created = date_created;
		this.log = log;
	}


	public BugLog(int logid, int bugid, String date_created, String date_updated, String log) {
		super();
		this.logid = logid;
		this.bugid = bugid;
		this.date_created = date_created;
		this.date_updated = date_updated;
		this.log = log;
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
	public String getDate_created() {
		return date_created;
	}


	/**
	 * @param date_created the date_created to set
	 */
	public void setDate_created(String date_created) {
		this.date_created = date_created;
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
		return "BugLog [logid=" + logid + ", bugid=" + bugid + ", log=" + log + "]";
	}
	
	
	

}
