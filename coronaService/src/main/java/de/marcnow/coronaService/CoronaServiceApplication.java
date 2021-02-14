package de.marcnow.coronaService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.google.gson.Gson;


@SpringBootApplication
public class CoronaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaServiceApplication.class, args);
		
		try {
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Herbert_Bot());
            System.out.println("Telegramm-Bot gestartet...");
            
        } catch (TelegramApiException e) {
        	e.printStackTrace();
        }
	}
}

@RestController
class HelloController {
	
	@GetMapping("=json")
	String hello() throws Exception {
		
		DataService ds = new DataService();
		CovidKeyIndicators covidKeyIndicators = new CovidKeyIndicators(ds.getNewInfections(), 
																	   ds.getTotalInfections(),
																	   ds.getInfectionRise(),
																	   ds.getAverageInfectionRise(2),
																	   ds.getIncidenceValue(),
																	   ds.getTargetTotalInfections(),
																	   ds.getDaysOfLockdown());
		
		Gson gson = new Gson();
		String json = gson.toJson(covidKeyIndicators);
		return json;
	}
}
