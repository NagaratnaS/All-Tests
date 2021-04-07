package com.wolken.wolkenapp.service;

import java.util.List;

import com.wolken.wolkenapp.dto.LibraryDTO;
import com.wolken.wolkenapp.exceptions.InvalidInputException;
import com.wolken.wolkenapp.exceptions.NullDTOException;

public interface LibraryService {
	public boolean validateaddLibrary(LibraryDTO dto) throws InvalidInputException, NullDTOException;
	public List<LibraryDTO> validategetAll();
	public boolean validateupdateByID(int libraryID,String libraryName) throws InvalidInputException;
	public boolean validatedeleteByID(int libraryID) throws InvalidInputException;

}
