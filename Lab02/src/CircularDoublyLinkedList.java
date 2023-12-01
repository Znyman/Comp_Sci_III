/**
 * Lab02
 * @author Zachery Nyman
 * 03 April 2017
 * @param <E>
 */

public class CircularDoublyLinkedList<E>
{
	private Node<E> cursor;
	private int size;
	
	public CircularDoublyLinkedList()
	{
		size = 0;
		cursor = new Node<>(null, null, null);
	}
	
	public void addAfterCursor(E value)
	{
		if(cursor.next == null)
		{
			cursor = new Node<>(value, null, null);
			cursor.next = cursor;
			cursor.previous = cursor;
			size++;
		}
		else
		{
			insertBetween(value, cursor, cursor.next);
		}
	}
	
	private void insertBetween(E v, Node<E> first, Node<E> second)
	{
		Node<E> newNode = new Node<>(v, second, first);
		first.next = newNode;
		second.previous = newNode;
		size++;
	}
	
	public void deleteCursor()
	{
		if(cursor.next == null)//the list is empty/null
		{
			throw new IllegalStateException("The list is empty. Cannot delete cursor");
		}
		
		cursor.previous.next = cursor.next;
		cursor.next.previous = cursor.previous;
		advanceCursor(1);
		size--;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void advanceCursor(int n)
	{
		if(cursor.next == null)//the list is empty/null
		{
			throw new IllegalStateException("The list is empty. Cannot advance cursor");
		}
		
		for(int i = 0; i < n; i++)
		{
			cursor = cursor.next;
		}
	}
	
	public E getValue()
	{
		return cursor.value;
	}
	
	public String toString()
	{
		if(size == 0)
		{
			return "The list is empty.";
		}
		String result = "";
		
		Node<E> temp = cursor;
		
		for(int i = 0; i < size; i++)
		{
			result += temp.toString() + " ";
			temp = temp.next;
		}
		return result;
	}
	
	private static class Node<T>//inner class/nested class; static class doesn't have access to anything from outer class
	{
		private T value;
		private Node<T> next;
		private Node<T> previous;
		
		public Node(T v, Node<T> n, Node<T> p)
		{
			value = v;
			next = n;
			previous = p;
		}
		
		public String toString()
		{
			return value.toString();
		}
	}
}
