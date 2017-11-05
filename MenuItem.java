package assignment06;

import java.util.Iterator;

public class MenuItem implements MComp {
	private String name;
	private String description;
	private boolean vegetarian;
	private double price;
	
	public MenuItem(String n, String d, boolean v, double p) {
		name = n;
		description = d;
		vegetarian = v;
		price = p;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public boolean isVegetarian() {
		return vegetarian;
	}

	@Override
	public void print() {
		System.out.print("\t" + getName());
		if(isVegetarian()) {
			System.out.print("(v)");
		}
		System.out.println(", " + getPrice());
		System.out.println("\t\t--" + getDescription());
		
	}

	@Override
	public Iterator<MComp> iterator() {
		// TODO Auto-generated method stub
		return new NullIterator();
	}

}
