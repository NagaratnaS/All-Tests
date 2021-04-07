package com.wolken.wolkenapp.service;

import java.util.List;

import com.wolken.wolkenapp.dao.LibraryDAO;
import com.wolken.wolkenapp.dao.LibraryDAOImpl;
import com.wolken.wolkenapp.dto.LibraryDTO;
import com.wolken.wolkenapp.exceptions.InvalidInputException;
import com.wolken.wolkenapp.exceptions.NullDTOException;

public class LibraryServiceImpl implements LibraryService{
	
	LibraryDAO dao = new LibraryDAOImpl();

	@Override
	public boolean validateaddLibrary(LibraryDTO dto) throws InvalidInputException, NullDTOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				if (dto != null) {
					if (dto.getLibraryID()> 0 && !dto.getLibraryName().equals(null)) {
						dao.addLibrary(dto);
						return true;
					}
					throw new InvalidInputException("Some inputs are invalid..");
				}
				throw new NullDTOException("DTO is null..");
	}

	@Override
	public List<LibraryDTO> validategetAll() {
		// TODO Auto-generated method stub

		return dao.getAll();
	}

	@Override
	public boolean validateupdateByID(int libraryID, String libraryName) throws InvalidInputException {
		// TODO Auto-generated method stub
		if(libraryID > 0 && !libraryName.equals(null)) {
			dao.updateByID(libraryID,libraryName);
			return true;
		}
		throw new InvalidInputException("Invalid ID or library name");
	}

	@Override
	public boolean validatedeleteByID(int libraryID) throws InvalidInputException {
		// TODO Auto-generated method stub
		if (libraryID > 0) {
			dao.deleteByID(libraryID);
			return true;
		}
		throw new InvalidInputException("Invalid ID");
	}

}
