
package org.jboss.as.quickstarts.rshelloworld.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Rest Services
 *
 * Resources are served relative to the servlet path specified in the {@link ApplicationPath} annotation.
 *
 */
@Path("/resource")
public class CounterRestResource {

	
	private Logger logger = LoggerFactory.getLogger(CounterRestResource.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/increaseCount")
	public String sendMessage() {
		this.logger.debug("Send message...");
		return "ok";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getStats")
	public String getStats() {
		return "Sent ";
	}

}