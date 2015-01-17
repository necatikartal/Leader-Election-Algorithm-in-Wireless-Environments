package com.neco4j.graph;

/**
 * Message class that implements message interface
 * @author Necati Kartal
 */
public class Message implements IMessage {

	private Vertex senderVertex;
	private Vertex receiverVertex;

	/**
	 * No-argument message constructor
	 */
	public Message() {
		this.setSenderVertex(null);
		this.setReceiverVertex(null);
	}
	
	/**
	 * Two-argument message constructor
	 * @param senderVertex
	 * @param receiverVertex
	 */
	public Message(Vertex senderVertex,Vertex receiverVertex) {
		this.setSenderVertex(senderVertex);
		this.setReceiverVertex(receiverVertex);
	}
	
	/**
	 * Gets the sender vertex
	 * @return senderVertex
	 */
	@Override
	public Vertex getSenderVertex() {
		return senderVertex;
	}

	/**
	 * Sets the sender vertex
	 * @param senderVertex
	 */
	@Override
	public void setSenderVertex(Vertex senderVertex) {
		this.senderVertex = senderVertex;
	}

	/**
	 * Gets the receiver vertex
	 * @return receiverVertex
	 */
	@Override
	public Vertex getReceiverVertex() {
		return receiverVertex;
	}

	/**
	 * Gets the receiver vertex
	 * @param receiverVertex
	 */
	@Override
	public void setReceiverVertex(Vertex receiverVertex) {
		this.receiverVertex = receiverVertex;
	}
}