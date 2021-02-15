package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.marcnow.coronaService.DataService;

class TotalInfections {
	int totalInfections;
	public TotalInfections(int totalInfections) {this.totalInfections = totalInfections;}
}

@RestController
public class TotalInfectionsController {

	@GetMapping("rest/totalinfections") 
	public String totalInfections() throws Exception {
		Gson gson = new Gson();
		return gson.toJson(new TotalInfections(new DataService().getTotalInfections()));
	}
}
