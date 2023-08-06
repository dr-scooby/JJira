/**
 * 
 */
package com.dao;

/**
 * Project: JiraDB
 * @author nurali
 *
 */
public interface ITeam {
	
	String create_table_Team = "create table TeamGroups(id int primary key auto_increment, name varchar(50), email varchar(70) )";
	
	String TABLE_TEAM = "TeamGroups";

}
