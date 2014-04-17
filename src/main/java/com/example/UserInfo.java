package com.example;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.models.TQARequest;

@Path("UserInfoService")
public class UserInfo {

	@GET
	@Path("/name")
	@Produces(MediaType.APPLICATION_JSON)
	public TQARequest userName() {
		TQARequest newObj = new TQARequest("Name question?");
		return newObj;
	}

	@POST
	@Path("/age")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TQARequest userAge(TQARequest obj) {

		String age = obj.getQuestion();
		TQARequest newObj = new TQARequest(age + " new");
		return newObj;
	}
}