package com.wolken.wolkenapp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@NamedQueries({
	@NamedQuery(name = "updateone",query = "update LibraryDTO dto set dto.libraryName =:b1 where dto.libraryID=:id1"),
	@NamedQuery(name = "selectAll", query = "from LibraryDTO dto"),
	@NamedQuery(name = "deleteone",query = "delete LibraryDTO dto where dto.libraryID=:id1")
})
@Entity
@ToString
@Table(name = "library")
public class LibraryDTO {
	@Id
	@Column(name = "libraryID")
	private int libraryID;
	
	@Column(name = "libraryName")
	private String libraryName;
	
	@Column(name = "noOfBooks")
	private int noOfBooks;

}
