package assignment06;
import java.util.ArrayList;
import java.util.Collections;
import assignment06.TriangleClassifier.Triple;
import static assignment06.TriangleClassifier.createTriple;
import static assignment06.TriangleClassifier.removeScalene;

public class Tester {
	public static void main(String[] args) {
		ArrayList<Triple> list = new ArrayList<Triple>();
		list.add(createTriple(4,6,7));
		list.add(createTriple(3,3,3));
		list.add(createTriple(4,4,3));
		list.add(createTriple(3,4,5));
		list.add(createTriple(2,3,4));
		list.add(createTriple(4,4,6));
		
		
		
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		removeScalene(list);
		System.out.println(list);
	}
}
