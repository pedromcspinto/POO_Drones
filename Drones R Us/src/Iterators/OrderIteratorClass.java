package Iterators;

import Orders.Order;

public class OrderIteratorClass implements OrderIterator{
	int currentOrder;
	int counter;
	Order[]orders;
	
	public OrderIteratorClass(Order[]orders, int counter) {
		this.counter=counter;
		this.orders=orders;
	}

	@Override
	public void initializeIterator() {
		currentOrder=0;
		
	}

	@Override
	public boolean hasNext() {
		return (currentOrder >= 0 ) && (currentOrder < counter);
	}

	@Override
	public Order next() {
		return orders[currentOrder++];
	}
}
