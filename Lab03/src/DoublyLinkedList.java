/**
 * Lab03
 * @author Zachery Nyman
 * 05 April 2017
 */
public class DoublyLinkedList<E>
{
	private int size;
	private Node<E> header;//if type was not specified, then type will be of type object, and almost nothing will work
	private Node<E> trailer;
	
	public DoublyLinkedList()
	{
		size = 0;
		
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, null, header);
		header.next = trailer;
	}
	
	public void insertAtHead(E v)
	{
		insertBetween(v, header, header.next);
	}
	
	public void insertAtTail(E v)
	{
		insertBetween(v, trailer.previous, trailer);
	}
	
	private void insertBetween(E v, Node<E> first, Node<E> second)
	{
		Node<E> newNode = new Node<>(v, second, first);
		first.next = newNode;
		second.previous = newNode;
		size++;
	}
	
	public E removeHead()
	{
		return removeBetween(header, header.next.next);
	}
	
	public E removeTail()
	{
		return removeBetween(trailer.previous.previous, trailer);
	}
	
	private E removeBetween(Node<E> first, Node<E> second)
	{
		if(header.next == trailer)//the list is empty/null
		{
			throw new IllegalStateException("The list is empty.");
		}
		E result = first.next.value;
		first.next = second;
		second.previous = first;
		size--;
		return result;
	}
	
	public String toStringBackward()
	{
		if(size == 0)
		{
			return "The list is empty.";
		}
		
		String r = " ";
		Node<E> temp = trailer.previous;
		while(temp != header)
		{
			r += temp + " ";
			temp = temp.previous;
		}
		return r;
	}
	
	public String toString()
	{
		if(size == 0)
		{
			return "The list is empty.";
		}
		StringBuilder result = new StringBuilder();
		Node<E> temp = header.next;
		while(temp != trailer)
		{
			result = result.append(temp.value.toString());
			temp = temp.next;
		}
		/*
		String r = " ";
		Node<E> temp = header.next;
		while(temp != trailer)
		{
			r += temp + " ";
			temp = temp.next;
		}
		return r;
		*/
		return result.toString();
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
