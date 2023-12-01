/**
 * LinkedList2
 * @author Zachery Nyman
 * 31 March 2017
 */
public class LinkedList {
	
	private Node head, tail;
	private int size;
	
	public LinkedList()
	{
		size = 0;
		head = null;
		tail = null;
	}
	
	public void insertAtHead(int v)
	{
		//Allocate new node
		Node newNode = new Node(v, head);
		
		//Change head to point to new node
		head = newNode;
		
		if(tail == null)
		{
			tail = head;
		}
		//Increase size
		size++;
	}
	
	public void insertAtTail(int v)//constant time
	{
		//List is empty
		if(tail == null)
		{
			tail = new Node(v, null);
			head = tail;
			size++;
			return;
		}
		Node newNode = new Node(v, null);
		tail.nextNode = newNode;
		tail = newNode;
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
		//Case 1: list empty
		if(head == null)
		{
			return;
		}
		//Case 2: list has one node
		else if(head == tail)
		{
			head = tail = null;
		}
		//Case 3: list has >1 node
		else
		{
			Node temp = head;
			while(temp.nextNode != tail)
			{
				temp = temp.nextNode;
			}
			tail = temp;
			tail.nextNode = null;
		}
		size--;
	}
	
	/*public void removeLast()
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
	}*/
	
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
