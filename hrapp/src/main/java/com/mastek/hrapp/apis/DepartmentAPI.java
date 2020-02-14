package com.mastek.hrapp.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.hrapp.entities.Department;

@Path("/hrapp/") // url pattern to access current API interface
public interface DepartmentAPI {

	// http://localhost:7777/hrapp/department/list
		@GET	// we do support http method GET
		@Path("/departments/list") // URL path to access this method
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) // formats which the method supports
		public Iterable<Department> listAllDepartments();

		@GET
		@Path("/departments/find/{deptno}")
		@Produces({MediaType.APPLICATION_JSON})
		public Department findByDepno(@PathParam("deptno") int empno);
		
		@POST // http method Post used to send data in requests
		@Path("/departments/register/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.APPLICATION_JSON)
		public Department registerNewDepartment(@BeanParam Department newDepartment);
	
}
