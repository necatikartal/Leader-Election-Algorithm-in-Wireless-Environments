package com.neco4j.graph;

import java.io.IOException;

/**
 * Operations interface
 * @author Necati Kartal
 */
public interface IOperations {

	/**
	 * Initialize the graph
	 * @return graph
	 */
	public Graph initialGraph();

	/**
	 * Build graph by using graph capacity and growth percentage
	 * @param graphCapacity
	 * @param growthPercentage
	 * @return graph
	 */
	public Graph buildGraph(int graphCapacity, int growthPercentage);
	
	/**
	 * Build graph by reading data from nodes.txt and edges.txt
	 * @param vericesPath
	 * @param edgesPath
	 * @return graph
	 * @throws IOException
	 */
	public Graph buildGraph (String vericesPath, String edgesPath) throws IOException;
}