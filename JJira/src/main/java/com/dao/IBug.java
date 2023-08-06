/**
 * 
 */
package com.dao;

/**
 * @author nurali
 *
 */
public interface IBug {
	
	String Bug_table = "Bugs";
	
	String create_table_Bug = "create table Bugs(id int primary key auto_increment, name varchar(50), description varchar(250), severity int, state varchar(15), created_at DATETIME DEFAULT CURRENT_TIMESTAMP,\r\n"
			+ "    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP )";
	
	
	String BugLog_table = "BugLog";
	
	String create_table_BugLog = "create table BugLog(logid int primary key auto_increment, bugid int not null, notes varchar(100), created_at DATETIME DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, foreign key(bugid) references Bugs(id))";

}
