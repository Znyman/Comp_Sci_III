/**
 * Lab02
 * @author Zachery Nyman
 * 03 April 2017
 * @param <E>
 */

import java.util.Random;

public class CircularDoublyLinkedListDriver {

	public static void main(String[] args) 
	{
		CircularDoublyLinkedList<Integer> list = new CircularDoublyLinkedList<>();
		Random randomNumber = new Random();
		
		for(int i = 0; i < 10; i++)
		{
			list.addAfterCursor(i+1);
		}
		System.out.println("List before removed value: " + list);
		
		int random;
		while(list.getSize() != 0)
		{
			random = randomNumber.nextInt(10);
			System.out.println("Cursor is advanced " + random + " times");
			list.advanceCursor(random);
			System.out.println("Deleted cursor value: " + list.getValue());
			list.deleteCursor();
			System.out.println("List after removed value: " + list);
		}
		
	}

}
