package com.neco4j.graph;

import java.util.ArrayList;
import java.util.Iterator;

public class Graph implements IGraph {

	public Vertex vertexHead;

	/**
	 * Add a vertex to the graph
	 * @param vertexValue
	 * @param vertexCapacity
	 */
	@Override
	public void addVertex(String vertexValue, int vertexCapacity) {
		if (vertexHead == null)
			vertexHead = new Vertex(vertexValue, vertexCapacity);
		else {
			Vertex iterator = vertexHead;
			while (iterator.getNextVertex() != null) {
				iterator = iterator.getNextVertex();
			}
			iterator.setNextVertex(new Vertex(vertexValue, vertexCapacity));
		}
	}

	/**
	 * Find the vertex from the graph
	 * @param vertexValue
	 * @return vertex
	 */
	@Override
	public Vertex findVertex(String vertexValue) {
		Vertex iterator = vertexHead;
		while (iterator != null) {
			if (vertexValue.compareTo(iterator.getVertexValue()) == 0)
				return iterator;
			iterator = iterator.getNextVertex();
		}
		return null;
	}

	/**
	 * Remove the vertex from the graph
	 * @param vertexValue
	 * @return true/false
	 */
	@Override
	public Boolean removeVertex(String vertexValue) {
		Vertex iterator = vertexHead;
		if (vertexValue.compareTo(iterator.getVertexValue()) == 0) {
			Edge e = iterator.getNextEdge();
			while (e != null) {
				removeEdge(iterator.getVertexValue(), e.getVertexValue());
				removeEdge(e.getVertexValue(), iterator.getVertexValue());
				e = e.getNextEdge();
			}
			vertexHead = iterator.getNextVertex();
			return true;
		}

		while (iterator.getNextVertex() != null) {
			if (vertexValue.compareTo(iterator.getNextVertex().getVertexValue()) == 0) {
				Edge e = iterator.getNextVertex().getNextEdge();
				while (e != null) {
					removeEdge(iterator.getNextVertex().getVertexValue(), e.getVertexValue());
					removeEdge(e.getVertexValue(), iterator.getNextVertex().getVertexValue());
					e = e.getNextEdge();
				}
				if (iterator.getNextVertex() != null)
					iterator.setNextVertex(iterator.getNextVertex().getNextVertex());
				else
					iterator.setNextVertex(null);
				return true;
			}
			iterator = iterator.getNextVertex();
		}
		return null;
	}

	/**
	 * Add an edge to the graph
	 * @param vertexValue
	 * @param edgeValue
	 */
	@Override
	public void addEdge(String vertexValue, String edgeValue) {
		Vertex v = findVertex(vertexValue);
		if (v == null)
			return;
		if (v.getNextEdge() == null)
			v.setNextEdge(new Edge(edgeValue));
		else {
			Edge iterator = v.getNextEdge();
			while (iterator.getNextEdge() != null)
				iterator = iterator.getNextEdge();
			iterator.setNextEdge(new Edge(edgeValue));
		}

	}

	/**
	 * Remove the edge from the graph
	 * @param vertexValue
	 * @param edgeValue
	 */
	@Override
	public void removeEdge(String vertexValue, String edgeValue) {
		
		Vertex v = findVertex(vertexValue);
		if (v == null)
			return;
		if (v.getNextEdge() == null)
			return;
		else {
			Edge iterator = v.getNextEdge();
			if (edgeValue.compareTo(iterator.getVertexValue()) == 0) {
				v.setNextEdge(v.getNextEdge().getNextEdge());
				return;
			}
			while (iterator.getNextEdge() != null) {
				if (edgeValue.compareTo(iterator.getNextEdge().getVertexValue()) == 0) {
					if (iterator.getNextEdge() != null)
						iterator.setNextEdge(iterator.getNextEdge().getNextEdge());
					else
						iterator.setNextEdge(null);
					return;
				}
				iterator = iterator.getNextEdge();
			}
		}
	}

