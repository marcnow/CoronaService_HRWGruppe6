package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.marcnow.coronaService.DataService;

class NewInfections {
	int newInfections;
	public NewInfections(int newInfections) {this.newInfections = newInfections;}
}

@RestController
public class NewInfectionsController {
	
	@GetMapping("rest/newinfections")
	public String newInfections() throws Exception {
		Gson gson = new Gson();
		return gson.toJson(new NewInfections(new DataService().getNewInfections()));
	}
	
}
