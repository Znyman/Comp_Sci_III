/**
 * Project03
 * @author Zachery Nyman
 * 21 April 2017
 */

package project03;
public interface Queue<E>
{
	public void enqueue(E v);
	public E dequeue();
	public E front();
	public int size();

}
