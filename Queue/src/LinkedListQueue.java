
public class LinkedListQueue<E> implements Queue<E> 
{
	private DLinkedList<E> theQ;
	
	public LinkedListQueue()
	{
		theQ = new DLinkedList<>();
	}

	@Override
	public void enqueue(E v) 
	{			
		theQ.insertAtTail(v);	
	}

	@Override
	public E dequeue() 
	{
		if(theQ.size() == 0)
		{
			throw new IllegalStateException("q is empty");
		}
		return theQ.removeAtHead();
	}

	@Override
	public E front()
	{
		if(theQ.size() == 0)
		{
			throw new IllegalStateException("q is empty");
		}		
		return theQ.getFirst();
	}

	@Override
	public int size() {
		return theQ.size();
	}

}
