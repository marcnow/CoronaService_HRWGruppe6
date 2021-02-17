package de.marcnow.coronaService;

import java.util.List;

/**
* The country class gets the data for germany from the johnHopkins class and provides these for the dataService class.
* @author Björn Bulenda
* @version 1.0
*/

public class Country extends CovidData {
	
	private String countryName = "Germany";
    private List<CovidData> Germany;
    
    public Country() {
    }
    
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public List<CovidData> getGermany() {
		return Germany;
	}
	public void setGermany(List<CovidData> germany) {
		Germany = germany;
	}
}
