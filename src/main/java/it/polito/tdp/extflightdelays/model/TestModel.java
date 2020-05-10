package it.polito.tdp.extflightdelays.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		model.creaGrafoDistanzaMedia(800);
		
		System.out.println("Il grafo contiene "+model.getNumAirport()+" aeroporti e "+model.getNumEdges()+" voli");

	}

}
