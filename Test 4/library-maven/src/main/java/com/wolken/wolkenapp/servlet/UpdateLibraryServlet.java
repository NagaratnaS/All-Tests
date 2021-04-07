package com.wolken.wolkenapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wolken.wolkenapp.exceptions.InvalidInputException;
import com.wolken.wolkenapp.service.LibraryService;
import com.wolken.wolkenapp.service.LibraryServiceImpl;

/**
 * Servlet implementation class UpdateLibraryServlet
 */
@WebServlet(urlPatterns="/update", loadOnStartup = +1)
public class UpdateLibraryServlet extends HttpServlet {
	LibraryService service = new LibraryServiceImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLibraryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. get data from req
		int libraryID = Integer.parseInt(request.getParameter("libraryID"));
		String libraryName = request.getParameter("libraryName");
		
		try {
			service.validateupdateByID(libraryID, libraryName);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter printWriter = response.getWriter();
		response.setContentType("text/html");
		printWriter.print("<center><h2>SUCCESSFULLY UPDATED</h2><a href='http://localhost:8080/library-maven'>Home page </a></center>");
		
		printWriter.flush();
		printWriter.close();
		
	}

}
