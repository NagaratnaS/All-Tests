package com.wolken.wolkenapp.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Component
public class LoginDTO {
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private long id;
	private long contact_number;
	private String userName;
	private String gender;
	private String emailID;
	private String dateOfBirth;
	private String password;
	private String confirmPassword;
	
	

}
