/**
 * 
 */
package com.dao;

/**
 * Project: JJira
 * @author nurali
 *
 */
public interface IEmployee {

	String EMPLOYEE_TABLE = "employees";
	
	String EMP_TYPE_TABLE = "EmpType";
	
	String create_employee_table = "create table employees(id int primary key auto_increment, fname varchar(40), lname varchar(40), email varchar(70), phone varchar(20))";
	
	String create_emptype_table = "create table EmpType(\r\n"
			+ "id int primary key auto_increment,\r\n"
			+ "groupid int,\r\n"
			+ "empid int,\r\n"
			+ "foreign key(groupid) references TeamGroups(id),\r\n"
			+ "foreign key(empid) references employees(id))";
	
	
}
