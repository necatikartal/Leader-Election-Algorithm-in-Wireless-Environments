package com.neco4j.graph;

/**
 * Coordinator interface
 * @author Necati Kartal
 */
public interface ICoordinator {

	/**
	 * Gets the coordinator name
	 * @return
	 */
	String getCoordinatorName();

	/**
	 * Sets the coordinator name
	 * @param coordinatorName
	 */
	void setCoordinatorName(String coordinatorName);

	/**
	 * Gets the coordinator capacity
	 * @return coordinatorCapacity
	 */
	int getCoordinatorCapacity();

	/**
	 * Sets the coordinator capacity
	 * @param coordinatorCapacity
	 */
	void setCoordinatorCapacity(int coordinatorCapacity);
}