/**
 * Lab03
 * @author Zachery Nyman
 * 05 April 2017
 */
public class LinkedList<E> {
	
	private Node<E> head,tail;
	private int size;
	
	public LinkedList()
	{
		size = 0;
		head = null;
		tail = null;
	}
	
	public void insertAtHead(E v)
	{
		//Allocate new node
		Node<E> newNode = new Node<>(v, head);
		
		//Change head to point to new node
		head = newNode;
		
		if(tail == null)
		{
			tail = head;
		}
		
		//Increase size
		size++;
	}
	
	public void insertAtTail(E v)
	{
		//List is empty
		if(tail == null)
		{
			tail = new Node<>(v, null);
			head = tail;
			size++;
			return;
		}
		Node<E> newNode = new Node<>(v, null);
		tail.nextNode = newNode;
		tail = newNode;
		size++;
	}
	
	public E removeHead()
	{
		if(head == null)
		{
			throw new IllegalStateException("List is empty. Cannot delete.");
		}
		E value = head.value;
		head = head.nextNode;
		size--;
		return value;
	}
	
	public void removeTail()
	{
		if(head == null)
		{
			throw new IllegalStateException("List is empty. Cannot delete.");
		}
		else if(head == tail)
		{
			head = tail = null;
		}
		else
		{
			Node<E> temp = head;
			while(temp.nextNode != tail)
			{
				temp = temp.nextNode;
			}
			tail = temp;
			tail.nextNode = null;
		}
		size--;
	}
	
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		Node<E> temp = head.nextNode;
		while(temp != tail)
		{
			result = result.append(temp.value.toString());
			temp = temp.nextNode;
		}
		return result.toString();
	}
	
	public int getSize()
	{
		return size;
	}
	
	private class Node<T>
	{
		private T value;
		private Node<T> nextNode;
		public Node(T v, Node<T> n)
		{
			value = v;
			nextNode = n;
		}
		
		public String toString()
		{
			return "" + value;
		}
	}
	
}
