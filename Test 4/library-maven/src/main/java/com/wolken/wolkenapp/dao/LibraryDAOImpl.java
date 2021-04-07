package com.wolken.wolkenapp.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.wolken.wolkenapp.dto.LibraryDTO;

public class LibraryDAOImpl implements LibraryDAO{
	Logger logger = Logger.getLogger("LibraryDAOImpl");

	@Override
	public boolean addLibrary(LibraryDTO dto) {
		// TODO Auto-generated method stub
		logger.info("Got the data from service.. processing it");
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(LibraryDTO.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(dto);
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Add Library Transaction committed");
		session.close();
		return false;
	}

	@Override
	public List<LibraryDTO> getAll() {
		// TODO Auto-generated method stub
		logger.info("Got the request .. prcessing it");
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(LibraryDTO.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.getNamedQuery("selectAll");
		logger.info("Query Executed..");
		List<LibraryDTO> libraryDTOs = null;
		try {
			libraryDTOs = query.list();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		libraryDTOs.forEach(System.out::print); // lambda
		//System.out.println(libraryDTOs);
		logger.info(libraryDTOs);
		
		return libraryDTOs;

		
	}

	@Override
	public void updateByID(int libraryID, String libraryName) {
		// TODO Auto-generated method stub
		logger.info("Got the data from service.. processing it");
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(LibraryDTO.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.getNamedQuery("updateone");
		query.setParameter("b1",libraryName);
		query.setParameter("id1",libraryID);
		try {
			query.executeUpdate();
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		logger.info("Transaction committed..");
		session.clear();
		
	}

	@Override
	public void deleteByID(int libraryID) {
		// TODO Auto-generated method stub
		logger.info("Got the data from service.. processing it");
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(LibraryDTO.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.getNamedQuery("deleteone");
		query.setParameter("id1", libraryID);
		try {
			query.executeUpdate();
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Transaction committed..");
		session.clear();
	}

}
