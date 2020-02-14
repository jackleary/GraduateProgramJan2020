package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlTransient;

@Entity // declares class as Entity, to be managed by JPA
@Table(name="JPA_Departments")
public class Department {

	int deptno;	
	
	@FormParam("name")
	String name;
	
	@FormParam("location")
	String location;
	
	Set<Employee> team = new HashSet<>();
	
	// associates the many entity using collection with cascade enabled
	// specify in mappedBy the 'joinColumn config property name
	@OneToMany(mappedBy="currentDepartment",cascade=CascadeType.ALL)
	@XmlTransient
	public Set<Employee> getTeam() {
		return team;
	}

	public void setTeam(Set<Employee> team) {
		this.team = team;
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}

	@Id // marking property as primary key for the table
	@Column(name="department_number") // using column to provide default column name
	@GeneratedValue(strategy=GenerationType.AUTO) // Auto Numbering configurations as per DB or AUTO
	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Column(name="department_name",length=50,nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptno;
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
		Department other = (Department) obj;
		if (deptno != other.deptno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", name=" + name + ", location=" + location + "]";
	}
	
	
	
}
