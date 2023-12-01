package exampleLinkedListIterator;

public class IteratorExampleDriver 
{
	public static void main(String[] args)
	{
		LinkedList<Integer> l = new LinkedList<>();
		
		for(int i=0; i < 10; i++)
		{
			l.insertAtHead(i);
		}
		
		System.out.println(l);
		
		Iterator<Integer> it = l.iterator(); 
		
		while(it.hasNext())
		{
			if(it.next() % 2 != 0)
			{
				it.remove();
			}
		}
		
		System.out.println(l);

		Iterator<Integer> it1 = l.iterator();
		Iterator<Integer> it2 = l.iterator();
		
		System.out.println(it1.next());
		it1.remove();
		System.out.println(l);
		System.out.println(it1.next());
		it1.remove();
		System.out.println(l);
		System.out.println(it1.next());
		it1.remove();
		System.out.println(l);
		System.out.println(it2.next());
		System.out.println(it2.next());
		System.out.println(it1.next());
		//System.out.println(it2.next());
		System.out.println(l);


	}

}
