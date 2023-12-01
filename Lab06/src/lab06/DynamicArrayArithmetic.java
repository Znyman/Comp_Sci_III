/**
 * Lab06
 * @author Zachery Nyman
 * 17 April 2017
 */
package lab06;

public class DynamicArrayArithmetic<E> extends ExpandableArrayList<E>
{
	
	DynamicArrayArithmetic()
	{
		super();
	}
	
	@Override
	protected void expandArray()
	{
		E[] tempArray = (E[]) new Object[super.capacity() + 10000];
		
		for(int i=0; i < super.size(); i++)
		{
			tempArray[i] = super.get(i);
		}
		
		theArray = tempArray;
	}
	
}
