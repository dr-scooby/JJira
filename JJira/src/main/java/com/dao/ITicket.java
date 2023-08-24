/**
 * 
 */
package com.dao;

/**
 * @author nurali
 *
 */
public interface ITicket {
	
	String table_name_Ticket = "tickets";
	
	String create_table_Ticket = "create table tickets(id int primary key auto_increment, \r\n"
			+ "title varchar(50) not null,\r\n"
			+ "summary varchar(200) not null,\r\n"
			+ "notes varchar(200),\r\n"
			+ "severity int,\r\n"
			+ "state varchar(20) not null,\r\n"
			+ "emptype_id int,\r\n"
			+ "created_at datetime default current_timestamp,\r\n"
			+ "updated_at timestamp default current_timestamp on update current_timestamp\r\n"
			+ "foreign key(emptype_id) references EmpType(id)\r\n"
			+ ")";
	
	String table_name_TicketLog = "ticketlog";
	
	String create_table_TicketLog = "create table ticketlog(\r\n"
			+ "logid int primary key auto_increment,\r\n"
			+ "ticketid int not null,\r\n"
			+ "log varchar(255),\r\n"
			+ "datecreated DATETIME DEFAULT CURRENT_TIMESTAMP,\r\n"
			+ "dateupdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\r\n"
			+ "foreign key(ticketid) references tickets(id))";

}
