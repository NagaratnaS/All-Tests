package com.wolken.wolkenapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "login_table")
public class LoginEntity {
	@Id
	@Column(name = "contact_number")
	private long contact_number;
	@Column(name = "userName")
	private String userName;
	@Column(name = "gender")
	private String gender;
	@Column(name = "emailID")
	private String emailID;
	@Column(name = "dateOfBirth")
	private String dateOfBirth;
	@Column(name = "password")
	private String password;
	@Transient
	private String confirmPassword;

}
