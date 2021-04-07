package com.wolken.wolkenapp.dao;

import com.wolken.wolkenapp.dao.exceptions.*;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

import com.wolken.wolkenapp.dto.MobileDTO;

import com.wolken.wolkenapp.dto.MobileDTO;
public class MobileDAOImpl implements MobileDAO{

	private List<MobileDTO> mobileDTOs;
	
	//[<"mi", 1, 4, 10000, ....>, <"samsung", 2 , 6 , 30000> ......]
	
	public MobileDAOImpl(List<MobileDTO> mobileDTO) {
		this.mobileDTOs = mobileDTO;
	}
	
	@Override
	public boolean add(MobileDTO dto) {
		// TODO Auto-generated method stub
		
		boolean check = mobileDTOs.contains(dto);
		
		if (check == false) { // the dto object is not there in the list
			this.mobileDTOs.add(dto);
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<mobileDTOs.size();i++) {
			System.out.print("MobileID: "+mobileDTOs.get(i).getMobileID()+ "  ");
			System.out.print("BrandName: "+mobileDTOs.get(i).getBrandName()+ "  ");
			System.out.print("Memory: "+mobileDTOs.get(i).getMemory()+ "  ");
			System.out.print("ModelName: "+mobileDTOs.get(i).getModelName()+ "  ");
			System.out.print("NoOfCameras: "+mobileDTOs.get(i).getNoOfCameras()+ "  ");
			System.out.print("Price: "+mobileDTOs.get(i).getPrice()+ "  ");
			System.out.print("SerialNo: "+mobileDTOs.get(i).getSerialNo()+ "  \n");
		}
		
	}

	@Override
	public MobileDTO updateBySerialNumber(int serialNumber) throws InvalidSerialNumberException {
		// TODO Auto-generated method stub
		/* int mobileID;
		 String modelName;
		 int price;
		 int memory;
		 String brandName;
		 int serialNo;
		 int noOfCameras;*/
		 
		 MobileDTO updatedDTO = null;

		 for(int i=0;i<mobileDTOs.size();i++) {
				if (mobileDTOs.get(i).getSerialNo() == serialNumber) {
					Scanner sc = new Scanner(System.in);
					System.out.println(" Enter 1.mobileID  2.modelName  3.price  4.memory  5.brandname  6.serialNo  7.noOfCameras values to update");
					mobileDTOs.get(i).setMobileID(sc.nextInt());
					mobileDTOs.get(i).setModelName(sc.next());
					mobileDTOs.get(i).setPrice(sc.nextInt());
					mobileDTOs.get(i).setMemory(sc.nextInt());
					mobileDTOs.get(i).setBrandName(sc.next());
					mobileDTOs.get(i).setSerialNo(sc.nextInt());
					mobileDTOs.get(i).setNoOfCameras(sc.nextInt());
					updatedDTO = mobileDTOs.get(i);
					break;
				}
		
			}
		 
		 if (updatedDTO == null)
			 throw new InvalidSerialNumberException("Mobile with given serial number does not exist!!");
		 
	
		 
		
		return updatedDTO;
	}

	@Override
	public MobileDTO deleteByMobileID(int id) throws InvalidIDException{
		// TODO Auto-generated method stub
		MobileDTO deletedDTO = null;
		for(int i=0;i<mobileDTOs.size();i++) {
			if (mobileDTOs.get(i).getMobileID() == id) {
				deletedDTO = mobileDTOs.get(i);
				mobileDTOs.remove(i);
			}
		}
		
		if (deletedDTO == null) {
			throw new InvalidIDException("Mobile with given ID does not exist");
		}
		
		return deletedDTO;
		
	}

	@Override
	public void getAllByBrandName(String brandName) throws InvalidBrandNameException{
		// TODO Auto-generated method stub
		boolean flag = false;
		for(int i=0;i<mobileDTOs.size();i++) {
			if (mobileDTOs.get(i).getBrandName().equals(brandName)) {
				flag = true;
				System.out.print("MobileID: "+mobileDTOs.get(i).getMobileID()+ "  ");
				System.out.print("BrandName: "+mobileDTOs.get(i).getBrandName()+ "  ");
				System.out.print("Memory: "+mobileDTOs.get(i).getMemory()+ "  ");
				System.out.print("ModelName: "+mobileDTOs.get(i).getModelName()+ "  ");
				System.out.print("NoOfCameras: "+mobileDTOs.get(i).getNoOfCameras()+ "  ");
				System.out.print("Price: "+mobileDTOs.get(i).getPrice()+ "  ");
				System.out.print("SerialNo: "+mobileDTOs.get(i).getSerialNo()+ "  \n");
			}
	
		}
		
		if (!flag)
			throw new InvalidBrandNameException("Brand name does not exists!!");
		
	}

}
