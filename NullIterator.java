package assignment06;

import java.util.Iterator;

public class NullIterator implements Iterator<MComp> {

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MComp next() {
		// TODO Auto-generated method stub
		return null;
	}
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
