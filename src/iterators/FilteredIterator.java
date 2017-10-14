package iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FilteredIterator<T> implements Iterator<T> {
	private Iterator<T> itr;
	private Filter<T> filter;
	private boolean isFound;
	private T nextObj;

	public FilteredIterator(Iterator<T> itr, Filter<T> filter) {
		this.itr = itr;
		this.filter = filter;
		isFound = false;
	}

	@Override
	public boolean hasNext() {
		return isFound || setNextObject();
	}

	@Override
	public T next() {
		if(!isFound) {
			if(!setNextObject()) {
				throw new NoSuchElementException();
			}
		}
		isFound = false;
		return nextObj;
	}

	private boolean setNextObject() {
		while(itr.hasNext()) {
			T obj = itr.next();
			if(filter.isValid(obj)) {
				nextObj = obj;
				isFound = true;
				return true;
			}
		}
		return false;
	}
	
}
