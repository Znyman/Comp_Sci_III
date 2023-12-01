/**
 * Lab06
 * @author Zachery Nyman
 * 17 April 2017
 */
package lab06;

public interface List<E>
{
	public void add(E v);
	public void add(E v, int index);
	public E remove(int index);
	public E get(int index);
	public E set(E v, int index);
	public int size();
}
