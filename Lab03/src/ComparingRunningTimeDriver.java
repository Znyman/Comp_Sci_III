/**
 * Lab03
 * @author Zachery Nyman
 * 05 April 2017
 */
import java.util.ArrayList;

public class ComparingRunningTimeDriver
{
	public static void main (String[] args)
	{
		LinkedList<Integer> linkedList = new LinkedList<>();
		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
		
		long start, end;
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		for(int n = 50000; n <= 200000; n += 50000)
		{
			start = System.currentTimeMillis();
			for(int i = 0; i < n; i++)
			{
				arrayList.add(0, n+1);
			}
			end = System.currentTimeMillis();
			System.out.println(n + " , " + (end - start));
			start = System.currentTimeMillis();
			for(int i = 0; i < n; i++)
			{
				arrayList.remove(arrayList.size()-1);
			}
			end = System.currentTimeMillis();
			System.out.println(n + " , " + (end - start));
		}
		
		for(int n = 50000; n <= 200000; n += 50000)
		{
			start = System.currentTimeMillis();
			for(int i = 0; i < n; i++)
			{
				linkedList.insertAtHead(n+1);
			}
			end = System.currentTimeMillis();
			System.out.println(n + " , " + (end - start));
			start = System.currentTimeMillis();
			for(int i = 0; i < n; i++)
			{
				linkedList.removeTail();
			}
			end = System.currentTimeMillis();
			System.out.println(n + " , " + (end - start));
		}
		
		for(int n = 50000; n <= 200000; n += 50000)
		{
			start = System.currentTimeMillis();
			for(int i = 0; i < n; i++)
			{
				doublyLinkedList.insertAtHead(n+1);;
			}
			end = System.currentTimeMillis();
			System.out.println(n + " , " + (end - start));
			start = System.currentTimeMillis();
			for(int i = 0; i < n; i++)
			{
				doublyLinkedList.removeTail();
			}
			end = System.currentTimeMillis();
			System.out.println(n + " , " + (end - start));
		}
	}
	
}
