package com.wolken.wolkenapp.service;

import com.wolken.wolkenapp.dto.GunsDTO;
import com.wolken.wolkenapp.exceptions.InvalidInputException;

public interface GunsService {
	
	public boolean validateAndAdd(GunsDTO dto) throws InvalidInputException;
	public boolean validateAndGetAll();
	public boolean validateAndDeleteByGundID(int id) throws InvalidInputException;
	public boolean validateAndUpdateByGunsID(int id) throws InvalidInputException;
	public boolean validateAndGetAllByBrandName(String brandname) throws InvalidInputException;
	public boolean validateAndGetAllByCountryName(String countryname) throws InvalidInputException;
	
	
;}
