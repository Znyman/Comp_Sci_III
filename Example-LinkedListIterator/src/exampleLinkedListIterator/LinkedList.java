package exampleLinkedListIterator;
public class LinkedList<E> implements Iterable<E>
{
	private Node<E> header;
	private Node<E> trailer;
	private int size;
	
	public LinkedList()
	{
		trailer = new Node<>(null, null);
		header = new Node<>(null, trailer);
		size = 0;
	}

	
	private void insertAfter(Node<E> n, E newValue)
	{
		Node<E> newNode = new Node<>(newValue, n.nextNode);
		n.nextNode = newNode;
		
		if(n == trailer)
		{
			trailer.value = newNode.value;
			newNode.value = null;
			trailer = newNode;
		}
		size++;
	}
	
	private E removeAfter(Node<E> n)
	{
		if(size == 0)
		{
			throw new IllegalStateException("list is empty");
		}
		E v = n.nextNode.value;
		n.nextNode = n.nextNode.nextNode;
		size--;
		return v;
	}
	public void insertAtTail(E newValue)
	{
		insertAfter(trailer, newValue);
	}
	
	public void insertAtHead(E newValue)
	{
		insertAfter(header, newValue);
	}
	
	public void removeHead()
	{
		removeAfter(header);
	}
	
	public void removeTail()
	{
		if(size == 0)
		{
			throw new IllegalStateException("list is empty");
		}
		Node<E> temp = header;
		while(temp.nextNode.nextNode != trailer)
		{
			temp = temp.nextNode;
		}
		removeAfter(temp);
	}
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		
		Node<E> temp = header.nextNode;
		
		if(size == 0)
		{
			return "The list is empty!";
		}
		while(temp != trailer)
		{
			result.append(temp.toString() + ", ");
			temp = temp.nextNode;
		}
		return result.toString();
	}
	//Inner class for Node
	private static class Node<T>
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
			return ""+value.toString();
		}
	}	
	
	
	public Iterator<E> iterator()
	{
		return new LinkedListIterator();
	}
	
	
	private class LinkedListIterator implements Iterator<E> 
	{
		private Node<E> cursor;
		private Node<E> prevCursor;
		
		public LinkedListIterator()
		{
			cursor = header;
			prevCursor = header;
		}
		
		public boolean hasNext() 
		{
			return cursor.nextNode != trailer;
		}

		public E next() 
		{
			if(!hasNext())
			{
				throw new IllegalStateException("No more values to return");
			}
			prevCursor = cursor;
			cursor = cursor.nextNode;
			return cursor.value;
		}

		public void remove()
		{
			if(prevCursor == cursor)
			{
				throw new IllegalStateException("Cannot remove without next call first");
			}
			
			prevCursor.nextNode = cursor.nextNode;
			cursor = prevCursor;
			size--;
		}
		
	}
}
