package com.wolken.wolkenapp.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wolken.wolkenapp.Exceptions.DTONullException;
import com.wolken.wolkenapp.Exceptions.InvalidInputException;
import com.wolken.wolkenapp.Exceptions.SessionException;
import com.wolken.wolkenapp.Exceptions.TransactionException;
import com.wolken.wolkenapp.dao.LoginDAO;
import com.wolken.wolkenapp.dto.LoginDTO;
import com.wolken.wolkenapp.entity.LoginEntity;

@Component
public class LoginServiceImpl implements LoginService {
	Logger logger = Logger.getLogger("LoginServiceImpl");
	LoginEntity entity = new LoginEntity();
	
	@Autowired
	LoginDAO dao;
	@Autowired
	LoginDTO dto;

	@Override
	public String validateAndAdd(LoginDTO dto)throws DTONullException,InvalidInputException,TransactionException,SessionException {
		// TODO Auto-generated method stub
		
		if(dto != null) {
			if(dto.getContact_number() > 0 && !dto.getDateOfBirth().equals(null) && !dto.getEmailID().equals(null) && !dto.getGender().equals(null) && !dto.getUserName().equals(null) && !dto.getPassword().equals(null) ) {
				
				entity = dao.getUserByUserName(dto.getUserName());
		if(entity != null) {
			return "user already exists";
		}
		else {
			LoginEntity entity=new LoginEntity();
			
			logger.info("VALIDATE AND ALL THE DETAILS");
			entity.setContact_number(dto.getContact_number());
			entity.setDateOfBirth(dto.getDateOfBirth());
			entity.setEmailID(dto.getEmailID());
			entity.setGender(dto.getGender());
			entity.setUserName(dto.getUserName());
			entity.setPassword(dto.getPassword());
			entity.setConfirmPassword(dto.getConfirmPassword());
			return dao.addAndSave(entity);
			}
		
			}
			throw new InvalidInputException("Invalid Input!! Please enter the valid Input");
		}
		throw new DTONullException("DTO is Null!! Operations Cannot be performed");
	}


}

