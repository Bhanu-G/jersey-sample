package com.example.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api")
public class ProducerController {
	
	@GET
	@Path("")
	public String testGetMethod() {
		return "This is GET Api!";
	}

}
