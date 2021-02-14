package de.marcnow.coronaService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;


@SpringBootApplication
public class CoronaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaServiceApplication.class, args);
	}
}

@RestController
class HelloController {
	
	@GetMapping("/")
	String hello() throws Exception {
		
		DataService ds = new DataService();
		CovidKeyIndicators covidKeyIndicators = new CovidKeyIndicators(ds.getNewInfections(), 
																	   ds.getTotalInfections(),
																	   ds.getInfectionRise(),
																	   ds.getAverageInfectionRise(3),
																	   ds.getIncidenceValue(),
																	   ds.getTargetTotalInfections(),
																	   ds.getDaysOfLockdown());
		
		Gson gson = new Gson();
		String json = gson.toJson(covidKeyIndicators);
		return json;
	}
}
