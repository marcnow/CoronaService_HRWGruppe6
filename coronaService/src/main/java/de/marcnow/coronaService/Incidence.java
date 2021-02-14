package de.marcnow.coronaService;

import java.util.List;

public class Incidence extends Feature {
	
	public Incidence() {
	}
	
	private List<Feature> features;

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}
}
