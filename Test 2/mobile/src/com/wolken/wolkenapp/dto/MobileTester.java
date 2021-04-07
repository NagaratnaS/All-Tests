package com.wolken.wolkenapp.dto;

import java.util.Scanner;

import com.wolken.wolkenapp.dao.*;
import com.wolken.wolkenapp.dao.exceptions.InvalidBrandNameException;
import com.wolken.wolkenapp.dao.exceptions.InvalidSerialNumberException;

import java.util.*;

public class MobileTester {
	
	public static void main(String args[]) {
	
		
		List<MobileDTO> mobileDTOList = new ArrayList<>();
		MobileDAO mobileDAO = new MobileDAOImpl(mobileDTOList);
		
		while(true) {
		System.out.println("1. Add  2. getAll  3. Delete by mobileID  4. updateBySNO  5. getAllByBrandName\n");
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
		
		switch(ch) {
		
		case 1:
			MobileDTO mobileDTO = new MobileDTO();
			System.out.println("Enter the brandName\n");
			mobileDTO.setBrandName(sc.next());
			System.out.println("Enter the memory size in GB\n");
			mobileDTO.setMemory(sc.nextInt());
			System.out.println("Enter the mobile ID\n");
			mobileDTO.setMobileID(sc.nextInt());
			System.out.println("Enter the model name\n");
			mobileDTO.setModelName(sc.next());
			System.out.println("Enter number of cameras the mobile has\n");
			mobileDTO.setNoOfCameras(sc.nextInt());
			System.out.println("Enter the price of mobile\n");
			mobileDTO.setPrice(sc.nextInt());
			System.out.println("Enter serial number of mobiles\n");
			mobileDTO.setSerialNo(sc.nextInt());
			if (mobileDAO.add(mobileDTO)) 
				System.out.println("Added Successfully\n");
			else
				System.out.println("Mobile Item Already exists");
			
			break;
		
		case 2:
			mobileDAO.getAll();
			break;
			
		case 3:
			System.out.println("Enter the mobile id to be deleted \n");
			int mobileIdTobeDeleted = sc.nextInt();
			try {
				MobileDTO deletedMobileDTO = mobileDAO.deleteByMobileID(mobileIdTobeDeleted);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			//if (deletedMobileDTO == null) 
				//System.out.println("Mobile does not exist!!");
			
			break;
			
		case 4:
			System.out.println("Enter the serial number\n");
			int serialNumber = sc.nextInt();
			MobileDTO updatedDTO;
			try {
				updatedDTO = mobileDAO.updateBySerialNumber(serialNumber);
			} catch (InvalidSerialNumberException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			break;
			
			
		case 5:
			System.out.println("Enter the brandname\n");
			String brandName = sc.next();
			try {
				mobileDAO.getAllByBrandName(brandName);
			} catch (InvalidBrandNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		default:
			System.out.println("Wrong choice!!");
			System.exit(0);
			
		}
		}
		
	}

}
