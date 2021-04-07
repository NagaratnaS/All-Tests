package com.wolken.wolkenapp.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.dao.IplTeamsDAO;
import com.wolken.wolkenapp.dao.IplTeamsDAOImpl;
import com.wolken.wolkenapp.dto.IplTeamsDTO;
import com.wolken.wolkenapp.exceptions.DTONullException;
import com.wolken.wolkenapp.exceptions.InvalidInputException;
import com.wolken.wolkenapp.exceptions.SessionException;
import com.wolken.wolkenapp.exceptions.TransactionCommittException;

@Service
public class IplTeamServiceImpl implements IplTeamsService {
	Logger logger = Logger.getLogger("IplTeamServiceImpl");
	@Autowired
	IplTeamsDAO dao;

	@Override
	public String add(IplTeamsDTO dto) throws DTONullException,InvalidInputException,TransactionCommittException,SessionException{
		// TODO Auto-generated method stub
		logger.info("VALIDATE AND UPDATE BY ID");
		if (dto != null) {
			if (dto.getIplTeamID() > 0 && !dto.getCaptain().equals(null) && dto.getNo_of_teams()>0) {
				
				return dao.save(dto);
			}
		throw new InvalidInputException("Invalid input , please enter the valid input");
		}
		throw new DTONullException("DTO is null and data cannot be added");
	}

	@Override
	public List<IplTeamsDTO> getAll() throws SessionException{
		// TODO Auto-generated method stub
		logger.info("VALIDATE AND GET ALL");
		try {
			return dao.getAll();
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public String updateByID(int id, String name) throws InvalidInputException,SessionException{
		// TODO Auto-generated method stub
		logger.info("VALIDATE AND UPDATE");
		if (id > 0 && !name.equals(null)) {
			try {
				dao.updateByID(id, name);
			} catch (SessionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Updated Successfully!!";
			
		}
		throw new InvalidInputException("Update operation failed,please enter the valid ID");
	}

	@Override
	public String deleteByID(int id) throws InvalidInputException,SessionException{
		// TODO Auto-generated method stub
		logger.info("VALIDATE AND DELETE");
		if (id > 0) {
			try {
				dao.deleteByID(id);
			} catch (SessionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Delete operation done successfully!!";
		}
		throw new InvalidInputException("Delete Operation failed,please enter the valid ID");
	}

}
