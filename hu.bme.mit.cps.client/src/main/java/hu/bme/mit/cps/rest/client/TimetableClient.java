package hu.bme.mit.cps.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class TimetableClient implements ITimetable {

	public boolean hasLesson() {
		ITimetable timetableClient = createClient(ITimetable.class);
		return timetableClient.hasLesson();
	}
	
	private <T> T createClient(Class<T> clazz) {
		// Creating a new RESTeasy client through the JAX-RS API:
		Client client = ClientBuilder.newClient();
		// The base URL of the service:
		WebTarget target = client.target("http://localhost:8080/hu.bme.mit.cps.timetable/timetable");
		// Casting it to ResteasyWebTarget:
		ResteasyWebTarget rtarget = (ResteasyWebTarget) target;
		// Getting a typed interface:
		return rtarget.proxy(clazz);
	} 

}