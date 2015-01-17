package com.neco4j.graph;

/**
 * Coordinator class that coordinator interface
 * @author Necati Kartal
 */
public class Coordinator implements ICoordinator {

	private String coordinatorName;
	private int coordinatorCapacity;
	
	/**
	 * No-argument coordinator constructor
	 */
	public Coordinator() {
		this.setCoordinatorName(null);
		this.setCoordinatorName(null);
	}
	
	/**
	 * Two-argument coordinator constructor
	 * @param coordinatorName
	 * @param coordinatorCapacity
	 */
	public Coordinator(String coordinatorName,int coordinatorCapacity) {
		this.setCoordinatorName(coordinatorName);
		this.setCoordinatorCapacity(coordinatorCapacity);
	}

	/**
	 * Gets the coordinator name
	 * @return
	 */
	@Override
	public String getCoordinatorName() {
		return coordinatorName;
	}

	/**
	 * Sets the coordinator name
	 * @param coordinatorName
	 */
	@Override
	public void setCoordinatorName(String coordinatorName) {
		this.coordinatorName = coordinatorName;
	}

	/**
	 * Gets the coordinator capacity
	 * @return coordinatorCapacity
	 */
	@Override
	public int getCoordinatorCapacity() {
		return coordinatorCapacity;
	}

	/**
	 * Sets the coordinator capacity
	 * @param coordinatorCapacity
	 */
	@Override
	public void setCoordinatorCapacity(int coordinatorCapacity) {
		this.coordinatorCapacity = coordinatorCapacity;
	}
}