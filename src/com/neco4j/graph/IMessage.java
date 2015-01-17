package com.neco4j.graph;

/**
 * Message interface
 * @author Necati Kartal
 */
public interface IMessage {

	/**
	 * Gets the sender vertex
	 * @return senderVertex
	 */
	Vertex getSenderVertex();

	/**
	 * Sets the sender vertex
	 * @param senderVertex
	 */
	void setSenderVertex(Vertex senderVertex);

	/**
	 * Gets the receiver vertex
	 * @return receiverVertex
	 */
	Vertex getReceiverVertex();

	/**
	 * Gets the receiver vertex
	 * @param receiverVertex
	 */
	void setReceiverVertex(Vertex receiverVertex);
}