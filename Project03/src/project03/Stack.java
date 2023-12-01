/**
 * Project03
 * @author Zachery Nyman
 * 21 April 2017
 */

package project03;
public interface Stack<E> 
{
	public void push(E v);
	public E pop();
	public E top();
	public int size();
}
