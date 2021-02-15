package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.marcnow.coronaService.CovidKeyIndicators;
import de.marcnow.coronaService.DataService;

@RestController
public class GreetingController {
	
	@GetMapping("/")
	public String greeting() throws Exception {
		Gson gson = new Gson();
		DataService ds = new DataService();
		return "Folgende Befehle stehen zur Verfügung: "
				+ "rest/newinfections, rest/infectionrise, rest/averageinfectionrise, rest/incidencevaleu, rest/targettotalinfections,"
				+ "rest/daysoflockdown \n"
				+ gson.toJson(new CovidKeyIndicators(ds.getNewInfections(), ds.getTotalInfections(), 
						ds.getInfectionRise(), ds.getAverageInfectionRise(7), ds.getIncidenceValue(),
						ds.getTargetTotalInfections(), ds.getDaysOfLockdown()));
	}

}
