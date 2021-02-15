package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.marcnow.coronaService.DataService;

class TargetTotalInfections {
	float targetTotalInfections;
	public TargetTotalInfections(float targetTotalInfections) {this.targetTotalInfections = targetTotalInfections;}
}

@RestController
public class TargetTotalInfectionsController {
	
	@GetMapping("rest/targettotalinfections")
	public String targetTotalInfections() throws Exception {
		Gson gson = new Gson();
		return gson.toJson(new TargetTotalInfections(new DataService().getTargetTotalInfections()));
	}

}
