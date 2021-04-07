package com.wolken.wolkenapp.dao;

import com.wolken.wolkenapp.dao.exceptions.*;
import com.wolken.wolkenapp.dto.MobileDTO;

public interface MobileDAO {
	
	public boolean add(MobileDTO dto);
	public void getAll();
	public MobileDTO updateBySerialNumber(int serialNumber) throws InvalidSerialNumberException;
	public MobileDTO deleteByMobileID(int id) throws InvalidIDException;
	public void getAllByBrandName(String brandName) throws InvalidBrandNameException;
	
	
}
