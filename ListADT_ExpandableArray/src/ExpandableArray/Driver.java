package ExpandableArray;

public class Driver {

	public static void main(String[] args) 
	{
		ExpandableArrayList<Integer> a = new ExpandableArrayList<>();
		
		System.out.println(a);
		
		for(int i=0; i < 100; i++)
		{
			a.add(i);
			System.out.println(a);
		}

		System.out.println(a.capacity());
		
		a.set(15, 0);
		System.out.println(a);
		
		a.remove(3);
		a.remove(0);
		a.remove(a.size()-1);
		System.out.println(a);


	}

}
