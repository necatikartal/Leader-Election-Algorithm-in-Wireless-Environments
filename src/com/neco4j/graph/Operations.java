package com.neco4j.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Operations class that implements operations interface
 * @author Necati Kartal
 */
public class Operations implements IOperations {

	/**
	 * Initialize the graph
	 * @Each vertex has to have at least 3 edges on the graph
	 * @return graph
	 */
	@Override
	public Graph initialGraph(){
		
		Graph gr = new Graph();
		Random rand = new Random(); 
		int	randomCapacity;
		
		// create 4 vertex with random capacity between 1-100
		randomCapacity = rand.nextInt(100) + 1;
		gr.addVertex("1",randomCapacity);
		randomCapacity = rand.nextInt(100) + 1;
        gr.addVertex("2",randomCapacity);
        randomCapacity = rand.nextInt(100) + 1;
        gr.addVertex("3",randomCapacity);
        randomCapacity = rand.nextInt(100) + 1;
        gr.addVertex("4",randomCapacity);
       
        // add the vertices to the graph and add at least 3 edge between them
        gr.addEdge("1", "2");
        gr.addEdge("2", "1"); 
        gr.addEdge("1", "3");
        gr.addEdge("3", "1");       
        gr.addEdge("1", "4");
        gr.addEdge("4", "1");        
        gr.addEdge("2", "3");
        gr.addEdge("3", "2");      
        gr.addEdge("2", "4");
        gr.addEdge("4", "2");     
        gr.addEdge("3", "4");
        gr.addEdge("4", "3");
        
		return gr;
	}

	/**
	 * Build graph by using graph capacity and growth percentage
	 * @param graphCapacity
	 * @param growthPercentage
	 * @return graph
	 */
	@Override
	public Graph buildGraph(int graphCapacity, int growthPercentage){	
		
		Graph gr = initialGraph();	// initialize the graph
		int vertexCounter = gr.vertexCount(); // it will use for giving name of nodes
		int minEdge = 3; // connection condition between vertices
		
		// create random growth, capacity and vertex
		Random rand = new Random();
		int randomGrowth; // it will use for growth percentage condition
		int randomCapacity; // it will use for vertex capacity
		int randomVertex; // it will use random vertex value from the graph

		// start building the graph
		while(gr.vertexCount() < graphCapacity) {
			
			// rand.nextInt(100) will give value from 0 to 99. For 1 to 100: rand.nextInt(100) + 1
			randomGrowth = rand.nextInt(100) + 1;
			randomCapacity = rand.nextInt(100) + 1;
			
			// add a random vertex to the graph
			if(randomGrowth<growthPercentage) {
				gr.addVertex(String.valueOf(vertexCounter), randomCapacity);
				
				// add at least 3 connection for the vertex
				while(gr.inDegree(String.valueOf(vertexCounter)) < minEdge || gr.outDegree(String.valueOf(vertexCounter)) < minEdge){
					randomVertex = rand.nextInt(gr.vertexCount()) + 1; //This will give random vertex number from the graph.
					while(randomVertex == vertexCounter || gr.isAdjacent(String.valueOf(vertexCounter),String.valueOf(randomVertex)))
							randomVertex = rand.nextInt(gr.vertexCount()) + 1; //This will give random vertex number from the graph.
					gr.addEdge(String.valueOf(vertexCounter), String.valueOf(randomVertex));
					gr.addEdge(String.valueOf(randomVertex), String.valueOf(vertexCounter));
				}
				
				vertexCounter++; // increase vertex count for next vertex
			}else // delete a random vertex from the graph
			{
				// Handle a random vertex number from the graph.
				randomVertex = rand.nextInt(gr.vertexCount()) + 1; 
				Vertex v = gr.findVertex(String.valueOf(randomVertex)); 
				
		        if (v != null)
		        {
		        	// before removing find all connected vertices and make them new connections
		            Edge e = v.getNextEdge();
		            while (e != null)
		            {
			            randomVertex = rand.nextInt(gr.vertexCount()) + 1; // This will give random vertex number from the graph
			            while(gr.isAdjacent(e.getVertexValue(),String.valueOf(randomVertex)) ||  v.getVertexValue().compareTo(String.valueOf(randomVertex)) == 0 )
			            	randomVertex = rand.nextInt(gr.vertexCount()) + 1; // This will give random vertex number from the graph
			            // add edges between them
						gr.addEdge(e.getVertexValue(), String.valueOf(randomVertex));
						gr.addEdge(String.valueOf(randomVertex), e.getVertexValue());
		                e = e.getNextEdge();
		            }
			        gr.removeVertex(v.getVertexValue()); // remove the random vertex
		        }
			}	
		}
		return gr;
	}
	
	/**
	 * Build graph by reading data from nodes.txt and edges.txt
	 * @param nodesPath
	 * @param edgesPath
	 * @return graph
	 * @throws IOException
	 */
	@Override
	public Graph buildGraph (String verticesPath, String edgesPath) throws IOException {
		
		Graph gr = new Graph(); // initialize the graph
		
		// read vertices data and add them to graph 
		BufferedReader br = new BufferedReader(new FileReader(verticesPath));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            if(line!=null){
	            	String[] parts = line.split(" ");
		            String vertexName = parts[0];
		            String vertexSize = parts[1];
		            gr.addVertex(vertexName, Integer.valueOf(vertexSize));
	            }
	            line = br.readLine();
	        }
	    } finally {
	        br.close();  
	    }
	    
	    // read edges data and make connections between the vertices
	    br = new BufferedReader(new FileReader(edgesPath));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            if(line!=null){
		            String[] parts = line.split(" ");
		            String vertex1 = parts[0];
		            String vertex2 = parts[1];
		            gr.addEdge(vertex1, vertex2);
		    		gr.addEdge(vertex2, vertex1);
	            }
	            line = br.readLine();
	        }
	    } finally {
	        br.close();  
	    }
	    return gr;
	}
}