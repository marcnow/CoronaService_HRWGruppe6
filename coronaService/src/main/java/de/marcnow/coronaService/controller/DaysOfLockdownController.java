package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.marcnow.coronaService.DataService;

class DaysOfLockdown {
	float daysOfLockdown;
	public DaysOfLockdown(float daysOfLockdown) {this.daysOfLockdown = daysOfLockdown;}
}

@RestController
public class DaysOfLockdownController {

	@GetMapping("rest/daysoflockdown")
	public String daysOfLockdown() throws Exception {
		Gson gson = new Gson();
		return gson.toJson(new DaysOfLockdown(new DataService().getDaysOfLockdown()));
	}
}
