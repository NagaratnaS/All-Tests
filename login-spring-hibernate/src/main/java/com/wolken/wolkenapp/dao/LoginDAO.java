package com.wolken.wolkenapp.dao;

import com.wolken.wolkenapp.Exceptions.SessionException;
import com.wolken.wolkenapp.Exceptions.TransactionException;
import com.wolken.wolkenapp.entity.LoginEntity;

public interface LoginDAO {
	public String addAndSave(LoginEntity entity) throws SessionException, TransactionException ;
	public LoginEntity getUserByUserName(String userName);

}
