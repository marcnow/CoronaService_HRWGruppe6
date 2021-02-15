package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.marcnow.coronaService.DataService;

class IncidenceValue {
	float incidenceValue;
	public IncidenceValue(float incidenceValue) {this.incidenceValue = incidenceValue;}
}

@RestController
public class IncidenceValueController {

	@GetMapping("rest/incidencevalue")
	public String incidenceValue() throws Exception {
		Gson gson = new Gson();
		return gson.toJson(new IncidenceValue(new DataService().getIncidenceValue()));
	}
}
