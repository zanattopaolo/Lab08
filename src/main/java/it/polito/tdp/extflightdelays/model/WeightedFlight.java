package it.polito.tdp.extflightdelays.model;

public class WeightedFlight {
	
	private Airport source;
	private Airport destination;
	private int distanceAvg;
	
	public WeightedFlight(Airport source, Airport destination, int distanceAvg) {
		super();
		this.source = source;
		this.destination = destination;
		this.distanceAvg = distanceAvg;
	}

	public Airport getSource() {
		return source;
	}
	public void setSource(Airport source) {
		this.source = source;
	}
	public Airport getDestination() {
		return destination;
	}
	public void setDestination(Airport destination) {
		this.destination = destination;
	}
	public int getDistanceAvg() {
		return distanceAvg;
	}
	public void setDistanceAvg(int distanceAvg) {
		this.distanceAvg = distanceAvg;
	}

	@Override
	public String toString() {
		return "WeightedFlight [source=" + source + ", destination=" + destination + ", distanceAvg=" + distanceAvg
				+ "]\n";
	}
	
	
	

}
