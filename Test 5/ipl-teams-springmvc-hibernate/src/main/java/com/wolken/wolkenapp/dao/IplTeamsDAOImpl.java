package com.wolken.wolkenapp.dao;




import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import com.wolken.wolkenapp.dto.IplTeamsDTO;
import com.wolken.wolkenapp.exceptions.SessionException;
import com.wolken.wolkenapp.exceptions.TransactionCommittException;


@Component
public class IplTeamsDAOImpl implements IplTeamsDAO{
	Logger logger = Logger.getLogger("IplTeamsDAOImpl");
	@Autowired
	LocalSessionFactoryBean bean;

	@Override
	public String save(IplTeamsDTO dto) throws TransactionCommittException,SessionException{
		// TODO Auto-generated method stub
		//Configuration configuration = bean.getConfiguration();
		//configuration.configure();
		//SessionFactory factory = configuration.buildSessionFactory();
//	BasicDataSource basicDataSource = new BasicDataSource();
//		basicDataSource.setDriver("com.mysql.cj.jdbc.Driver");
//		basicDataSource.setUrl("");
//		basicDataSource.setUsername("");
//		basicDataSource.setPassword("");
		logger.info("GOT THE DATA FROM SERVICE AND PROCESSING IT");
		SessionFactory factory = null;
		try {
		factory = bean.getObject();
		}catch(Exception e) {
			throw new SessionException("Some error occured while creating the session");
		}
		//bean.setDataSource(basicDataSource);
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
		transaction = session.beginTransaction();
		
		session.save(dto);
		transaction.commit();
		}catch(Exception e){
			throw new TransactionCommittException("Some error occured while committing the transaction");
		}
		session.close();
		logger.info("SESSION CLOSED");
		
		return "data added";
		
	}

	@Override
	public List<IplTeamsDTO> getAll() throws SessionException {
		// TODO Auto-generated method stub
		logger.info("PROCESSING THE REQUEST");
		SessionFactory factory = null;
		try {
		factory = bean.getObject();
		}catch(Exception e) {
			throw new SessionException("Some error occured while creating the session");
		}
		Session session = factory.openSession();
		Transaction transaction  = null;
		transaction = session.beginTransaction();
		
		Query query = session.getNamedQuery("selectAll");
		List<IplTeamsDTO> iplTeamsDTOs = null;
		try {
			iplTeamsDTOs = query.list();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		iplTeamsDTOs.forEach(System.out::print);
		
		return iplTeamsDTOs;
	}

	@Override
	public String updateByID(int id, String teamName) throws SessionException{
		// TODO Auto-generated method stub
		logger.info("UPDATING THE DATA REQUESTED");
		SessionFactory factory = null;
		try {
		factory = bean.getObject();
		}catch(Exception e) {
			throw new SessionException("Some error occured while creating the session");
		}
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.getNamedQuery("updateone");
		query.setParameter("b1",teamName);
		query.setParameter("id1", id);
		
		try {
			query.executeUpdate();
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "Updated Successfully!";
	}

	@Override
	public String deleteByID(int id) throws SessionException{
		// TODO Auto-generated method stub
		logger.info("DELETING THE REQUESTED DATA");
		SessionFactory factory = null;
		try{
		factory = bean.getObject();
		}catch(Exception e) {
			throw new SessionException("Some error occured while creating the session");
		}
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.getNamedQuery("deleteone");
		query.setParameter("id1", id);
		
		try {
			query.executeUpdate();
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "Deleted Successfully!";
	}
 
	

}
