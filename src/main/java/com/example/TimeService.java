package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.models.Time;


@Path("/time")
public class TimeService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Time get() {
        return new Time();
    }

}