	/**
	 * Print the graph
	 */
	@Override
	public void printGraph() {
		Vertex iteratorVertex = vertexHead;
		while (iteratorVertex != null) {
			System.out.printf("Vertex: %4s Size: %3s Neighbors: ",
					iteratorVertex.getVertexValue(), iteratorVertex.getVertexCapacity());

			Edge iteratorEdge = iteratorVertex.getNextEdge();
			while (iteratorEdge != null) {
				System.out.print("->" + iteratorEdge.getVertexValue() + ",");
				iteratorEdge = iteratorEdge.getNextEdge();
			}
			System.out.println();

			iteratorVertex = iteratorVertex.getNextVertex();
		}
	}

	/**
	 * Gets out degree of the vertex
	 * @param vertexValue
	 * @return outDegree
	 */
	@Override
	public int outDegree(String vertexValue) {
		Vertex v = findVertex(vertexValue);
		if (v != null) {
			Edge e = v.getNextEdge();
			int ec = 0;
			while (e != null) {
				ec++;
				e = e.getNextEdge();
			}
			return ec;
		}
		return -1;
	}

	/**
	 * Gets in degree of the vertex
	 * @param vertexValue
	 * @return inDegree
	 */
	@Override
	public int inDegree(String vertexValue) {
		Vertex iteratorVertex = vertexHead;
		int ec = 0;
		while (iteratorVertex != null) {
			Edge iteratorEdge = iteratorVertex.getNextEdge();
			while (iteratorEdge != null) {
				if (vertexValue.compareTo(iteratorEdge.getVertexValue()) == 0)
					ec++;
				iteratorEdge = iteratorEdge.getNextEdge();
			}
			iteratorVertex = iteratorVertex.getNextVertex();
		}
		return ec;
	}

	/**
	 * Set all vertices' visited property to false
	 */
	@Override
	public void setVerticesNotVisited() {
		Vertex iterator = vertexHead;
		while (iterator != null) {
			iterator.setVisited(false);
			iterator = iterator.getNextVertex();
		}
	}

	/**
	 * Gets the vertex counts
	 * @return vertexCount
	 */
	@Override
	public int vertexCount() {
		int count = 0;
		Vertex iterator = vertexHead;
		while (iterator != null) {
			iterator = iterator.getNextVertex();
			count++;
		}
		return count;
	}

	/**
	 * Gets the adjacency between vertex1 and vertex2
	 * @param vertex1
	 * @param vertex2
	 * @return true/false
	 */
	@Override
	public Boolean isAdjacent(String vertex1, String vertex2) {
		Vertex v1 = findVertex(vertex1);
		Vertex v2 = findVertex(vertex2);
		if (v1 == null || v2 == null)
			return false;
		Edge e = v1.getNextEdge();
		while (e != null) {
			if (e.getVertexValue().compareTo(v2.getVertexValue()) == 0)
				return true;
			e = e.getNextEdge();
		}
		return false;
	}
	
