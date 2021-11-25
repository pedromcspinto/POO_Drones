package Iterators;

import Drones.Drone;

public class DroneIteratorClass implements DroneIterator{
	private int currentDrone;
	private int counter;
	private Drone[]drones;
	
	public DroneIteratorClass(Drone[]drones, int counter){
		this.drones=drones;
		this.counter=counter;
		
	}

	@Override
	public void initializeIterator() {
		currentDrone=0;
		
	}

	@Override
	public boolean hasNext() {
		return (currentDrone >= 0 ) && (currentDrone < counter);
	}

	@Override
	public Drone next() {
		return drones[currentDrone++];
	}

}
