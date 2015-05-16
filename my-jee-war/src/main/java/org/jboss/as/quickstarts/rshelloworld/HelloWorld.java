package org.jboss.as.quickstarts.rshelloworld;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.pd.jee.common.HelloService;

/**
 * A simple REST service which is able to say hello to someone using
 * HelloService Please take a look at the web.xml where JAX-RS is enabled
 * 
 */

@Path("/hello")
public class HelloWorld {
	@Inject
	HelloService helloService;

	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getHelloWorldJSON() {
		return "{\"result\":\"" + helloService.createHelloMessage("World")
				+ "\"}";
	}

	@GET
	@Path("/xml")
	@Produces({ "application/xml" })
	public String getHelloWorldXML() {
		return "<xml><result>" + helloService.createHelloMessage("World")
				+ "</result></xml>";
	}

	@POST
	@Path("/json/{name}")
	@Produces("application/json")
	public String getHelloWorldJSON(@PathParam("name") String name) {
		System.out.println("name: " + name);
		return "{\"result\":\"" + helloService.createHelloMessage(name) + "\"}";
	}

	@POST
	@Path("/xml/{name}")
	@Produces("application/xml")
	public String getHelloWorldXML(@PathParam("name") String name) {
		System.out.println("name: " + name);
		return "<xml><result>" + helloService.createHelloMessage(name)
				+ "</result></xml>";
	}
}
