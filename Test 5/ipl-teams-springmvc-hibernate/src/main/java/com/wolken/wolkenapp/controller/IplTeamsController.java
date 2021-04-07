package com.wolken.wolkenapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wolken.wolkenapp.dao.IplTeamsDAO;
import com.wolken.wolkenapp.dto.IplTeamsDTO;
import com.wolken.wolkenapp.exceptions.DTONullException;
import com.wolken.wolkenapp.exceptions.InvalidInputException;
import com.wolken.wolkenapp.exceptions.SessionException;
import com.wolken.wolkenapp.exceptions.TransactionCommittException;
import com.wolken.wolkenapp.service.IplTeamsService;

@Component
@RequestMapping("/")
public class IplTeamsController {
	
	@Autowired
	IplTeamsService service;
	
	@RequestMapping("/teams.do")
	public String save(@ModelAttribute IplTeamsDTO dto , HttpServletRequest request) {
		String message = null;
		try {
			message = service.add(dto);
		} catch (DTONullException e) {
			// TODO Auto-generated catch block
			message = "Something went wrong";
			e.printStackTrace();
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			message = "You have entered invalid input";
			e.printStackTrace();
		}
		catch(SessionException e) {
			message = "Some error occured while creating the session";
		}
		catch(TransactionCommittException e) {
			message = "Some error occured in transaction";
		}
		request.setAttribute("message", message);
		return "final.jsp";
	}
	
	@RequestMapping("/update.do")
	public String updateByID(@RequestParam("iplTeamID") int id, @RequestParam("teamName") String name, HttpServletRequest request) {
		String message = null;
		try {
			message = service.updateByID(id, name);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			message = "You have entered invalid input";
			e.printStackTrace();
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			message = "Some error occured while creating the session";
			e.printStackTrace();
		}
		System.out.println(name);
		request.setAttribute("message", message);
		
		return "updateByIDResponse.jsp";
	}
	
	@RequestMapping("/delete.do")
	public String deleteByID(@RequestParam("iplTeamID") int id, HttpServletRequest request) {
		String message = null;
		try {
			message = service.deleteByID(id);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			message = "You have entered invalid input";
			e.printStackTrace();
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			message = "Some error occured while creating the session";
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		
		return "deleteByIDResponse.jsp";
	}
	
	@RequestMapping("/getall.do") 
	public String getAll(HttpServletRequest request) throws SessionException {
		List<IplTeamsDTO> dtos = service.getAll();
		request.setAttribute("dtos", dtos);
		
		return "getAllResponse.jsp";
	}
	
	

}
