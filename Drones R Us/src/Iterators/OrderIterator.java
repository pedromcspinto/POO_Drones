package Iterators;

import Orders.Order;

public interface OrderIterator {
	/**
	 * metodo que inicializa o iterador
	 */
	public void initializeIterator();
	/**
	 * metodo que sabe se existe um proximo objeto
	 * @return se existe proximo objeto
	 */
	public boolean hasNext();
	/**
	 * metodo que aponta o atual objeto 
	 * @return objeto atual do tipo Order
	 */
	public Order next();
}
