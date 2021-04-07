package com.wolken.wolkenapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wolken.wolkenapp.Exceptions.DTONullException;
import com.wolken.wolkenapp.Exceptions.InvalidInputException;
import com.wolken.wolkenapp.Exceptions.SessionException;
import com.wolken.wolkenapp.Exceptions.TransactionException;
import com.wolken.wolkenapp.dto.LoginDTO;
import com.wolken.wolkenapp.service.LoginService;

@Component
@RequestMapping("/")
public class LoginController {
	
	
	@Autowired
	LoginService service;
	@RequestMapping("/login.do")
	public String save(@ModelAttribute LoginDTO dto , HttpServletRequest request) {
		String message = null;
		System.out.println(dto.getContact_number());
		try {
			message = service.validateAndAdd(dto);
		} catch (DTONullException | InvalidInputException | TransactionException | SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("message",message);
		
		return "final.jsp";
		
	}
	

}
