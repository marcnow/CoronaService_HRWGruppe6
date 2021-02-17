package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* handles the http requests for the rest webservice when the service is first approached
* @author Björn Bulenda
* @version 1.0
*/

@RestController
public class GreetingController {
	
	/**
	 * This method invokes when the web service is called
	 * @return a basic string with all web services
	 * @throws Exception
	 */
	@GetMapping("/")
	public String greeting() throws Exception {
		return "Folgende Befehle stehen zur Verfügung: "
				+ "rest/newinfections, rest/infectionrise, rest/averageinfectionrise, rest/incidencevalue, rest/targettotalinfections,"
				+ "rest/daysoflockdown \n";
	}

}
