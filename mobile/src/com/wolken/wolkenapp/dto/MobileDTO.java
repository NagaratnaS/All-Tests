package com.wolken.wolkenapp.dto;

import java.io.Serializable;

public class MobileDTO implements Serializable{

	private int mobileID;
	private String modelName;
	private int price;
	private int memory;
	private String brandName;
	private int serialNo;
	private int noOfCameras;
	
	
	public int getMobileID() {
		return mobileID;
	}
	public void setMobileID(int mobileID) {
		this.mobileID = mobileID;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public int getNoOfCameras() {
		return noOfCameras;
	}
	public void setNoOfCameras(int noOfCameras) {
		this.noOfCameras = noOfCameras;
	}
	
	
}
