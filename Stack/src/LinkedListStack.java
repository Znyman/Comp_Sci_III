
public class LinkedListStack<E> implements Stack<E> 
{
	private DLinkedList<E> theStack;
	
	public LinkedListStack()
	{
		theStack = new DLinkedList<>();
	}

	@Override
	public void push(E v) 
	{
		theStack.insertAtHead(v);
		
	}

	
	public E pop() 
	{
		return theStack.removeAtHead();
	}

	
	public E top() 
	{
		return theStack.getFirst();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
