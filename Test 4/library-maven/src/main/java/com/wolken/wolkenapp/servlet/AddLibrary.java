package com.wolken.wolkenapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wolken.wolkenapp.dto.LibraryDTO;
import com.wolken.wolkenapp.exceptions.InvalidInputException;
import com.wolken.wolkenapp.service.LibraryService;
import com.wolken.wolkenapp.service.LibraryServiceImpl;

/**
 * Servlet implementation class AddLibrary
 */
@WebServlet(urlPatterns = "/add", loadOnStartup = +1)
public class AddLibrary extends HttpServlet {
	LibraryService service = new LibraryServiceImpl();
	LibraryDTO dto = new LibraryDTO();
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddLibrary() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. get the data from req
		int libraryID = Integer.parseInt(request.getParameter("libraryID"));
		String libraryName = request.getParameter("libraryName");
		int noOfBooks = Integer.parseInt(request.getParameter("noOfBooks"));
		
		//2. process the data
		dto.setLibraryID(libraryID);
		dto.setLibraryName(libraryName);
		dto.setNoOfBooks(noOfBooks);
		try {
			service.validateaddLibrary(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3. response
		PrintWriter printWriter = response.getWriter();
		response.setContentType("text/html");
		printWriter.print("<center><h2>SUCCESSFULLY ADDED</h2><a href='http://localhost:8080/library-maven' > HOME PAGE </a></center>");

		printWriter.flush();
		printWriter.close();
	}

}
