package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.marcnow.coronaService.CovidKeyIndicators;
import de.marcnow.coronaService.DataService;

@RestController
public class AllController {

	@GetMapping("/rest/all")
	public String covidKeyIndicators(@RequestParam(value = "days", defaultValue = "1") int days) throws Exception {
		Gson gson = new Gson();
		DataService ds = new DataService();
		return gson.toJson(new CovidKeyIndicators(ds.getNewInfections(), ds.getTotalInfections(), ds.getInfectionRise(), ds.getAverageInfectionRise(days),
				ds.getIncidenceValue(), ds.getTargetTotalInfections(), ds.getDaysOfLockdown()));
		
	}
}
