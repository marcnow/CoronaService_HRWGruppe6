package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {
	
	@GetMapping("/")
	public String greeting() throws Exception {
		return "Folgende Befehle stehen zur Verfügung: "
				+ "rest/newinfections, rest/infectionrise, rest/averageinfectionrise, rest/incidencevaleu, rest/targettotalinfections,"
				+ "rest/daysoflockdown \n";
	}

}
