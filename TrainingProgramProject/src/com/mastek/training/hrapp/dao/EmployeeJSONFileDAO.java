package com.mastek.training.hrapp.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.mastek.training.hrapp.Employee;

public class EmployeeJSONFileDAO implements DataAccessObject<Employee> {
	
	Map<Integer, Employee> empMap;
	String fileName;

	public EmployeeJSONFileDAO(String fileName) {
		empMap = new HashMap<>();
		this.fileName = fileName;
	}
	
	private void readJSOONFileData() {
		// BufferedReader: it reads line by line data from String/Text/JSOON File
		// FileReader: It reads text data from file
		// File: it helps to refer/create a File in the system
		try(BufferedReader brJSONFile = new BufferedReader(
									new FileReader(new File(fileName)))) {
			String line=brJSONFile.readLine();
			while(line!=null) {
				Employee emp = Employee.parseJSONString(line);
				empMap.put(emp.getEmpno(), emp);
				line = brJSONFile.readLine();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	private void writeJSONFileData() {
		// BufferedReader: it writes String line by line data from String/Text/JSOON File
		// FileReader: It writes text data from file
		// File: it helps to refer/create a File in the system
		try(BufferedWriter bw = new BufferedWriter(
							new FileWriter(new File(fileName)))) {
			for(Integer empno:empMap.keySet()) {
				bw.write(Employee.getJSONString(
							empMap.get(empno))+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public Employee add(Employee newEmployee) {
		readJSOONFileData();
		if(!empMap.containsKey(newEmployee.getEmpno())) {
			empMap.put(newEmployee.getEmpno(), newEmployee);
			writeJSONFileData();
		}
		return newEmployee;
	}

	@Override
	public Collection<Employee> listAll() {
		readJSOONFileData();
		return empMap.values();
	}

	@Override
	public Employee find(int key) {
		readJSOONFileData();
		return empMap.get(key);
	}

	@Override
	public Employee remove(int key) {
		readJSOONFileData();
		Employee removedEmp = null;
		if(empMap.containsKey(key)) {
			removedEmp = empMap.remove(key);
			writeJSONFileData();
		}
		return removedEmp;
	}

}