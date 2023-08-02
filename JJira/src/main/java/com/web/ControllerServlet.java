package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DB.DBModel;
import com.data.Bug;
import com.data.Employee;
import com.data.Group;
import com.data.Ticket;

/**
 * JIRA Project
 * Java version 1.7
 * @author nurali
 *
 */
public class ControllerServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private DBModel db ; // handle to the DBModel
	private String dbname;
	private String dbuser;
	private String dbpass;

	 /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public void init() {
    	// get the configs from the web.xml
    	dbname = getServletConfig().getInitParameter("dbname");
    	dbuser = getServletConfig().getInitParameter("dbuser");
    	dbpass = getServletConfig().getInitParameter("dbpassword");
    	// pass the info to the DBModel
    	db = new DBModel(dbname, dbuser, dbpass);
    }
    
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getServletPath();
		PrintWriter out = response.getWriter();
		
		if(action == null) {
		// Write the response message, in an HTML page
		// this block is to test the Servlet & web.xml is working and configure properly.
	      try {
	         out.println("<!DOCTYPE html>");
	         out.println("<html><head>");
	         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	         out.println("<title>Hello, World</title></head>");
	         out.println("<body>");
	         out.println("<h1>Hello, world! You have successfully reached this Servlet..It's working</h1>");  // says Hello
	         // Echo client's request information
	         out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
	         out.println("<p>Protocol: " + request.getProtocol() + "</p>");
	         out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
	         out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
	         // Generate a random number upon each request
	         out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
	         
	         // Servlet path from client
	         out.println("<p>Servlet path:<strong> " + action + "<strong></p>");
	         out.println("</body>");
	         out.println("</html>");
	      } finally {
	         out.close();  // Always close the output writer
	      }
		}else {
			try {
				switch(action) {
				case "/newgroup":
					newgroup(request, response);
				break;
				case "/searchgroup":
					searchgroup(request, response);
				break;
				case "/newemployee":
					newemployee(request, response);
				break;
				case "/searchemp":
					searchemp(request, response);
				break;
				case "/newbug":
					newbug(request, response);
				break;
				case "/searchbug":
					searchbug(request, response);
				break;
				case "/listallbugs":
					listallbugs(request, response);
				break;
				case "/newticket":
					newticket(request, response);
				break;
				case "/ticketsearch":
					ticketsearch(request, response);
					break;
				case "/listalltickets":
					listalltickets(request, response);
					break;
					//listallemployees
				case "/listallemployees":
					listallemployees(request, response);
					break;
					// need a single ticket edit or show
				case "/editticket":
					editTicket(request, response);
					break;
				case "/editgroup":
					editgroup(request, response);
					break;
				case "/addnotesbug":
					addnotesbug(request, response);
					break;
				case "/editbug":
					editbug(request, response);
					break;
				// add Notes to the Ticket	
				case "/addnotesticket":
					addnotesticket(request, response);
					break;
				case "/updateticket":
					updateticket(request, response);
					break;
				case "/updatebug":
					updatebug(request, response);
					break;
					//listallgroups
				case "/listallgroups":
					listallgroups(request, response);
					break;	
				// updategroup
				case "/updategroup":
					updategroup(request, response);
					break;
				case "/selectemployee":
					selectemployee(request, response);
					break;
				default:
					gohome(request, response);
				break;
					
				}
			}catch(Exception e) {
				
			}
		}
	}
	
	
	
	private void selectemployee(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String groupid = request.getParameter("id");
		
		try {
			ArrayList<Employee> emps = db.getUnassignedEmployees(); // get only un-assigned employees
			request.setAttribute("emps", emps); // set ArrayList
			
			// get Group data object
			Group grp = db.getGroup(groupid);
			request.setAttribute("group", grp);
			// set to the request
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/selectemployee.jsp"); // send to jsp
			try {
				dis.forward(request, response);
				return;
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// this block is to test the Servlet & web.xml is working and configure properly.
//	      try {
//	    	  PrintWriter out;
//	    	   out = response.getWriter(); 
//	    	 
//				
//				 out.println("<!DOCTYPE html>");
//		         out.println("<html><head>");
//		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
//		         out.println("<title>Hello, World</title></head>");
//		         out.println("<body>");
//		         out.println("<h1>Hello, world! You have successfully submitted to this Servlet..It's working</h1>");  // says Hello
//		         out.println("<h1>Add Employee to the Group</h1>");
//		         out.println("<br>");
//		         out.println("Group ID: " + groupid );
//		         
//		         
//		         out.println("</body>");
//		         out.println("</html>");
//			
//		         out.close();
//	      }catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//	      }
	}


	private void listallemployees(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("list all employees called");
		
		try {
			ArrayList<Employee> emps = db.getAllEmployees();
			request.setAttribute("emps", emps);
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/ListAllEmployees.jsp");
			try {
				dis.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	// update group with new info
	private void updategroup(HttpServletRequest request, HttpServletResponse response) {
		// Get the data from the client
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		System.out.println("Client info: " + id + " " + name + " " + email);
		boolean ok;
		try {
			ok = db.editGroup(id, name, email); // send data to DB
			if(ok) {
				String message ="Success updating Team";
				request.setAttribute("message", message);
				RequestDispatcher dis = request.getRequestDispatcher("editgroup?id="+id);
				try {
					dis.forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				String message ="FAILED TO update Team";
				request.setAttribute("message", message);
				RequestDispatcher dis = request.getRequestDispatcher("editgroup?id="+id);
				try {
					dis.forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void editgroup(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub			
		String id = request.getParameter("id");
		try {
			Group grp = db.getGroup(id);
			request.setAttribute("group", grp);
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/EditGroup.jsp"); // send to jsp
			try {
				dis.forward(request, response);
				return;
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			request.setAttribute("exception", e1.getMessage());
			RequestDispatcher diserror = request.getRequestDispatcher("/WEB-INF/jsp/Error.jsp");
			try {
				diserror.forward(request, response);
				return;
			} catch (ServletException | IOException e1a) {
				// TODO Auto-generated catch block
				e1a.printStackTrace();
			}
		}
		
		
//		 try {
//			 PrintWriter out;
//   	   		out = response.getWriter(); 
//   	 
//			
//			 out.println("<!DOCTYPE html>");
//	         out.println("<html><head>");
//	         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
//	         out.println("<title>Hello, World</title></head>");
//	         out.println("<body>");
//	         out.println("<h1>Hello, world! You have successfully reached the Edit Group Servlet..It's working</h1>");  // says Hello
//	         out.println("<h1>Edit Group info, ID:</h1>");
//	         out.println(id);
//	         out.println("<br>");
//	         		         
//	         
//	         out.println("</body>");
//	         out.println("</html>");
//		
//	         out.close();
//     }catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//     }
		
		
		
		
	}


	private void listallgroups(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// list all groups
		System.out.println("listing all Groups/TEAMs");
		try {
			ArrayList<Group> groups = db.getallGroups();
			request.setAttribute("groups", groups);
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/listallgroups.jsp");
			try {
				dis.forward(request, response);
			} catch (ServletException | IOException e) {
				System.out.println("error listallgroups, line 168:ControllerServlet");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("error listallgroups, line 174:ControllerServlet");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	// update bug with data
	private void updatebug(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String state = request.getParameter("state");
		String date = request.getParameter("date");
		String sev = request.getParameter("sev");
		
		
		try {
			boolean ok = db.updateBug(id, name, description, state, sev);
			if(ok) {
				String errormessage = "Success updating Bug";
				request.setAttribute("errormessage", errormessage);
				// editbug actually calls the web.xml 'editbug' map to the Controller
				RequestDispatcher dis = request.getRequestDispatcher("editbug?id="+id); // send to JSP
				try {
					dis.forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//try {
		// testing only
//		PrintWriter out;
//		out = response.getWriter(); 
	 
		
		
		
		
//		out.println("<!DOCTYPE html>");
//		out.println("<html><head>");
//		out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
//		out.println("<title>Hello, World</title></head>");
//		out.println("<body>");
//		out.println("<h1>Hello, world! You have successfully reached the Add Bug Log Servlet..It's working</h1>");  // says Hello
//		out.println("<h1>Ticket Log info:</h1>");
//		out.println("<br>");
//		
//		out.println("Bug ID: " + id);
//		out.println("<br>");
//		
//		out.println("Bug Name: " + name);
//		
//		out.println("<br>");
//		out.println("Bug description: " + description);
//		
//		out.println("<br>");
//		out.println("Bug state: " + state);
//		
//		out.println("<br>");
//		out.println("Bug date: " + date);
//		
//		out.println("<br>");
//		out.println("Bug sev: " + sev);
//		
//		out.println("<br>");
//		
//		out.println("</body>");
//		out.println("</html>");
//		
//		out.close();
//	}catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//		
	}


	// add notes to the Bug
	private void addnotesbug(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("add notes to Bug");
		
		// get the ID and notes data
		String bugnotes = request.getParameter("bugnotes");
		String bugid = request.getParameter("bugid");
		
		if(bugnotes.isBlank() || bugnotes.isEmpty() || bugnotes == null) {
			System.out.println("bug notes empty");
			String errormessage = "notes empty";
			request.setAttribute("errormessage", errormessage);
			RequestDispatcher dis = request.getRequestDispatcher("editbug?id="+bugid);//send to JSP
			try {
				dis.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			// not null, add the notes
			try {
				boolean ok = db.addBugNotes(bugid, bugnotes);
				if(ok) {
					try {
						response.sendRedirect("editbug?id="+bugid);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
//		try {
//			// testing only
//			PrintWriter out;
//			out = response.getWriter(); 
//		 
//			
//			out.println("<!DOCTYPE html>");
//			out.println("<html><head>");
//			out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
//			out.println("<title>Hello, World</title></head>");
//			out.println("<body>");
//			out.println("<h1>Hello, world! You have successfully reached the Add Bug Log Servlet..It's working</h1>");  // says Hello
//			out.println("<h1>Ticket Log info:</h1>");
//			out.println("<br>");
//			
//			out.println("Bug notes: " + bugnotes);
//			out.println("<br>");
//			out.println("BugID: " + bugid);
//			
//			out.println("</body>");
//			out.println("</html>");
//			
//			out.close();
//		}catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}


	// edit bug, 
	private void editbug(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// get ID from the client
		String bugid = request.getParameter("id"); // get the Bug ID
		
		System.out.println("Edit:: Bug ID " + bugid);
		
		Bug bug = db.getBug(bugid); // get BUg from DB
		System.out.println("Edit Bug:: " + bug);
		request.setAttribute("bug", bug);
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/EditBug.jsp"); // send to JSP
		try {
			System.out.println("Sending to EditBug.jsp...");
			dis.forward(request, response);
			//return;
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("exception", e.getMessage());
			RequestDispatcher diserror = request.getRequestDispatcher("/WEB-INF/jsp/Error.jsp");
			try {
				diserror.forward(request, response);
				return;
			} catch (ServletException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		
	}


	// update ticket details
	private void updateticket(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String sev = request.getParameter("Severity");
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		String state = request.getParameter("state");
		String tikid = request.getParameter("id");
		
		if(sev.isEmpty() || title.isEmpty() || summary.isEmpty() || state.isEmpty()) {
			System.out.println("tiknotes empty, blan, null");
			 String errormessage = "Empty fields, not allowed Empty";
			 request.setAttribute("errormessage", errormessage);
			 //response.sendRedirect("editticket?id="+tikid);
			 RequestDispatcher dis = request.getRequestDispatcher("editticket?id="+tikid); // send to the JSP page for editing
				try {
					dis.forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else {
			try {
				boolean ok = db.updateTicket(tikid, title, summary, sev, state);
				if(ok) {
					String errormessage = "Success updating Ticket";
					request.setAttribute("errormessage", errormessage);
					RequestDispatcher dis = request.getRequestDispatcher("editticket?id="+tikid); // send to the JSP page for editing
					try {
						dis.forward(request, response);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		 // testing only
//		 PrintWriter out;
//		 try {
//			out = response.getWriter();
//			 out.println("<!DOCTYPE html>");
//		        out.println("<html><head>");
//		        out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
//		        out.println("<title>Hello, World</title></head>");
//		        out.println("<body>");
//		        out.println("<h1>Hello, world! You have successfully reached the Update Ticket Servlet..It's working</h1>");  // says Hello
//		        out.println("<h1>Ticket Log info:</h1>");
//		        out.println("<br>");
//		        
//		        out.println(tikid);
//		        out.println("<br>");
//		        out.println(sev);
//		        out.println("<br>");
//		        out.println("<br>");
//		        out.println(title);
//		        out.println("<br>");
//		        out.println(summary);
//		        out.println("<br>");
//		        out.println(state);
//		        out.println("</body>");
//		        out.println("</html>");
//			
//		        out.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//	 
		
		
				
	}


	// add notes to the Ticket Log
	private void addnotesticket(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("addnotesticket Controller reached...");
		
		 try {
			 // get the ID and notes data
			 String tikid = request.getParameter("tikid");
			 String tiknotes = request.getParameter("tiknotesta");
			 
			 if(tiknotes.isBlank() || tiknotes.isEmpty() || tiknotes == null) {
				 System.out.println("tiknotes empty, blan, null");
				 String errormessage = "Notes is Empty, not allowed Empty";
				 request.setAttribute("errormessage", errormessage);
				 //response.sendRedirect("editticket?id="+tikid);
				 RequestDispatcher dis = request.getRequestDispatcher("editticket?id="+tikid); // send to the JSP page for editing
					try {
						dis.forward(request, response);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 }else {
				 System.out.println("not null");
				 try {
						boolean ok = db.addTicketNotes(tikid, tiknotes);
						response.sendRedirect("editticket?id="+tikid);
						//request.setAttribute("id", tikid);
						//editTicket(request, response);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 }
			 
			
			 
			 // testing only
//			 PrintWriter out;
//			 out = response.getWriter(); 
//   	 
//			
//			 out.println("<!DOCTYPE html>");
//	         out.println("<html><head>");
//	         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
//	         out.println("<title>Hello, World</title></head>");
//	         out.println("<body>");
//	         out.println("<h1>Hello, world! You have successfully reached the Add Ticket Log Servlet..It's working</h1>");  // says Hello
//	         out.println("<h1>Ticket Log info:</h1>");
//	         out.println("<br>");
//	         
//	         out.println(tikid);
//	         out.println("<br>");
//	         out.println(tiknotes);
//	         
//	         out.println("</body>");
//	         out.println("</html>");
//		
//	         out.close();
     }catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
     }
	}


	// Edit the ticket
	private void editTicket(HttpServletRequest request, HttpServletResponse response) {
		// get the Ticket ID from the client
		int id = Integer.parseInt(request.getParameter("id"))  ;
		try {
			Ticket tik = db.getTicket(id); // get data from DB
			request.setAttribute("tik", tik);
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/EditTicket.jsp"); // send to the JSP page for editing
			try {
				dis.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("exception", e.getMessage());
			RequestDispatcher diserror = request.getRequestDispatcher("/WEB-INF/jsp/Error.jsp");
			try {
				diserror.forward(request, response);
				return;
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}


	private void listalltickets(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("listing all tickets");
		ArrayList<Ticket> tiks = db.listallTickets();
		request.setAttribute("listalltik", tiks);
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/listalltickets.jsp");
		try {
			dis.forward(request, response);
			return;
		} catch (ServletException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		 try {
//			 PrintWriter out;
//	    	   out = response.getWriter(); 
//	    	 
//				
//				 out.println("<!DOCTYPE html>");
//		         out.println("<html><head>");
//		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
//		         out.println("<title>Hello, World</title></head>");
//		         out.println("<body>");
//		         out.println("<h1>Hello, world! You have successfully reached the all tickets Servlet..It's working</h1>");  // says Hello
//		         out.println("<h1>List All Tickets info</h1>");
//		         out.println("<br>");
//		         		         
//		         
//		         out.println("</body>");
//		         out.println("</html>");
//			
//		         out.close();
//	      }catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//	      }
		
	}


	private void listallbugs(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		PrintWriter out;
		System.out.println("listing all bugs. ControllerServlet");
		
		ArrayList<Bug> bugs = db.listallBugs();
		
		try {
			request.setAttribute("listallbugs", bugs);
			RequestDispatcher dispatch = request.getRequestDispatcher("listallBugs.jsp");
			dispatch.forward(request, response);
			return;
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		// this block is to test the Servlet & web.xml is working and configure properly.
	      try {
	    	   out = response.getWriter(); 
	    	 
				
				 out.println("<!DOCTYPE html>");
		         out.println("<html><head>");
		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		         out.println("<title>Hello, World</title></head>");
		         out.println("<body>");
		         out.println("<h1>Hello, world! You have successfully submitted to this Servlet..It's working</h1>");  // says Hello
		         out.println("<h1>List All Bugs info</h1>");
		         out.println("<br>");
		         
		         //ArrayList<Bug> bugs = db.listallBugs();
		         System.out.println("Bugs size:: " + bugs.size());
		         out.println("Bugs Size:: " + bugs.size());
		         out.println("<br>");
		         Iterator it = bugs.iterator();
		         while(it.hasNext()) {
		        	 Bug b = (Bug)it.next();
		        	 out.println(b);
		        	 out.println("<br>");
		         }
		         
		         out.println("</body>");
		         out.println("</html>");
			
		         out.close();
	      }catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      }
	      */
	}


	// search for tickets based on criteria
	private void ticketsearch(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		String notes = request.getParameter("notes");
		//severity
		String severity = request.getParameter("severity");
		String state = request.getParameter("state");
		
		 PrintWriter out;
		 
		 if(!title.isEmpty()) {
			 // get the DB results search
			 ArrayList<Ticket> tiks = db.searchTicketTitle(title);
			 // set Attribute
			 request.setAttribute("tickets", tiks);
			 // now send to ticket results page
			 RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/tickettitlesearch.jsp");
			 try {
				dis.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("exception", e.getMessage());
				RequestDispatcher diserror = request.getRequestDispatcher("/WEB-INF/jsp/Error.jsp");
				try {
					diserror.forward(request, response);
					return;
				} catch (ServletException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			 return;
		 }
		 
		// this block is to test the Servlet & web.xml is working and configure properly.
//	      try {
//	    	   out = response.getWriter(); 
//	    	 
//				
//				 out.println("<!DOCTYPE html>");
//		         out.println("<html><head>");
//		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
//		         out.println("<title>Hello, World</title></head>");
//		         out.println("<body>");
//		         out.println("<h1>Hello, world! You have successfully submitted to this Servlet..It's working</h1>");  // says Hello
//		         out.println("<h1>Search Bug info</h1>");
//		         // Echo client's submitted information
//		         out.println("<p>Title: " + title + "</p>");
//		         out.println("<p>Summery: " + summary + "</p>");
//		         out.println("<p>Notes: " + notes + "</p>");	
//		         out.println("<p>Severity Level: " + severity + "</p>");
//		         
//		         out.println("</body>");
//		         out.println("</html>");
//			
//		         out.close();
//	      }catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//	      }
	}


	private void newticket(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		String notes = request.getParameter("notes");
		//severity
		String severity = request.getParameter("severity");
		String state = request.getParameter("state");
		
		 PrintWriter out;
		// this block is to test the Servlet & web.xml is working and configure properly.
//	      try {
//	    	   out = response.getWriter(); 
//	    	 
//				
//				 out.println("<!DOCTYPE html>");
//		         out.println("<html><head>");
//		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
//		         out.println("<title>Hello, World</title></head>");
//		         out.println("<body>");
//		         out.println("<h1>Hello, world! You have successfully submitted to this Servlet..It's working</h1>");  // says Hello
//		         out.println("<h1>Search Bug info</h1>");
//		         // Echo client's submitted information
//		         out.println("<p>Title: " + title + "</p>");
//		         out.println("<p>Summery: " + summary + "</p>");
//		         out.println("<p>Notes: " + notes + "</p>");	
//		         out.println("<p>Severity Level: " + severity + "</p>");
//		         
//		         out.println("</body>");
//		         out.println("</html>");
//			
//		         out.close();
//	      }catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//	      }
	      
	      // send data to the model to process
	      try {
			if(db.anewTicket(title, summary, notes, Integer.parseInt(severity), state)) {
				  // success, send the bean to success page to display info
				  Ticket tik = new Ticket();
				  tik.setTitle(title);
				  tik.setNotes(notes);
				  tik.setSummary(summary);
				  request.setAttribute("Tik", tik);
				  RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsp/successnewticket.jsp");
					try {
						try {
							dispatch.forward(request, response);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return;
					} catch (ServletException  e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						request.setAttribute("exception", e.getMessage());
						RequestDispatcher diserror = request.getRequestDispatcher("/WEB-INF/jsp/Error.jsp");
						try {
							diserror.forward(request, response);
							return;
						} catch (ServletException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
			  }
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("stack", e);
			request.setAttribute("exception", e.getMessage());
			RequestDispatcher diserror = request.getRequestDispatcher("/WEB-INF/jsp/Error.jsp");
			try {
				diserror.forward(request, response);
				return;
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}


	private void searchbug(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String severity = request.getParameter("severity");
		String state = request.getParameter("state");
		
		ArrayList<Bug> bugs = null;
		
		if(!description.isEmpty()) {
			bugs = db.searchBugDescription(description);
		}
		
		if(description.isEmpty() ) {
		
			bugs =    db.searchBug(name);
		}
		
		
		try {
			request.setAttribute("listallbugs", bugs);
			RequestDispatcher dispatch = request.getRequestDispatcher("bugsearchresults.jsp");
			dispatch.forward(request, response);
			return;
		} catch (ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 PrintWriter out;
		// this block is to test the Servlet & web.xml is working and configure properly.
//	      try {
//	    	   out = response.getWriter(); 
//	    	 
//				
//				 out.println("<!DOCTYPE html>");
//		         out.println("<html><head>");
//		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
//		         out.println("<title>Hello, World</title></head>");
//		         out.println("<body>");
//		         out.println("<h1>Hello, world! You have successfully submitted to this Servlet..It's working</h1>");  // says Hello
//		         out.println("<h1>Search Bug info</h1>");
//		         // Echo client's submitted information
//		         out.println("<p>Name Search: " + name + "</p>");
//		         out.println("<p>Description Search: " + description + "</p>");
//		         out.println("<p>Severity: " + severity + "</p>");		                
//		         
//		         out.println("<br><h1><p>Search Results</p></h1>");
//		         out.println("<br>");
//		         
//		         Iterator<Bug> it = bugs.iterator();
//		         while(it.hasNext()) {
//		        	 Bug b = (Bug)it.next();
//		        	 out.println("Bug ID: " + b.getId());
//		        	 out.println("Bug Name: " + b.getName());
//		        	 out.println("Bug Description: " + b.getDescription());
//		        	 out.println("Bug Severity: " + b.getSeverity());
//		        	 out.println("<br>");
//		         }
//		         
//		         out.println("</body>");
//		         out.println("</html>");
//			
//		         out.close();
//	      }catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//	      }
	}


	private void newbug(HttpServletRequest request, HttpServletResponse response) {
		// get client data 
		String bugname = request.getParameter("bugname");
		String description = request.getParameter("description");
		String severity = request.getParameter("severity");
		String state = request.getParameter("state");
		
		 PrintWriter out;
		// this block is to test the Servlet & web.xml is working and configure properly.
		 // this is working, so now need to add a JSP for the output
//	      try {
//	    	   out = response.getWriter(); 
//	    	 
//				
//				 out.println("<!DOCTYPE html>");
//		         out.println("<html><head>");
//		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
//		         out.println("<title>Hello, World</title></head>");
//		         out.println("<body>");
//		         out.println("<h1>Hello, world! You have successfully submitted to this Servlet..It's working</h1>");  // says Hello
//		         out.println("<h1>New Bug info</h1>");
//		         // Echo client's submitted information
//		         out.println("<p>Bug Name : " + bugname + "</p>");
//		         out.println("<p>Bug description: " + description + "</p>");
//		         out.println("<p>severity Level: " + severity + "</p>");
//		         out.println("<p>State: " + state + "</p>");
//		         
//		         
//		         out.println("</body>");
//		         out.println("</html>");
//			
//		         out.close();
//	      }catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//	      }
	      // hand client data to the DBModel to process
	      if(db.anewBug(bugname, description, severity, state)) {
	    	  // success
	    	  try {
	    		Bug bug = new Bug(bugname, description, Integer.parseInt(severity));  
	  			request.setAttribute("bug", bug);
	  			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsp/successnewbug.jsp");
	  			dispatch.forward(request, response);
	  			return;
	  		} catch (ServletException e1) {
	  			// TODO Auto-generated catch block
	  			e1.printStackTrace();
	  		} catch (IOException e1) {
	  			// TODO Auto-generated catch block
	  			e1.printStackTrace();
	  		}
	      }else {
	    	  // failed to add
	      }
	}


	private void searchemp(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("firstname");
		String lasttname = request.getParameter("lasttname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		 PrintWriter out;
		// this block is to test the Servlet & web.xml is working and configure properly.
	      try {
	    	   out = response.getWriter(); 
	    	 
				
				 out.println("<!DOCTYPE html>");
		         out.println("<html><head>");
		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		         out.println("<title>Hello, World</title></head>");
		         out.println("<body>");
		         out.println("<h1>Hello, world! You have successfully submitted to this Servlet..It's working</h1>");  // says Hello
		         out.println("<h1>Search Employee Page</h1>");
		         // Echo client's submitted information
		         out.println("<p>Group Name Search: " + firstname + "</p>");
		         out.println("<p>User Name Search: " + lasttname + "</p>");
		         out.println("<p>Email search: " + email + "</p>");
		         out.println("<p>Phone search: " + phone + "</p>");
		         
		         
		         out.println("</body>");
		         out.println("</html>");
			
		         out.close();
	      }catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      }
	}


	private void newemployee(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("firstname");
		String lasttname = request.getParameter("lasttname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		 PrintWriter out;
		// this block is to test the Servlet & web.xml is working and configure properly.
//	      try {
//	    	   out = response.getWriter(); 
//	    	 
//				
//				 out.println("<!DOCTYPE html>");
//		         out.println("<html><head>");
//		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
//		         out.println("<title>Hello, World</title></head>");
//		         out.println("<body>");
//		         out.println("<h1>You have successfully submitted to this Servlet..It's working</h1>");  // says Hello
//		         out.println("<h1>New Employee Page</h1>");  // says Hello
//		         // Echo client's submitted information
//		         out.println("<p>Group Name Search: " + firstname + "</p>");
//		         out.println("<p>User Name Search: " + lasttname + "</p>");
//		         out.println("<p>Email search: " + email + "</p>");
//		         out.println("<p>Phone search: " + phone + "</p>");
//		         
//		         
//		         out.println("</body>");
//		         out.println("</html>");
//			
//		         out.close();
//	      }catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//	      }
		
	      try {
			if(db.anewEmployee(firstname, lasttname, email)) {
				RequestDispatcher dispatch =	request.getRequestDispatcher("listallemployees");
				try {
					dispatch.forward(request, response);
					return;
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void searchgroup(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String gnamesearch = request.getParameter("gnamesearch");
				String usernamesearch = request.getParameter("usernamesearch");
				String emailsearch = request.getParameter("emailsearch");
				 PrintWriter out;
				// this block is to test the Servlet & web.xml is working and configure properly.
			      try {
			    	   out = response.getWriter(); 
			    	 
						
						 out.println("<!DOCTYPE html>");
				         out.println("<html><head>");
				         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
				         out.println("<title>Hello, World</title></head>");
				         out.println("<body>");
				         out.println("<h1>Hello, world! You have successfully submitted to this Servlet..It's working</h1>");  // says Hello
				         out.println("<h1>Search Group Page</h1>");
				         // Echo client's submitted information
				         out.println("<p>Group Name Search: " + gnamesearch + "</p>");
				         out.println("<p>User Name Search: " + usernamesearch + "</p>");
				         out.println("<p>Email search: " + emailsearch + "</p>");
				         
				         
				         
				         out.println("</body>");
				         out.println("</html>");
					
				         out.close();
			      }catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
			      }
		
	}


	private void gohome(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				
				 PrintWriter out;
				// this block is to test the Servlet & web.xml is working and configure properly.
			      try {
			    	   	out = response.getWriter(); 			    	 
						
						 out.println("<!DOCTYPE html>");
				         out.println("<html><head>");
				         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
				         out.println("<title>Hello, World</title></head>");
				         out.println("<body>");
				         out.println("<h1>Hello, world! </h1>");  // says Hello 
				         out.println("<h1>You have reached the gohome page by some strange reason. </h1>");			         
				         out.println("</body>");
				         out.println("</html>");
					
				         out.close();
			      }catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
			      }
	}


	private void newgroup(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String gname = request.getParameter("groupname");
		String gtype = request.getParameter("type");
		String email = request.getParameter("email");
		 PrintWriter out;
		// this block is to test the Servlet & web.xml is working and configure properly.
//	      try {
//	    	   out = response.getWriter(); 
//	    	 
//				
//				 out.println("<!DOCTYPE html>");
//		         out.println("<html><head>");
//		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
//		         out.println("<title>Hello, World</title></head>");
//		         out.println("<body>");
//		         out.println("<h1>Hello, world! You have successfully submitted to this Servlet..It's working</h1>");  // says Hello
//		         out.println("<h1>New Group Page</h1>");
//		         // Echo client's submitted information
//		         out.println("<p>Group Name: " + gname + "</p>");
//		         out.println("<p>Group Type: " + gtype + "</p>");
//		         out.println("<p>Email: " + email + "</p>");
//		         
//		         
//		         
//		         out.println("</body>");
//		         out.println("</html>");
//			
//		         out.close();
//	      }catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//	      }
	      
	      try {
			db.anewTeam(gname, email); // send to DB to add new group
			// go to the list all groups
			ArrayList<Group> groups = db.getallGroups();
			request.setAttribute("groups", groups);
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/listallgroups.jsp");
			try {
				dis.forward(request, response);
			} catch (ServletException | IOException e) {
				System.out.println("error listallgroups, line 168:ControllerServlet");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
