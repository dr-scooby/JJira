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
public class Ticket {

	private int id; 
	private String title;
	private String summary;
	private String notes;
	private String state; // open , closed, suspended
	private int severity;
	private String date;
	private String adate;
	private String groupname;
	private String empassigned;
	
	private ArrayList<TicketNotes> tiknotes;
	
	public Ticket() {
		id = 0;
		title = "";
		summary = "";
		notes = "";
		state = "";
		date = "";
		severity = 0;
		groupname = "";
		empassigned = "";
		tiknotes = new ArrayList<TicketNotes>();
	}


	public Ticket(int id, String title, String summary, String notes, String state, String date) {
		this();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.notes = notes;
		this.state = state;
		this.date = date;
	}


	
	public Ticket(int id, String title, String summary, String notes, String date) {
		this();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.notes = notes;
		this.date = date;
	}
	
	
	
	/**
	 * @return the tiknotes
	 */
	public ArrayList<TicketNotes> getTiknotes() {
		return tiknotes;
	}


	/**
	 * @param tiknotes the tiknotes to set
	 */
	public void setTiknotes(ArrayList<TicketNotes> tiknotes) {
		this.tiknotes = tiknotes;
	}

	// add a note to the Ticket - String
	public boolean addNote(String n) {
		
		
		TicketNotes notes = new TicketNotes();
		notes.setTicketid(this.id);
		notes.setNotes(n);		
		
		
		return tiknotes.add(notes);
	}
	
	// add a TicketNotes object
	public void addTicketNote(TicketNotes tn) {
		tiknotes.add(tn);
	}
	
	// get the Iterator
	public Iterator getTicketNotesIt() {
		return tiknotes.iterator();
	}
	
	// is it Empty?
	public boolean isTicketNotesEmpty() {
		return tiknotes.isEmpty();
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
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	


	/**
	 * @return the groupname
	 */
	public String getGroupname() {
		return groupname;
	}


	/**
	 * @param groupname the groupname to set
	 */
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}


	/**
	 * @return the empassigned
	 */
	public String getEmpassigned() {
		return empassigned;
	}


	/**
	 * @param empassigned the empassigned to set
	 */
	public void setEmpassigned(String empassigned) {
		this.empassigned = empassigned;
	}


	@Override
	public String toString() {
		return "Ticket [id=" + id + ", title=" + title + ", state=" + state + "]";
	}
	
	
	
}
