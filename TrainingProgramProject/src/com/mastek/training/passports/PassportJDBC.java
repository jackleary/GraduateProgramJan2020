package com.mastek.training.passports;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;

public class PassportJDBC implements PassportDAO<PassportInfo>{
	
Connection conMysql;
	
	public PassportJDBC() {
		try {
			//1. Load the database driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. Open connection to MySql 
			conMysql = DriverManager.getConnection(
					// connection string to identify database
						"jdbc:mysql://localhost:3306/graduate_2020_masteknet",
						"root", // username
						"root"); // password
			System.out.println("Connection successful");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public PassportInfo add(PassportInfo newPassport) {
		
		//1. define query in SQL format with parameters if required 
		String sqlInsert = "Insert into passports" 
				+ "(address, city, county, name, passport_number, postcode, dob, expirary_date, issue_date, sex) " 
				+ "Values(?,?,?,?,?,?,?,?,?,?)";
		//2. Prepare statement object for query
		try (PreparedStatement psInsert = conMysql.prepareStatement(sqlInsert)){
			//3. set all parameters required in query
				psInsert.setString(1, newPassport.getAddress());
				psInsert.setString(2, newPassport.getCity());
				psInsert.setString(3, newPassport.getCounty());
				psInsert.setString(4, newPassport.getName());
				psInsert.setString(5, newPassport.getPassportNumber());
				psInsert.setString(6, newPassport.getPostcode());
				psInsert.setDate(7, Date.valueOf(newPassport.getDateOfBirth()));
				psInsert.setDate(8, Date.valueOf(newPassport.getExpiaryDate()));
				psInsert.setDate(9, Date.valueOf(newPassport.getIssueDate()));
				psInsert.setString(10, newPassport.getSex().toString());
				
				
				//4. execute query on database table to return rows affected
				int recordsAffected = psInsert.executeUpdate(); // INSERT/UPDATE/DELETE SQLs
				
				System.out.println(recordsAffected+ " Passport Inserted");
		} catch (Exception e) {
			e.printStackTrace();
			newPassport = null; // return null in case of failure of query
		}
		return newPassport;
	}

//	@Override
//	public Collection<PassportInfo> listAll() {
//		String sqlSelectAll = "select * from passports";
//		List<PassportInfo> passports = new LinkedList<PassportInfo>();
//		
//		try(Statement stSelectAll = conMysql.createStatement()) {
//			ResultSet rsPassports = stSelectAll.executeQuery(sqlSelectAll);
//			while(rsPassports.next()) { // loop until ResultSet has next record
//				// create object for each record in DB
//				PassportInfo p = new PassportInfo();
//				
//				// read data from current row using ResultSet
//				p.setPassportNumber(rsPassports.getString("passportNumber"));
//				p.setName(rsPassports.getString("name"));
//				p.setAddress(rsPassports.getString("address"));
//				p.setCity(rsPassports.getString("city"));
//				p.setDateOfBirth(rsPassports.getDate("dob")));
//				p.setCounty(rsPassports.getString("county"));
//				p.setCounty(rsPassports.getString("county"));
//				p.setCounty(rsPassports.getString("county"));
//				
//				
//				// add data to collection
//				passports.add(p);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return passports; // return collection with employees fetched from DB
//	}

//	@Override
//	public PassportInfo find(int key) {
//		String findSQL = "select * from passports where passport_number=?";
//		PassportInfo pass = null;
//		
//		try(PreparedStatement psFind = conMysql.prepareStatement(findSQL)) {
//			
//			psFind.setInt(1, key); // set passport number for search
//			
//			ResultSet rsFindResult = psFind.executeQuery();
//			
//			if(rsFindResult.next()) {
//				pass = new PassportInfo();
//				pass.setEmpno(rsFindResult.getInt("empno"));
//				pass.setName(rsFindResult.getString("name"));
//				pass.setUnitDaySalary(rsFindResult.getDouble("unit_salary"));
//				pass.setGrade(Grades.valueOf(rsFindResult.getString("grade")));
//				pass.setDesignation(Designations.valueOf(rsFindResult.getString("designation")));
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return emp;
//	}	

//	@Override
//	public PassportInfo remove(int key) {
//		Employee empToBeRemoved = find(key);
//		if(empToBeRemoved!=null) {
//			String sqlDelete = "delete from jdbc_employees where empno=?";
//			
//			try(PreparedStatement psDelete = conMysql.prepareStatement(sqlDelete)) {
//				
//				psDelete.setInt(1, key);
//				
//				int rowsDeleted = psDelete.executeUpdate();
//				System.out.println(rowsDeleted+ " Employee deleted");
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return empToBeRemoved;
//		}
//		
//		return null;
//	}

}
