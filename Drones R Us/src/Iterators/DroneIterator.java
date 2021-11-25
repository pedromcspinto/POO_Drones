package Iterators;

import Drones.Drone;

public interface DroneIterator {
	/**
	 * 
	 * metodo que inicializa o iterador
	 */
	public void initializeIterator();
	/**
	 * metodo que sabe se ha proximo objeto
	 * @return se ha proximo objeto
	 */
	public boolean hasNext();
	/**
	 * devolve o atual objeto
	 * @return atual objeto do tipo Drone
	 */
	public Drone next();
}
