package com.neco4j.graph;

/**
 * Vertex class that implements vertex interface
 * @author Necati Kartal
 */
public class Vertex implements IVertex {

	private String vertexValue;
	private Vertex nextVertex;
	private Edge nextEdge;
	private Boolean visited;
	private int vertexCapacity;
	private Coordinator coordinator;

	/**
	 * Two-argument vertex constructor
	 * @param vertexValue
	 * @param vertexCapacity
	 */
	public Vertex(String vertexValue, int vertexCapacity) {
		this.setVertexValue(vertexValue);
		this.setNextVertex(null);
		this.setNextEdge(null);
		this.setVisited(false);
		this.setVertexCapacity(vertexCapacity);
		this.setCoordinator(new Coordinator(vertexValue,vertexCapacity));
	}

	/**
	 * Gets the vertex value
	 * @return vertexValue
	 */
	@Override
	public String getVertexValue() {
		return vertexValue;
	}

	/**
	 * Sets the vertex value
	 * @param vertexValue
	 */
	@Override
	public void setVertexValue(String vertexValue) {
		this.vertexValue = vertexValue;
	}

	/**
	 * Gets the next vertex
	 * @return nextVertex
	 */
	@Override
	public Vertex getNextVertex() {
		return nextVertex;
	}

	/**
	 * Sets the next vertex
	 * @param nextVertex
	 */
	@Override
	public void setNextVertex(Vertex nextVertex) {
		this.nextVertex = nextVertex;
	}

	/**
	 * Gets the next edge
	 * @return nextEdge
	 */
	@Override
	public Edge getNextEdge() {
		return nextEdge;
	}

	/**
	 * Sets the edge
	 * @param nextEdge
	 */
	@Override
	public void setNextEdge(Edge nextEdge) {
		this.nextEdge = nextEdge;
	}
	
	/**
	 * Gets the visited property of the vertex
	 * @return visited
	 */
	@Override
	public Boolean getVisited() {
		return visited;
	}

	/**
	 * Sets the visited property of the vertex
	 * @param visited
	 */
	@Override
	public void setVisited(Boolean visited) {
		this.visited = visited;
	}

	/**
	 * Gets the vertex capacity
	 * @return vertexCapacity
	 */
	@Override
	public int getVertexCapacity() {
		return vertexCapacity;
	}

	/**
	 * Sets the vertex capacity
	 * @param vertexCapacity
	 */
	@Override
	public void setVertexCapacity(int vertexCapacity) {
		this.vertexCapacity = vertexCapacity;
	}

	/**
	 * Gets coordinator of the graph
	 * @return coordinator
	 */
	@Override
	public Coordinator getCoordinator() {
		return coordinator;
	}

	/**
	 * Sets the coordinator of the graph
	 * @param coordinator
	 */
	@Override
	public void setCoordinator(Coordinator coordinator) {
		if(this.coordinator==null)
			this.coordinator = coordinator;
		else if(this.coordinator.getCoordinatorCapacity() < coordinator.getCoordinatorCapacity())
			this.coordinator = coordinator;
	}
}