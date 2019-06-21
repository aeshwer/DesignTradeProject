package com.restful.java.example;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

public class CORSFilter implements ContainerResponseFilter 
 {

	@Override
	public void filter(ContainerRequestContext creq, ContainerResponseContext cresp) throws IOException {
	}

}
