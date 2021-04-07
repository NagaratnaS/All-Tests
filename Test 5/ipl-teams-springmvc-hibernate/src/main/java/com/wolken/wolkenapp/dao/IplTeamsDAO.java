package com.wolken.wolkenapp.dao;

import java.util.List;

import com.wolken.wolkenapp.dto.IplTeamsDTO;
import com.wolken.wolkenapp.exceptions.SessionException;
import com.wolken.wolkenapp.exceptions.TransactionCommittException;

public interface IplTeamsDAO {
	public String save(IplTeamsDTO dto) throws TransactionCommittException, SessionException, SessionException;
	public List<IplTeamsDTO> getAll() throws SessionException;
	public String updateByID(int id, String name) throws SessionException;
	public String deleteByID(int id) throws SessionException;

}
