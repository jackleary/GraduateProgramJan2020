package com.mastek.hrapp.apis;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

public class CORSFilter implements ContainerResponseFilter{

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		responseContext.getHeaders().add(
                "Access-Control-Allow-Origin", "*");
         
        responseContext.getHeaders().add(
               "Access-Control-Allow-Headers",
               "X-Requested-With,Origin, Content-Type, Accept");
        
        responseContext.getHeaders().add(
                "Access-Control-Allow-Methods", 
                "GET, POST, PUT, DELETE");
		
	}
	
	
	
}