	/**
	 * Use Coordinator Election Algorithm in Wireless Environments 
	 * to find coordinator of the graph as highest capacity vertex 
	 * and let all vertices to know the coordinator.
	 * 
	 * It will work as a simulation.  
	 *
	 * @param vertexValue
	 */
	@Override
	public void electionCoordinator(String vertexValue) {
		
		setVerticesNotVisited(); // set all vertices' visited property to null

		Queue<Vertex> queue = new Queue<Vertex>(); // It will use for breadth-first search
		ArrayList<Message> list = new ArrayList<Message>(); // It will use for keeping messages between vertices

		Vertex start = findVertex(vertexValue); // Find the vertex as where the election will start
		if (start != null) {

			queue.Enqueue(start); // Start BFS
			list.add(new Message(start, start)); // Add first message to the list
			while (queue.getCount() > 0) {

				Boolean flag = true;
				Vertex v1 = queue.Dequeue();
				v1.setVisited(true);
				System.out.printf("%3.3s.vertex try to ask. ", v1.getVertexValue()); // Print out questions

				// Check all edges of the vertex if visited or not
				Edge edge = v1.getNextEdge();
				while (edge != null) {
					Vertex v2 = findVertex(edge.getVertexValue());
					if (!v2.getVisited()) {
						queue.Enqueue(v2);
						v2.setVisited(true);
						System.out.print(v2.getVertexValue() + ", ");
						flag = false;
						list.add(new Message(v1, v2));
					}
					edge = edge.getNextEdge();
				}

				// If flag is true that means the vertex can't ask to any vertex then send answer back
				if (flag) {
					Iterator<Message> it = list.iterator();
					while (it.hasNext()) {
						Message msg = it.next();
						Vertex reciever = findVertex(msg.getReceiverVertex().getVertexValue());
						Vertex sender = findVertex(msg.getSenderVertex().getVertexValue());

						if (reciever.getVertexValue().compareTo(
								v1.getVertexValue()) == 0) {
							System.out.printf("Nobody to ask. Then: %3s.vertex sending answer to %3s.vertex.",
											reciever.getVertexValue(),
											sender.getVertexValue());
							Coordinator coordinatorMSG = new Coordinator(
									reciever.getVertexValue(),
									reciever.getVertexCapacity());
							sender.setCoordinator(coordinatorMSG);
							it.remove();
						}
					}
				}
				System.out.println();
			}

			// Until 
			for (int i = list.size() - 1; i >= 1; i--) {
				Message msg = list.get(i);
				Vertex reciever = findVertex(msg.getReceiverVertex()
						.getVertexValue());
				Vertex sender = findVertex(msg.getSenderVertex()
						.getVertexValue());

				System.out.printf("%3s.vertex sending answer to %3s.vertex.",
						reciever.getVertexValue(), sender.getVertexValue());
				Coordinator coordinatorMSG = new Coordinator(
						reciever.getVertexValue(), reciever.getVertexCapacity());
				sender.setCoordinator(coordinatorMSG);
				list.remove(i);

				System.out.println();
			}
		}

		// First node which is started to ask.
		if (list.size() == 1) {
			Message msg = list.get(0);
			Vertex reciever = findVertex(msg.getReceiverVertex().getVertexValue());

			System.out.printf("%3s.vertex find out coordinator as name: %3s and size: %3d ./n",
							reciever.getVertexValue(), 
							reciever.getCoordinator().getCoordinatorName(),
							reciever.getCoordinator().getCoordinatorCapacity());
		}
		
		setVerticesNotVisited();
		queue = new Queue<Vertex>();
		list = new ArrayList<Message>();

		// Let all vertices to know the coordinator
		if (start != null) {

			queue.Enqueue(start);
			list.add(new Message(start, start));
			while (queue.getCount() > 0) {

				Boolean flag = true;
				Vertex v1 = queue.Dequeue();
				v1.setVisited(true);

				Edge edge = v1.getNextEdge();
				while (edge != null) {
					Vertex v2 = findVertex(edge.getVertexValue());
					if (!v2.getVisited()) {
						queue.Enqueue(v2);
						v2.setVisited(true);
						if (flag)
							System.out.printf("%3.3s.vertex send coordinator to ",
									v1.getVertexValue());
						System.out.print(v2.getVertexValue() + ", ");
						flag = false;
						v2.setCoordinator(v1.getCoordinator());
						list.add(new Message(v1, v2));
					}
					edge = edge.getNextEdge();
				}
				if (!flag)
					System.out.println();
			}
			System.out.printf("  All nodes know coordinator. Name:%3s Capacity:%3d ",
					start.getCoordinator().getCoordinatorName(),
					start.getCoordinator().getCoordinatorCapacity());
		}
	}
}