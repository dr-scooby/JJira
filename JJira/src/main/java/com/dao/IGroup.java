/**
 * 
 */
package com.dao;

/**
 * @author nurali
 *
 */
public interface IGroup {
	
	String Group_table_name = "TeamGroups";
	
	String create_table_Group = "create table TeamGroups(id int primary key auto_increment, name varchar(50), email varchar(70) )";

}
