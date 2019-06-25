package com.restful.java.example;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class RestApplication  extends Application{
	
//	 @Override
//	  public Set<Class<?>> getClasses() {
//	      Set<Class<?>> set = new HashSet<>();
//	      set.add(ScoreService.class);
//	      return set;
//	  }

	  @Override
	  public Set<Object> getSingletons() {
	      Set<Object> set = new HashSet<>();
	      set.add(new ScoreService());
	      return set;
	  }
	
	
	public RestApplication() {
		System.out.println("Hello from Appication class constructor");
	}
	
}
