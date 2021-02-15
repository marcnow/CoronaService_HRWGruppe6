package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.marcnow.coronaService.DataService;

class InfectionRise {
	int infectionRise;
	public InfectionRise(int infectionRise) {this.infectionRise = infectionRise;}
}

@RestController
public class InfectionRiseController {

	@GetMapping("rest/infectionrise")
	public String infectionRise() throws Exception {
		Gson gson = new Gson();
		return gson.toJson(new InfectionRise(new DataService().getInfectionRise()));
	}
	
}
