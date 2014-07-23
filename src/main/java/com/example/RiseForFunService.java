package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.jpf.MainApp;
import com.example.models.MetaData;
import com.example.models.Output;
import com.example.models.Request;
import com.example.models.Response;

@Path("/rise4fun")
public class RiseForFunService {

	@GET
	@Path("/metadata")
	@Produces(MediaType.APPLICATION_JSON)
	public MetaData showMetaData() {
		MetaData newObj = new MetaData();
		newObj.init();
		return newObj;
	}

	@POST
	@Path("/run")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response run(Request obj) {
		MainApp mainApp = new MainApp();
		
		Response newObj = new Response();
		newObj.init();
		
		List<Output> outputs = new ArrayList<Output>();
		outputs.add(new Output("text/plain", "Start mainApp" + mainApp.run(obj.getSource())));
		newObj.setOutputs(outputs);
		
		return newObj;
	}
}