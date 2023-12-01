package lab07;

import java.util.Iterator;

public class Lab07Driver {

	public static void main(String[] args)
	{
		DoublyLinkedList<Integer> dLL = new DoublyLinkedList<>();
		Iterator<Integer> it1 = dLL.iterator();
		Iterator<Integer> it2 = dLL.iterator();
		Iterator<Integer> it3 = dLL.iterator();
		Iterator<Integer> it4 = dLL.iterator();
		TwoWayIterator<Integer> twoWayIt = dLL.twoWayIterator();
		long start, end;
		
		//it1.remove();
		
		for(int n = 1000000; n <= 8000000; n *= 2)
		{
			for(int i = 0; i < n; i++)//initialize the array
			{
				dLL.addLast(i+1);
			}
			
			if(n == 1000000)
			{
				start = System.currentTimeMillis();
				while(it1.hasNext())
				{
					it1.next();
				}
				end = System.currentTimeMillis();
				System.out.println("Iterator 1 next: " + n + ", " + (end - start));
			}
			else if(n == 2000000)
			{
				start = System.currentTimeMillis();
				while(it2.hasNext())
				{
					it2.next();
				}
				end = System.currentTimeMillis();
				System.out.println("Iterator 2 next: " + n + ", " + (end - start));
			}
			else if(n == 4000000)
			{
				start = System.currentTimeMillis();
				while(it3.hasNext())
				{
					it3.next();
				}
				end = System.currentTimeMillis();
				System.out.println("Iterator 3 next: " + n + ", " + (end - start));
			}
			else if(n == 8000000)
			{
				start = System.currentTimeMillis();
				while(it4.hasNext())
				{
					it4.next();
				}
				end = System.currentTimeMillis();
				System.out.println("Iterator 4 next: " + n + ", " + (end - start));
			}
			
			start = System.currentTimeMillis();
			while(twoWayIt.hasNext())
			{
				twoWayIt.next();
			}
			end = System.currentTimeMillis();
			System.out.println("Two way iterator next: " + n + ", " + (end - start));
			//rewind cursor
			start = System.currentTimeMillis();
			while(twoWayIt.hasPrevious())
			{
				twoWayIt.previous();
			}
			end = System.currentTimeMillis();
			System.out.println("Two way iterator previous: " + n + ", " + (end - start));
		}
		
		start = System.currentTimeMillis();
		while(it1.hasNext())
		{
			it1.next();
		}
		end = System.currentTimeMillis();
		System.out.println("Iterator 1 next: " + (end - start));
		start = System.currentTimeMillis();
		while(it2.hasNext())
		{
			it2.next();
		}
		end = System.currentTimeMillis();
		System.out.println("Iterator 2 next: " + (end - start));
		start = System.currentTimeMillis();
		while(it3.hasNext())
		{
			it3.next();
		}
		end = System.currentTimeMillis();
		System.out.println("Iterator 3 next: " + (end - start));
		start = System.currentTimeMillis();
		while(it4.hasNext())
		{
			it4.next();
		}
		end = System.currentTimeMillis();
		System.out.println("Iterator 4 next: " + (end - start));
	}

}
