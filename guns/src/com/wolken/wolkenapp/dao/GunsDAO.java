package com.wolken.wolkenapp.dao;

import com.wolken.wolkenapp.dto.GunsDTO;

public interface GunsDAO {
	
	public GunsDTO add(GunsDTO dto);
	public void getAll();
	public GunsDTO deleteByGunsID(int id);
	public GunsDTO updateByGunsID(int id); 
	public void getAllByBrandName(String brandname);
	public void getAllByCountryName(String countryname); 

}
