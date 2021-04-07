package com.wolken.wolkenapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wolken.wolkenapp.exceptions.InvalidInputException;
import com.wolken.wolkenapp.service.LibraryService;
import com.wolken.wolkenapp.service.LibraryServiceImpl;

/**
 * Servlet implementation class DeleteLibraryServlet
 */
@WebServlet(urlPatterns="/delete", loadOnStartup = +1)
public class DeleteLibraryServlet extends HttpServlet {
	LibraryService service = new LibraryServiceImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteLibraryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int libraryID = Integer.parseInt(request.getParameter("libraryID"));
		
		String message = "";
		try {
			service.validatedeleteByID(libraryID);
			message = "SUCCESSFULLY DELETED"; 
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			message = "SOME ERROR OCCURRED WHILE DELETING";
			e.printStackTrace();
		} finally {
			PrintWriter printWriter = response.getWriter();
			response.setContentType("text/html");
			printWriter.print("<center><h2> "+ message+"</h2><a href='http://localhost:8080/library-maven'>Home Page</a></center>");
			printWriter.flush();
			printWriter.close();
		}
		
		
	}

}
