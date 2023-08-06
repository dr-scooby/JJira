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
	
	String create_table = "create table employees(id int primary key auto_increment, fname varchar(40), lname varchar(40), email varchar(70), phone varchar(20))";
}
