package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.models.MetaData;

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
}
