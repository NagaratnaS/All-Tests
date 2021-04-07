package com.wolken.wolkenapp.service;

import com.wolken.wolkenapp.Exceptions.DTONullException;
import com.wolken.wolkenapp.Exceptions.InvalidInputException;
import com.wolken.wolkenapp.Exceptions.SessionException;
import com.wolken.wolkenapp.Exceptions.TransactionException;
import com.wolken.wolkenapp.dto.LoginDTO;

public interface LoginService {
	public String validateAndAdd(LoginDTO dto) throws DTONullException, InvalidInputException, TransactionException, SessionException, TransactionException;

}
