package com.wolken.wolkenapp.dao.exceptions;

public class InvalidIDException extends Exception {

	private String msg;
	public InvalidIDException(String msg) {
		super(msg);
		this.msg = msg;
	}
}

