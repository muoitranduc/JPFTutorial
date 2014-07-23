package com.example;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.models.MetaData;
import com.example.models.Request;
import com.example.models.Response;

@Path("/rise4fun")
public class RiseForFunService {

	@GET
	@Path("/metadata")
	@Produces(MediaType.APPLICATION_JSON)
	public MetaData userName() {
		MetaData newObj = new MetaData();
		newObj.init();
		return newObj;
	}
	
	@POST
	@Path("/run")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response userAge(Request obj) {
		Response newObj = new Response();
		newObj.init();
		//TODO run java path finder here
		return newObj;
	}
}
