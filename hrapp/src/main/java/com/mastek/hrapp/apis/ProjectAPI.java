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
import com.mastek.hrapp.entities.Project;

public interface ProjectAPI {

	// http://localhost:7777/hrapp/department/list
			@GET	// we do support http method GET
			@Path("/projects/list") // URL path to access this method
			@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) // formats which the method supports
			public Iterable<Project> listAllProjects();

			@GET
			@Path("/projects/find/{projectId}")
			@Produces({MediaType.APPLICATION_JSON})
			public Project findByProjectId(@PathParam("projectId") int projectId);
			
			@POST // http method Post used to send data in requests
			@Path("/projects/register/")
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			@Produces(MediaType.APPLICATION_JSON)
			public Project registerNewProject(@BeanParam Project newProject);
	
}
