package com.wolken.wolkenapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wolken.wolkenapp.dto.LibraryDTO;
import com.wolken.wolkenapp.service.LibraryService;
import com.wolken.wolkenapp.service.LibraryServiceImpl;

/**
 * Servlet implementation class GetAllLibrary
 */
@WebServlet(urlPatterns = "/getAll", loadOnStartup = +1)
public class GetAllLibrary extends HttpServlet {
	LibraryService service = new LibraryServiceImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllLibrary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<LibraryDTO> librarydtos = service.validategetAll();
		PrintWriter printWriter = response.getWriter();
		response.setContentType("text/html");
		printWriter.print("<center><h2>CHECK CONSOLE FOR RESULTS</h2><a href='http://localhost:8080/library-maven/' > HOME PAGE </a>");
		printWriter.print("<table style=\"width:40%\">");
		printWriter.print("<tr><th>Library ID</th><th>Library Name</th><th>Number of Books</th></tr>");
		for (LibraryDTO dto : librarydtos) {
			printWriter.print("<tr>");
			printWriter.print("<td>"+dto.getLibraryID()+"</td>");  //<p>12</p>
			printWriter.print("<td>"+dto.getLibraryName()+"</td>");
			printWriter.print("<td>"+dto.getNoOfBooks()+"</td>");
			printWriter.print("</tr>");
		}
		printWriter.print("</table></center>");
		printWriter.flush();
		printWriter.close();
	}

}
