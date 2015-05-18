package com.pd.jee.irish.pubs;

import static com.pd.jee.common.CreateJson.getJsonResponse;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pd.jee.common.HelloService;
import com.pd.jee.common.ResponseData;

@Path("/irish")
public class IrishPubs {
    private static final String ALL_PUBS_ATHLONE = "Seans Bar, Piano Bar, Gerties, Karma, Mcguires!";
    private static final String SEANS_BAR = "SeansBar";
    private static final String RESULT_PIANO_WAS_GREAT_PLACE_TO_BE_MISS_IT = "{\"result\":\" Piano was great place to be. Miss it! \"}";
    private static final String RESULT_SEANS_BAR_OLDEST_PUB_IN_IRELAND = "{\"result\":\" Seans Bar, oldest pub in Ireland! \"}";
    private static final String RESULT_SEANS_BAR_IN_ATHLONE_IRELAND = "{\"result\":\" Athlone is Seans Bar, oldest pub in Ireland! \"}";
    private static final String RESULT_SOME_UNKNOWN_PUB_MISSING_DETAILS = "Some unknown pub, can you add details for pub?";
    @Inject
    HelloService helloService;

    // http://localhost:8080/my-jee/rest/irish/pubs
    @GET
    @Path("/pubs")
    @Produces({ MediaType.APPLICATION_JSON })
    public String getHelloWorldJSON() {
	return "{\"result\":\""
		+ helloService.createHelloMessage(ALL_PUBS_ATHLONE) + "\"}";
    }

    // http://localhost:8080/my-jee/rest/irish/pubs/SeansBar
    @GET
    @Path("/pubs/{pubName}")
    @Produces({ MediaType.APPLICATION_JSON })
    public String getPubDetails(@PathParam("pubName") final String pubName) {
	if (SEANS_BAR.equals(pubName)) {
	    return RESULT_SEANS_BAR_OLDEST_PUB_IN_IRELAND;
	}
	return getJsonResponse("result",
		RESULT_SOME_UNKNOWN_PUB_MISSING_DETAILS);
    }

    // http://localhost:8080/my-jee/rest/irish/pubs/Athlone?pubName=PianoBar
    // http://localhost:8080/my-jee/rest/irish/pubs/Athlone?pubName=SeansBar etc
    @GET
    @Path("/pubs/{pubCity}")
    @Produces({ MediaType.APPLICATION_JSON })
    public String getPubDetails(@QueryParam("pubName") final String pubName,
	    @PathParam("pubCity") final String pubCity) {

	if (SEANS_BAR.equals(pubName)) {
	    return RESULT_SEANS_BAR_IN_ATHLONE_IRELAND;
	} else if ("PianoBar".equals(pubName)) {
	    return RESULT_PIANO_WAS_GREAT_PLACE_TO_BE_MISS_IT;
	} else {
	    return getJsonResponse("result",
		    RESULT_SOME_UNKNOWN_PUB_MISSING_DETAILS);
	}
    }

    // http://localhost:8080/my-jee/rest/irish/getInfo/SeansBar
    @GET
    @Path("/getInfo/{pubName}")
    @Produces({ MediaType.APPLICATION_JSON })
    // @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response getEvents(@PathParam("pubName") final String pubName) {
	final ResponseData response = new ResponseData();
	try {
	    final String result = getJsonResponse("result", "STANDARD FOR ALL "
		    + RESULT_SOME_UNKNOWN_PUB_MISSING_DETAILS);
	    return Response.status(Response.Status.ACCEPTED).entity(result)
		    .build();
	} catch (final Exception e) {
	    System.err.println(e.getMessage());
	    System.err.println(e);
	    response.setCode(Response.Status.INTERNAL_SERVER_ERROR);
	    response.setError(e.getMessage());
	}

	return Response.status(response.getCode()).entity(response).build();
    }

}
