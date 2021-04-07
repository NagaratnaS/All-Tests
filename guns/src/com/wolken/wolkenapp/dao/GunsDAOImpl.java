package com.wolken.wolkenapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.wolken.wolkenapp.dto.GunsDTO;

public class GunsDAOImpl implements GunsDAO{

	@Override
	public GunsDTO add(GunsDTO dto) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wolken?user=root&password=root");
			statement = con.createStatement();
			String INSERT_QUERY = "insert into wolken.guns values(?,?,?,?,?,?,?,?);";
			PreparedStatement preparedstatement = con.prepareStatement(INSERT_QUERY);
			preparedstatement.setInt(1, dto.getId());
			preparedstatement.setString(2, dto.getName());
			preparedstatement.setInt(3, dto.getPrice());
			preparedstatement.setInt(4, dto.getSerialnumber());
			preparedstatement.setString(5, dto.getBrandname());
			preparedstatement.setString(6, dto.getType());
			preparedstatement.setInt(7, dto.getNoofbullets());
			preparedstatement.setString(8,  dto.getMadein());
			
			preparedstatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wolken?user=root&password=root");
			statement = con.createStatement();
			
			String SELECT_QUERY = "select * from wolken.guns";
			ResultSet rs = statement.executeQuery(SELECT_QUERY);
			
			while(rs.next()) {
				System.out.print("\n ID: "+ rs.getInt("id"));
				System.out.print("  Name: "+ rs.getString("name"));
				System.out.print("  price: "+ rs.getInt("price"));
				System.out.print("  Serial Number: "+rs.getInt("serialnumber"));
				System.out.print(" BrandName: "+rs.getString("brandname"));
				System.out.print("  type: "+rs.getString("gun_type"));
				System.out.print("  Number of bullets "+ rs.getInt("noofbullets"));
				System.out.print("  made in: "+rs.getString("madein"));
			}
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		} 
		
		
		
	}

	@Override
	public GunsDTO deleteByGunsID(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wolken?user=root&password=root");
			statement = con.createStatement();
			
			String SELECT_QUERY ="select * from wolken.guns where id="+id;
			String DELETE_QUERY = "delete from wolken.guns where id="+id;
			
			PreparedStatement selectstatement = con.prepareStatement(SELECT_QUERY);
			ResultSet  rs = selectstatement.executeQuery();
			
			PreparedStatement preparedstatement = con.prepareStatement(DELETE_QUERY);
			preparedstatement.executeUpdate();
			
			GunsDTO dto = null;
			
			if (rs.next()) {
				dto = new GunsDTO();
				dto.setId(rs.getInt("id"));
				dto.setBrandname(rs.getString("brandname"));
				dto.setMadein(rs.getString("madein"));
				dto.setNoofbullets(rs.getInt("noofbullets"));
				dto.setPrice(rs.getInt("price"));
				dto.setName(rs.getString("name"));
				dto.setType(rs.getString("gun_type"));
				dto.setSerialnumber(rs.getInt("serialnumber"));
				
				return dto;
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public GunsDTO updateByGunsID(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement statement = null;
	   
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wolken?user=root&password=root");
			statement = con.createStatement();
			
			System.out.println("\n 1.name 2.price 3. serialnumber 4.brandname 5.type 6.noofbullets  7.madein");
			Scanner sc = new Scanner(System.in);
			String name = sc.next();
			int price = sc.nextInt();
			int serialnumber = sc.nextInt();
			String brandname = sc.next();
			String type = sc.next();
			int noofbullets = sc.nextInt();
			String madein = sc.next();
			
			String UPDATE_QUERY = "update wolken.guns set name=\""+name+"\", price="+price+
					",serialnumber="+serialnumber+",brandname=\""+brandname+
					"\",type=\""+type+"\",noofbullets="+noofbullets+";";
			System.out.println(UPDATE_QUERY);
			String SELECT_QUERY = "select * from wolken.guns where id="+id;
			PreparedStatement preparedStatement = con.prepareStatement( UPDATE_QUERY);
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.executeQuery(SELECT_QUERY);
			
			GunsDTO dto = null;
			if (rs.next()) {
				dto = new GunsDTO();
				dto.setId(rs.getInt("id"));
				dto.setBrandname(rs.getString("brandname"));
				dto.setMadein(rs.getString("madein"));
				dto.setNoofbullets(rs.getInt("noofbullets"));
				dto.setPrice(rs.getInt("price"));
				dto.setName(rs.getString("name"));
				dto.setType(rs.getString("type"));
				dto.setSerialnumber(rs.getInt("serialnumber"));
				
				
			}
			return dto;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void getAllByBrandName(String brandname) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wolken?user=root&password=root");
			statement = con.createStatement();
			
			String SELECT_QUERY = "select * from wolken.guns where brandname=\""+brandname+"\";";
			
			ResultSet rs = statement.executeQuery(SELECT_QUERY);
			
			while(rs.next()) {
				System.out.print("\n ID: "+ rs.getInt("id"));
				System.out.print("  Name: "+ rs.getString("name"));
				System.out.print("  price: "+ rs.getInt("price"));
				System.out.print("  Serial Number: "+rs.getInt("serialnumber"));
				System.out.print(" BrandName: "+rs.getString("brandname"));
				System.out.print("  type: "+rs.getString("gun_type"));
				System.out.print("  Number of bullets "+ rs.getInt("noofbullets"));
				System.out.print("  made in: "+rs.getString("madein"));
			}
			rs.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getAllByCountryName(String countryname) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wolken?user=root&password=root");
			statement = con.createStatement();
			
			String SELECT_QUERY = "select * from wolken.guns where madein=\""+countryname+"\";";
			ResultSet rs = statement.executeQuery(SELECT_QUERY);
			
			while(rs.next()) {
				System.out.print("\n ID: "+ rs.getInt("id"));
				System.out.print("  Name: "+ rs.getString("name"));
				System.out.print("  price: "+ rs.getInt("price"));
				System.out.print("  Serial Number: "+rs.getInt("serialnumber"));
				System.out.print(" BrandName: "+rs.getString("brandname"));
				System.out.print("  type: "+rs.getString("gun_type"));
				System.out.print("  Number of bullets "+ rs.getInt("noofbullets"));
				System.out.print("  made in: "+rs.getString("madein"));
			}
			rs.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
