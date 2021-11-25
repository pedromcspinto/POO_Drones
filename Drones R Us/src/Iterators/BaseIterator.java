package Iterators;

import Bases.Base;

public interface BaseIterator {
	/**
	 * metodo que inicializa o iterador
	 */
	public void initializeIterator();
	/**
	 * metodo que sabe se ha proximo objeto
	 * @return
	 */
	public boolean hasNext();
	/**
	 * metodo que retorna o objeto atual
	 * @return objeto atual num array do tipo Base
	 */
	public Base next();
}
