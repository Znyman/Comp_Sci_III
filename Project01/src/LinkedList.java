/**
 * Project 01
 * @author Zachery Nyman
 * 07 April 2017
 */
public class LinkedList<E> {
	
	private Node<E> head, tail;
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
	
	public boolean remove(E character)
	{
		if(head == null)
		{
			throw new IllegalStateException("List is empty. Cannot delete.");
		}
		else if(head.value.equals(character))
		{
			removeHead();
			return true;
		}
		else if(tail.value.equals(character))
		{
			removeTail();
			return true;
		}
		else
		{
			Node<E> temp = head;
			while((temp.nextNode != null) && !(temp.nextNode.value.equals(character)))
			{
				temp = temp.nextNode;
			}
			if(temp.nextNode == null)
			{
				return false;
			}
			temp.nextNode = temp.nextNode.nextNode;
			size--;
			return true;
		}
	}
	
	private E removeHead()
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
	
	private void removeTail()
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
		if(head == null)
		{
			return "The list is empty.";
		}
		String result = "";
		
		Node<E> temp = head;
		
		while(temp != null)
		{
			result += temp.toString() + " ";
			temp = temp.nextNode;
		}
		return result;
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
