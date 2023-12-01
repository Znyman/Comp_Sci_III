/**
 * Lab06
 * @author Zachery Nyman
 * 17 April 2017
 */

package lab06;

public class Lab06Driver {

	public static void main(String[] args) 
	{
		long start, end;
		
		DynamicArrayArithmetic<Integer> arr = new DynamicArrayArithmetic<>();
		
		System.out.println(arr);
		
		for(int n = 1000000; n <= 8000000; n *= 2)
		{
			start = System.currentTimeMillis();
			for(int i = 0; i < n; i++)//initialize the array
			{
				arr.add(69, arr.size());
			}
			end = System.currentTimeMillis();
			System.out.println(n + " , " + (end - start));
		}
		System.out.println(arr.capacity());
	}

}
