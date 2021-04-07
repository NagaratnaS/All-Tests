package com.wolken.wolkenapp.dao;

import java.util.logging.Logger;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import com.wolken.wolkenapp.Exceptions.SessionException;
import com.wolken.wolkenapp.Exceptions.TransactionException;
import com.wolken.wolkenapp.dto.LoginDTO;
import com.wolken.wolkenapp.entity.LoginEntity;

@Component
public class LoginDAOImpl implements LoginDAO {
	LoginEntity entity = new LoginEntity();
	Logger logger = Logger.getLogger("LoginDAOImpl");
	@Autowired
	LocalSessionFactoryBean bean;

	@Override
	public String addAndSave(LoginEntity entity) throws SessionException, TransactionException {
		// TODO Auto-generated method stub
		logger.info("GOT THE DATA FROM THE SERVICE AND PROCESSIONG IT");
		SessionFactory factory = null;
		try {
			factory = bean.getObject();
		} catch (Exception e) {
			throw new SessionException("Some error occured while creating the session!!");
		}
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		} catch (Exception e) {
			throw new TransactionException("Some error occured while creating the transaction");
		}
		session.close();
		logger.info("SESSION CLOSED");
		return "data added";
	}
	
	public LoginEntity getUserByUserName(String userName) {
		SessionFactory factory = bean.getObject();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction() ;
		Query query = session.createQuery(" from LoginEntity le where le.userName =:userName").setParameter("userName", userName);
		LoginEntity entity = (LoginEntity)query.uniqueResult();
		return entity;
		
	}
	

}
