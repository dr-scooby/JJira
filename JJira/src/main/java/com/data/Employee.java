/**
 * 
 */
package com.data;

/**
 * @author nurali
 *
 */
public class Employee {
	
	
	private int id;
	private String empid;
	private String fname;
	private String lname;
	private String email;
	private String phone;
	private String dob; // what is dob??????????? date of birth??
	private String group;
	private int teamid; // the group id
	
	
	public Employee() {
		id = 0;
		teamid = 0;
		empid = "";
		fname = "";
		lname = "";
		email = "";
		phone = "";
		dob = "";
		group = "";
	}



	public Employee(String fname, String lname, String email, String phone, String dob) {
		this();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
	}



	public Employee(int id, String empid, String fname, String lname, String email, String phone, String dob) {
		this();
		this.id = id;
		this.empid = empid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
	}


	
	/**
	 * @return the teamid
	 */
	public int getTeamid() {
		return teamid;
	}


	/**
	 * @param teamid the teamid to set
	 */
	public void setTeamid(int teamid) {
		this.teamid = teamid;
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
	 * @return the empid
	 */
	public String getEmpid() {
		return empid;
	}



	/**
	 * @param empid the empid to set
	 */
	public void setEmpid(String empid) {
		this.empid = empid;
	}



	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}



	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}



	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}



	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}



	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}



	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}



	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}



	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}



	/**
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", empid=" + empid + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", phone=" + phone + ", dob=" + dob + "]";
	}
	
	
	
	

}
