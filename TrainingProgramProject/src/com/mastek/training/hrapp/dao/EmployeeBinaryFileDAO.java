package com.mastek.training.hrapp.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.mastek.training.hrapp.Employee;

public class EmployeeBinaryFileDAO implements DataAccessObject<Employee> {
	
	Map<Integer, Employee> empMap;
	
	private String fileName;

	public EmployeeBinaryFileDAO(String fileName) {
		// TODO Auto-generated constructor stub
		empMap = new HashMap<Integer, Employee>();
		this.fileName = fileName;
		// read all data from file and load in collection map
		readMapFromFile();
	}
	
	
	// read data from File and add it to the map Shared
	private void readMapFromFile() {
		// ObjectInputStream: Read Object from binary FileInputStream
		// FileInputStream: Read binary data from file objects
		// File: Open or refer to file using Filename/File Path
		try (ObjectInputStream objIn = new ObjectInputStream(
											new FileInputStream(
													new File(fileName)))){
			// we use try block with resources to manage auto-closing of stream
			empMap = (Map<Integer, Employee>) objIn.readObject();
			
		} catch (Exception e) {
			System.out.println("Exception thrown");
			e.printStackTrace();
		}
	}
	
	
	// update file with Map content
	private void writeMapToFile() {
		// ObjectOutputStream: Write binary object in serialised formal in FileOutputStream
		// FileOutputStream: Write binary object to files
		// File: File object will refer to the file to be updated/created if not present
		try(ObjectOutputStream objOut = new ObjectOutputStream(
												new FileOutputStream(
														new File(fileName)))) {
			objOut.writeObject(empMap); // write all data in serialised format in the file
		} catch (Exception e) {
			System.out.println("Exception thrown");
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Employee add(Employee newEmployee) {
		// TODO Auto-generated method stub
		readMapFromFile();
		if(!empMap.containsKey(newEmployee.getEmpno())) {
			empMap.put(newEmployee.getEmpno(), newEmployee);
			// update file with new content
			writeMapToFile();
		}
		return newEmployee;
	}

	@Override
	public Collection<Employee> listAll() {
		// TODO Auto-generated method stub
		readMapFromFile();
		return empMap.values(); // return all values from map
	}

	@Override
	public Employee find(int key) {
		// TODO Auto-generated method stub
		readMapFromFile();
		return empMap.get(key);
	}

	@Override
	public Employee remove(int key) {
		// TODO Auto-generated method stub
		readMapFromFile();
		Employee removedEmp = null;
		if(empMap.containsKey(key)) {
			removedEmp = empMap.remove(key);
			writeMapToFile();
		}
		return removedEmp;
	}

}
