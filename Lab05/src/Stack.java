/**
 * Lab05
 * @author Zache
 * 12 April 2017
 * @param <E>
 */
public interface Stack<E> 
{
	public void push(E v);
	public E pop();
	public E top();
	public int size();
}
