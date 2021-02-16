package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.marcnow.coronaService.DataService;

class AverageInfectionRise {
	float averageInfectionRise;
	public AverageInfectionRise(float averageInfectionRise) {this.averageInfectionRise = averageInfectionRise;}
}

@RestController
public class AverageInfectionRiseController {
	
	@GetMapping("rest/averageinfectionrise")
	public String averageInfectionRise(@RequestParam(value = "days", defaultValue = "1") int days) throws Exception {
		Gson gson = new Gson();
		return gson.toJson(new AverageInfectionRise(new DataService().getAverageInfectionRise(days)));
	}
}
