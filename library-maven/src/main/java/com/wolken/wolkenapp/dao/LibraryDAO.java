package com.wolken.wolkenapp.dao;

import java.util.List;

import com.wolken.wolkenapp.dto.LibraryDTO;

public interface LibraryDAO {
	public boolean addLibrary(LibraryDTO dto);
	public List<LibraryDTO> getAll();
	public void updateByID(int libraryID,String libraryName);
	public void deleteByID(int libraryID);

}
