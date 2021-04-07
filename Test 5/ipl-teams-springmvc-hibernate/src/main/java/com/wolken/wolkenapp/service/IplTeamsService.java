package com.wolken.wolkenapp.service;

import java.util.List;

import com.wolken.wolkenapp.dto.IplTeamsDTO;
import com.wolken.wolkenapp.exceptions.DTONullException;
import com.wolken.wolkenapp.exceptions.InvalidInputException;
import com.wolken.wolkenapp.exceptions.SessionException;
import com.wolken.wolkenapp.exceptions.TransactionCommittException;

public interface IplTeamsService {

	public String add(IplTeamsDTO dto) throws DTONullException, InvalidInputException, TransactionCommittException, SessionException;
	public List<IplTeamsDTO> getAll() throws SessionException;
	public String updateByID(int id, String name) throws InvalidInputException, SessionException;
	public String deleteByID(int id) throws InvalidInputException, SessionException;
}
