
public interface Queue<E>
{
	public void enqueue(E v);
	public E dequeue();
	public E front();
	public int size();

}
