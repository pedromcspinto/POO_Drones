package Iterators;

import Bases.Base;

public class BaseIteratorClass implements BaseIterator{
	private int currentBase;
	private int counter;
	private Base[]bases;
	
	public BaseIteratorClass(Base[]bases, int counter) {
		this.bases=bases;
		this.counter=counter;
	}

	@Override
	public void initializeIterator() {
		currentBase=0;
	}

	@Override
	public boolean hasNext() {
		return (currentBase >= 0 ) && (currentBase < counter);
	}

	@Override
	public Base next() {
		return bases[currentBase++];
	}	
}
