import java.util.ArrayList;

public class GenericsDriver {

	public static void main(String[] args) 
	{
		Container<Integer> c1 = new Container<>(5);
		System.out.println(c1);
		Container<String> c2 = new Container<>("Hello World");
		System.out.println(c2);
		Container<ArrayList<Integer>> c3 = new Container<>(new ArrayList<Integer>());
		c3.getValue().add(3);//c3 is of type container
		c3.getValue().add(5);//have to use .getValue to determine type of object
		c3.getValue().add(7);
		System.out.println(c3);
		
		Pair<Integer, String> p1 = new Pair(5, "Hello");
		System.out.println(p1);
	}

}
