/**
 * Lab01
 * @author Zachery Nyman
 * 31 March 2017
 */
public class LinkedList {
	
	private Node head;
	private int size;
	
	public LinkedList()
	{
		size = 0;
		head = null;
	}
	
	public void insertAtHead(int v)
	{
		//Allocate new node
		Node newNode = new Node(v, head);
		
		//Change head to point to new node
		head = newNode;
		
		//Increase size
		size++;
	}
	
	public void insertAtTail(int v)
	{
		//List is empty
		if(head == null)
		{
			head = new Node(v, null);
			size++;
			return;
		}
		Node temp = head;
		//Advance until temp is pointing to last node
		while(temp.nextNode != null)
		{
			temp = temp.nextNode;
		}
		
		//I am at the last node
		Node newNode = new Node(v, null);
		
		//Change temp's next to point to the new node
		temp.nextNode = newNode;
		size++;
	}
	
	public String min()
	{
		if(head == null)
		{
			throw new NullPointerException("List is empty. Cannot search for min.");
		}
		
		Node temp = head;
		int min = temp.value;
		
		while(temp != null)
		{
			if(temp.value < min)
			{
				min = temp.value;
			}
			temp = temp.nextNode;
		}
		return "The minimum value in the list is: " + min;
	}
	
	public String max()
	{
		if(head == null)
		{
			throw new NullPointerException("List is empty. Cannot search for max.");
		}
		
		Node temp = head;
		int max = temp.value;
		
		while(temp != null)
		{
			if(temp.value > max)
			{
				max = temp.value;
			}
			temp = temp.nextNode;
		}
		return "The maximum value in the list is: " + max;
	}
	
	public int removeHead()
	{
		if(head == null)
		{
			throw new IllegalStateException("List is empty. Cannot delete.");
		}
		int value = head.value;
		head = head.nextNode;
		size--;
		return value;
	}
	
	public void removeLast()
	{
		if(head == null)
		{
			throw new IllegalStateException("List is empty. Cannot delete.");
		}
		if(head.nextNode == null)
		{
			head = null;
			size--;
		}
		else
		{
			Node temp = head;
			while(temp.nextNode.nextNode != null)
			{
				temp = temp.nextNode;
			}
			temp.nextNode = null;
			size--;
		}
	}
	
	public String toString()
	{
		if(head == null)
		{
			return "The list is empty.";
		}
		String result = "";
		
		Node temp = head;
		
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
	
	private class Node
	{
		private int value;
		private Node nextNode;
		public Node(int x, Node n)
		{
			value = x;
			nextNode = n;
		}
		
		public String toString()
		{
			return "" + value;
		}
	}
	
}
