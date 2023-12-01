/**
 * Lab05
 * @author Zache
 * 12 April 2017
 * @param <E>
 */
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
		//System.err.println("Push: " + theStack);
	}

	
	public E pop() 
	{
		//System.err.println("Pop: " + theStack);
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
