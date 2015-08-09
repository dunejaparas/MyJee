package org.jboss.as.quickstarts.rshelloworld;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

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

    Logger logger = Logger.getLogger(this.getClass().getName());

    // http://localhost:8080/my-jee/rest/hello/json
    @GET
    @Path("/json")
    @Produces({ "application/json" })
    public String getHelloWorldJSON() {
	return "{\"result\":\"" + helloService.createHelloMessage("World")
		+ "\"}";
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public Response setHelloWorldJSON(final String json) {
	logger.debug("Consume and Produce JSON:" + json);
	final String result = "{\"result\":\"ALL_PUBS_ATHLONE\"}";
	return Response.status(Response.Status.ACCEPTED).entity(result).build();
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
    public String getHelloWorldJSON(@PathParam("name") final String name) {
	logger.debug("@PathParam /json/{name} =" + name);
	return "{\"result\":\"" + helloService.createHelloMessage(name) + "\"}";
    }

    @POST
    @Path("/xml/{name}")
    @Produces("application/xml")
    public String getHelloWorldXML(@PathParam("name") final String name) {
	logger.debug("@PathParam /xml/{name} =" + name);
	return "<xml><result>" + helloService.createHelloMessage(name)
		+ "</result></xml>";
    }
}
