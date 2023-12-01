
public class ArrayStack<E> implements Stack<E>
{
	private E[] theStack;
	private int size;
	
	public ArrayStack(int s)
	{
		theStack = (E[]) new Object[s];
		size = 0;
	}
	
	public void push(E v) 
	{
		if(size == theStack.length)
		{
			throw new IllegalStateException("Stack overflow");
		}
		theStack[size] = v;
		size++;
	}

	
	public E pop()
	{
		if(size == 0)
		{
			throw new IllegalStateException("Cannot pop an empty stack");
		}
		
		E value = theStack[size-1];
		theStack[size-1] = null;
		size--;
		return value;
	}


	public E top() 
	{
		if(size == 0)
		{
			throw new IllegalStateException("Empty stack");
		}
		return theStack[size-1];
	}


	public int size()
	{
		return size;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder("[");
		for(int i=size-1; i >= 0; i--)
		{
			sb.append(theStack[i] + " ");
		}
		return sb.toString() + "]";
	}

}
