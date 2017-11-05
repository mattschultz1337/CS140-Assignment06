package assignment06;

import static org.junit.Assert.*;

import org.junit.Test;

public class JTest {

	@Test
	public void testCheap() {
		MComp menu = MCompTester.makeTest();
		MenuItem cheapest = MCompTester.cheapest(menu);
		if(cheapest.getName()=="Apple Pie") {
			cheapest.print();
			return;
		}
		else {
			cheapest.print();
			fail();
		}
	}
	@Test
	public void testDear() {
		MComp menu = MCompTester.makeTest();
		MenuItem dearest = MCompTester.dearest(menu);
		if(dearest.getName()=="Burrito") {
			dearest.print();
			return;
		}
		else {
			dearest.print();
			fail();
		}
	}@Test
	public void testDesc() {
		MComp menu = MCompTester.makeTest();
		MenuItem longest = MCompTester.longestDesc(menu);
		if(longest.getName()=="Veggie Burger and Air Fries") {
			longest.print();
			return;
		}
		else {
			longest.print();
			fail();
		}
	}
}

