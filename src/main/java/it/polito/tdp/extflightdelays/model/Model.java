package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private Graph<Airport, DefaultWeightedEdge> grafo;
	private Map<Integer, Airport> idMap;
	
	public Model() {
		this.idMap=new HashMap<Integer, Airport>();
	}
	
	public void creaGrafoDistanzaMedia(int distance) {
		
		this.grafo=new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		ExtFlightDelaysDAO dao= new ExtFlightDelaysDAO();
		dao.loadAllAirports(idMap);
		
		for(WeightedFlight wf: dao.getFlightsDistanceAvg(distance, idMap)) {
			if(!this.grafo.containsVertex(wf.getSource()))
				this.grafo.addVertex(wf.getSource());
			
			if(!this.grafo.containsVertex(wf.getDestination()))
				this.grafo.addVertex(wf.getDestination());
			
			Graphs.addEdge(grafo, wf.getSource(), wf.getDestination(), wf.getDistanceAvg());
		}

	}
	
	public int getNumAirport() {
		return this.grafo.vertexSet().size();
	}
	
	public int getNumEdge() {
		return this.grafo.edgeSet().size();
	}
	
	public String getEdges() {
		String s="";
		for(DefaultWeightedEdge dwe: this.grafo.edgeSet())
			s+=this.grafo.getEdgeSource(dwe).getAirportName()+" - "+this.grafo.getEdgeTarget(dwe).getAirportName()+":\t"+this.grafo.getEdgeWeight(dwe)+" miglia \n";
		
		return s;
	}

}
