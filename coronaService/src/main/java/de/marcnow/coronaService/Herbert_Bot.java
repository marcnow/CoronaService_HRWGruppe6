package de.marcnow.coronaService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.google.gson.Gson;

     public class Herbert_Bot extends TelegramLongPollingBot {

		public void onUpdateReceived(Update update) {
			// TODO was passiert wenn einem �ber Telegramm geschrieben wird
			 
			String command = update.getMessage().getText();
			String json = null;
			try {
				json = readUrl("https://coronaservice-grp6.herokuapp.com/rest/all");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			Gson gson = new Gson();
			CovidKeyIndicators covidKeyIndicators = new CovidKeyIndicators();
			covidKeyIndicators = gson.fromJson(json, CovidKeyIndicators.class);
			SendMessage message = new SendMessage();
			
			if(command.equals("/start")) {
				message.setText("Hallo ich bin Herbert, der von den Studenten der HRW programmierte Bot, �ber den man die aktuellen Corona Kennzahlen in Deutschland beziehen kann. Wie kann ich Ihnen weiterhelfen?");
			}
			else if(command.equals("/neuinfektionen")) {
				message.setText("Von gestern auf heute haben sich " + covidKeyIndicators.getNewInfections()  + " Leute neu mit Corona infiziert");
			}
			
			else if(command.equals("/gesamtinfektionen")) {
				message.setText("Zurzeit haben wir " + covidKeyIndicators.getTotalInfections() + " Gesamtinfektionen");
			}
			
			else if(command.equals("/anstieg")) {
				message.setText("Der Anstieg der aktuell Infizierten lautet: " + covidKeyIndicators.getInfectionRise());
			}
			
			else if(command.equals("/durchschnittlicheranstieg")) {
				message.setText("Von wie vielen Tagen soll der durschnittliche Anstieg berechnet werden?");
				String days = update.getMessage().getText();
				if(Integer.parseInt(days) == 1) {
					message.setText("Der durcschnittliche Anstieg der letzten " + days + " Tage beträgt: " + covidKeyIndicators.getAverageInfectionRise());
				} else {
					String tmp = null;
					try {
						tmp = readUrl("https://coronaservice-grp6.herokuapp.com/rest/averageInfectionRise?days=" + days);
					} catch (Exception e) {
						e.printStackTrace();
					}
					AverageInfectionRise averageInfectionRise = new AverageInfectionRise();
					averageInfectionRise = gson.fromJson(tmp, AverageInfectionRise.class);
					message.setText("Der durcschnittliche Anstieg der letzten " + days + " Tage beträgt: " + averageInfectionRise.getAverageInfectionRise());
				}
			}
			
			else if(command.equals("/rwert")) {
				message.setText("Der Inzidenz-Wert für Gesamtdeutschland beträgt " + covidKeyIndicators.getIncidenceValue());
			}
			
			else if(command.equals("/zielgesamtinfektionen")) {
				message.setText("Die Ziel-Gesamtinfektion lautet " + covidKeyIndicators.getTargetTotalInfections());
			}
			
			else if(command.equals("/voraussage")) {
				message.setText("Vorraussichtlich dauert der Lockdown noch " + covidKeyIndicators.getDaysOfLockdown() + " Tage");
			}
			
			// den hier braucht man wahrscheinlich nicht der zeigt nur an, wenn Text in Telegramm geschrieben wird - error entsteht weil probiert wird ne nachricht zu senden
			else {
				System.out.println(update.getMessage().getText());
			}
			
			message.setChatId(update.getMessage().getChatId().toString());
			
			if(message.getText()!=null) {
			try {
				execute(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			}
		}
		
		private static String readUrl(String urlString) throws Exception {
			BufferedReader reader = null;
		    try {
		        URL url = new URL(urlString);
		        reader = new BufferedReader(new InputStreamReader(url.openStream()));
		        StringBuffer buffer = new StringBuffer();
		        int read;
		        char[] chars = new char[1024];
		        while ((read = reader.read(chars)) != -1) {
		        	buffer.append(chars, 0, read);
		        }
		        return buffer.toString();
		        
		    } finally {
		        if (reader != null)
		            reader.close();
		    }
		}
		
		//hier muss immer der Bot Username returned werden
		public String getBotUsername() {
			return "HRWGruppe6_Herbert_Bot";
		}
		// hier muss immer der Bot Token returned werden
		@Override
		public String getBotToken() {
			return "1617533748:AAHNMwFsp17gySJwEsxewNYhlJV76ARgKiI";
		}

     }
