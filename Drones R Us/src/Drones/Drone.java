package Drones;

import Mission.*;
import Orders.*;

public interface Drone {

	/**
	 * metodo abstrato que retorna o nome do drone
	 * @return nome do drone
	 */
	abstract String getId();
	/**
	 * metodo abstrato que retorna o nome da base onde se encontra o drone
	 * @return nome da base onde se ncontra o drone
	 */
	abstract String getBaseId();
	/** 
	 * metodo abstrato que retorna a capacidade de carga do drone
	 * @return capacidade de carga do drone
	 */
	abstract int getCarry();
	/**
	 * metodo abstrato que retorna a distancia que o drone pode percorrer
	 * @return distancia maxima do drone
	 */
	abstract int getRange();
	/**
	 * metodo abstrato que adiciona uma missao ao drone uma missao de base para base ou uma missao de entrega
	 * @param m missao a ser adicionada
	 */
	abstract void addMission(Mission m);
	/**
	 * metodo abstrato que retorna um contador para saber se existe missao ou nao no drone
	 * @return contador de missoes
	 */
	abstract int getMissionCount();
	/**
	 * metodo abstrato que retorna a missao do drone
	 * @return missao do drone
	 */
	Mission getMission();
	/**
	 * metodo que retorna a distancia percorrida pelo drone
	 * @return distancia percorrida do drone
	 */
	abstract int getFlying();
	/**
	 * metodo que avanca a distancia percorrida pelo trone por 10
	 */
	abstract void tick();
	/**
	 * nao usada
	 */
	abstract void setRange();
	/**
	 * nao usada
	 * @param o
	 */
	abstract void addOrder(Order o);
	/**
	 * nao usada
	 * @return
	 */
	abstract Order getOrder();
}
