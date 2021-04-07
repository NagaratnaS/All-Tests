package com.wolken.wolkenapp.service;

import com.wolken.wolkenapp.dao.GunsDAO;
import com.wolken.wolkenapp.dao.GunsDAOImpl;
import com.wolken.wolkenapp.dto.GunsDTO;
import com.wolken.wolkenapp.exceptions.InvalidInputException;

public class GunsServiceImpl implements GunsService {

	GunsDAO dao = new GunsDAOImpl();
	@Override
	public boolean validateAndAdd(GunsDTO dto) throws InvalidInputException {
		// TODO Auto-generated method stub
		if (dto != null) {
			if (dto.getId() < 0 && dto.getName().equals(null) && dto.getPrice() < 0 && dto.getSerialnumber()<0)
				throw new InvalidInputException("Inavlid Inputs!!");
			dao.add(dto);
			return true;
		}
		throw new InvalidInputException("DTO is null!!");
	}

	@Override
	public boolean validateAndGetAll() {
		// TODO Auto-generated method stub
		dao.getAll();
		return true;
	}

	@Override
	public boolean validateAndDeleteByGundID(int id) throws InvalidInputException {
		// TODO Auto-generated method stub
		if (id < 0)
			throw new InvalidInputException("ID should be > 0");
		GunsDTO dto = dao.deleteByGunsID(id);
		return true;
	}

	@Override
	public boolean validateAndUpdateByGunsID(int id) throws InvalidInputException {
		// TODO Auto-generated method stub
		if (id < 0)
			throw new InvalidInputException("ID should be > 0");
		GunsDTO dto = dao.updateByGunsID(id);
		return true;
	}

	@Override
	public boolean validateAndGetAllByBrandName(String brandname) throws InvalidInputException {
		if (brandname.equals(null))
			throw new InvalidInputException("Brandname should not be null");
		dao.getAllByBrandName(brandname);
		return true;
	}

	@Override
	public boolean validateAndGetAllByCountryName(String countryname) throws InvalidInputException {
		// TODO Auto-generated method stub
		if (countryname.equals(null))
			throw new InvalidInputException("Country name should not be null");
		dao.getAllByCountryName(countryname);
		return true;
	}

}
