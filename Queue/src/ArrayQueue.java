
public class ArrayQueue<E> implements Queue<E>
{
	private E[] theQ;
	private int size;
	private int front;
	private int back;

	public ArrayQueue(int s)
	{
		theQ = (E[]) new Object[s];
		size = 0;
		front = 0;
		back = 0;
	}
	public void enqueue(E v) 
	{
		if(size >= theQ.length)
		{
			throw new IllegalStateException("Queue is full");
		}
		theQ[back] = v;
		size++;
		back = (back + 1) % theQ.length; 
	}

	public E dequeue() 
	{
		if(size == 0)
		{
			throw new IllegalStateException("the Queue is empty");
		}
		E theValue = theQ[front];
		theQ[front] = null;
		size--;
		front = (front + 1) % theQ.length;
		return theValue;
	}

	
	public E front() 
	{
		if(size == 0)
		{
			throw new IllegalStateException("the Queue is empty");
		}
		return theQ[front];
	}

	public int size() 
	{
		return size;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder("[");
		
		for(int i= 0; i < size; i++)
		{
			sb.append(theQ[(front + i) % theQ.length] + " ");
		}
		
		return sb.toString() + "]";
	}
	
	public static void main(String[] args)
	{
		ArrayQueue<Integer> q1 = new ArrayQueue<>(10);
		System.out.println(q1);
		
		
		for(int i=0; i < 7; i++)	
		{
			q1.enqueue(i);
			System.out.println(q1);
		}

		for(int i=0; i < 4; i++)
		{
			q1.dequeue();
			System.out.println(q1);
		}
		
		for(int i=0; i < 20; i++)
		{
			q1.enqueue(i+50);
			q1.dequeue();
			System.out.println("Front: " + q1.front + ", back: " + q1.back + " " + q1);
			

			
		}
		
	}

}
