package assignment06;

import java.util.*;
import java.util.Iterator;

public class Menu implements MComp, Iterable<MComp> {
	private String description;
	private String name;
	private ArrayList<MComp> comps = new ArrayList<MComp>();
	
	public Menu(String n, String d) {
		name = n;
		description = d;
	}
	
	public Iterator<MComp> iterator() {
		// TODO Auto-generated method stub
		return new CompositeIterator(comps.iterator());
	}

	
	public void add(MComp mComp) {
		// TODO Auto-generated method stub
		comps.add(mComp);

	}

	
	public void remove(MComp mComp) {
		// TODO Auto-generated method stub
		comps.remove(mComp);

	}

	
	public MComp getChild(int i) {
		// TODO Auto-generated method stub
		return comps.get(i);
	}

	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public boolean isVegetarian() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void pushToStack(Stack<Iterator<MComp>> stack) {
		stack.push(comps.iterator());
	}

	
	public void print() {
		System.out.println("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("---------------------");
	}

}
