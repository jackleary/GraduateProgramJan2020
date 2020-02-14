package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.data.annotation.Transient;

@XmlRootElement // declares entity to be transformed to XML/JSON
@Entity // declares class as Entity, to be managed by JPA
@Table(name="JPA_Employees") // declare table name associated with this class
@EntityListeners({EmployeeListener.class}) // call the appropriate listener event method on lifecycle event.
// Curly brackets are initialising an array
@NamedQueries({
	@NamedQuery(name="Employee.findBySalary", // declare query name as method in DAO 
			query="select e from Employee e where e.salary between :minSalary and :maxSalary")
			// identify query to fetch employee objects with properties and parameters
			// all parameters are to be declared using @Param("<name>") in the DAO interface
	,
	@NamedQuery(name="Employee.findByDesignation",
			query="select e from Employee e where e.designation=:designation")
			// identify that the method in DAO and pass necessary parameters
})
public class Employee {
	
	int empno;
	
	@FormParam("name")
	String name;
	
	@FormParam("salary")
	double salary;
	
	@FormParam("designation")
	Designation designation;
	
	Department currentDepartment;
	
	
	@ManyToOne // Many employees are associated with one department
	@JoinColumn(name="fk_department_number") // foreign key column to store the associate deptno
	@Transient // ignore this property when storing employee data in mongodb
	@XmlTransient // ignore association property when shared via service
	public Department getCurrentDepartment() {
		return currentDepartment;
	}

	public void setCurrentDepartment(Department currentDepartment) {
		this.currentDepartment = currentDepartment;
	}
	
	
	Set<Project> projectsAssigned = new HashSet<>();
	
	
	@ManyToMany(cascade=CascadeType.ALL) // configure many to many associations for entities
	@JoinTable(
			name="JPA_PROJECT_ASSIGNMENTS", // provide join table name 
			joinColumns = {@JoinColumn(name="fk_empno")}, // fk column for current class
			inverseJoinColumns = {@JoinColumn(name="fk_projectId")} // fk column for collection
			)
	@Transient // ignore this property when storing employee data in mongodb
	@XmlTransient // ignore the association property when shared via Service
	public Set<Project> getProjectsAssigned() {
		return projectsAssigned;
	}

	public void setProjectsAssigned(Set<Project> projectsAssigned) {
		this.projectsAssigned = projectsAssigned;
	}

	public Employee() {
		
	}

	@Id // marking property as primary key for the table
	@Column(name="employee_number") // using column to provide default column name
	@GeneratedValue(strategy=GenerationType.AUTO) // Auto Numbering configurations as per DB
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	@Column(name="employee_name",length=50,nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Enumerated(EnumType.STRING)
	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}
	
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", salary=" + salary + ", designation=" + designation
				+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empno;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empno != other.empno)
			return false;
		return true;
	}
	
	//@Transient: to mark property not to be stored in DB table
	
}
