package com.mastek.hrapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;

@Repository // declare the DAO layer as repository to manage Data operations
public interface EmployeeJPADAO extends CrudRepository<Employee, Integer>{ // CrudRepositry<Class,PrimaryKeyType>
	
	// define methods for each named query in the entity
	Iterable<Employee> findBySalary(
			@Param("minSalary")double minSalary,
			@Param("maxSalary")double maxSalary); // map each parameter with @Param("<name>")
	
	Iterable<Employee> findByDesignation(@Param("designation") Designation designation);
	
}
