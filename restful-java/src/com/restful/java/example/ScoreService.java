//Note  : https://www.theserverside.com/video/Step-by-step-RESTful-web-service-example-in-Java-using-Eclipse
/* Do these on git bash in tomcat folder
 * 
 * 1) $ curl -X GET "http://localhost:9090/restful-java/score/wins"
 * 2)curl -X GET "http://localhost:9090/restful-java/score/wins"
 * 3)$ curl -X PUT "http://localhost:9090/restful-java/score?wins=11&loss=22&ties=33"
*/
package com.restful.java.example;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.inject.Injector;

import restful_server.restful_server.ExposedFunction;


@Path("/")
public class ScoreService {
	
	private static Injector injector;
	private ExposedFunction exposed;
	private static int wins;
	private static int loss;
	private static int ties;

	public ScoreService() {
		exposed = injector.getInstance(ExposedFunction.class);
		System.out.println("Hello from server class constructor: ExposedFuntion " + exposed.hashCode());
	}
	
	// {"wins":"5" ,"loss":"1","ties":"0"}
	@GET
	@Path("/score")
	@Produces("application/json")
	public Response getScore() {
		String pattern = "{\"wins\":\"%s\" ,\"loss\":\"%s\",\"ties\":\"%s\"}";
		//return String.format(pattern, wins, loss, ties);
		return Response.status(200).entity(String.format(pattern, wins, loss, ties)).build();

	}

	// localhost:8080/restful-java/score?wins-2?loss=3@ties=15
	@PUT
	@Path("/score")
	@Produces("application/json")
	public String updateScore(@QueryParam("wins") int wins, @QueryParam("loss") int loss,
			@QueryParam("ties") int ties) {
		ScoreService.wins = wins;
		ScoreService.loss = loss;
		ScoreService.ties = ties;

		String pattern = "{\"wins\":\"%s\" ,\"loss\":\"%s\",\"ties\":\"%s\"}";
		return String.format(pattern, wins, loss, ties);

	}

	@PUT
	@Path("/score/wins")
	@Produces(MediaType.TEXT_PLAIN)
	public Response increaseWins() {
		//return wins++;
		return Response.status(200).entity(wins++).header("Access-Control-Allow-Origin", "*").build();
	}

	@PUT
	@Path("/score/loss")
	@Produces("text/plain")
	public int increaseLoss() {
		return loss++;
	}

	@PUT
	@Path("/score/ties")
	@Produces("text/plain")
	public int increaseTies() {
		return ties++;
	}

	@GET
	@Path("/score/wins")
	@Produces("text/plain")
	public int getWins() {
		return wins;
	}

	@GET
	@Path("/score/loss")
	@Produces("text/plain")
	public int getLoss() {
		return loss;
	}

	@GET
	@Path("/score/ties")
	@Produces("text/plain")
	public int getTies() {
		return ties;
	}
	
	//Method which can take a Json from client
	@PUT
	@Path("/score/jsonData")
	@Consumes(MediaType.APPLICATION_JSON)
	public void fetchJson(String obj) {
		
		System.out.println("Received Object Json is :" +obj);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			exposed.calledFuntion();
			JsonDummyObject readValue = mapper.readValue(obj, JsonDummyObject.class);
			System.out.println("Received Object Pojo is :" +readValue.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
