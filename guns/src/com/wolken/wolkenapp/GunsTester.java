package com.wolken.wolkenapp;

import java.util.Scanner;

import com.wolken.wolkenapp.dto.GunsDTO;
import com.wolken.wolkenapp.exceptions.InvalidInputException;
import com.wolken.wolkenapp.service.GunsService;
import com.wolken.wolkenapp.service.GunsServiceImpl;

public class GunsTester {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		GunsService service = new GunsServiceImpl();
		System.out.println("\n 1.add  2. getall  3.deletebyid  4.updatebyid  5.getallbybrandname  6.getallbycountryname");
		
		while(true) {
			System.out.println("Enter a choice");
			int ch = sc.nextInt();
			int id;
			switch(ch) {
			case 1:
				GunsDTO dto = new GunsDTO();
				System.out.println("\n 0.id 1.name 2.price 3. serialnumber 4.brandname 5.type 6.noofbullets  7.madein");
			    id = sc.nextInt();
				String name = sc.next();
				int price = sc.nextInt();
				int serialnumber = sc.nextInt();
				String brandname = sc.next();
				String type = sc.next();
				int noofbullets = sc.nextInt();
				String madein = sc.next();
				dto.setId(id);
				dto.setBrandname(brandname);
				dto.setMadein(madein);
				dto.setNoofbullets(noofbullets);
				dto.setPrice(price);
				dto.setType(type);
				dto.setSerialnumber(serialnumber);
				dto.setName(name);
				
				try {
					service.validateAndAdd(dto);
				} catch (InvalidInputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				service.validateAndGetAll();
				break;
				
			case 3:
				System.out.println("Enter id");
				id = sc.nextInt();
				try {
					service.validateAndDeleteByGundID(id);
				} catch (InvalidInputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Enter id");
				id = sc.nextInt();
				try {
					service.validateAndUpdateByGunsID(id);
				} catch (InvalidInputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			case 5:
				System.out.println("Enter brandname");
				String brandnametoupdate = sc.next();
				try {
					service.validateAndGetAllByBrandName(brandnametoupdate);
				} catch (InvalidInputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 6:
				System.out.println("Enter country name");
				String countryname = sc.next();
				try {
					service.validateAndGetAllByCountryName(countryname);
				} catch (InvalidInputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.exit(0);
			}
		}
		
		
	}

}
