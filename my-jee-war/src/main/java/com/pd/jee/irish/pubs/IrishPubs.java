package com.pd.jee.irish.pubs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.pd.jee.common.HelloService;

@Path("/irish")
public class IrishPubs {
	@Inject
	HelloService helloService;

	@GET
	@Path("/pubs")
	@Produces({ "application/json" })
	public String getHelloWorldJSON() {
		return "{\"result\":\"" + helloService.createHelloMessage("Seans Bar!") + "\"}";
	}
}
