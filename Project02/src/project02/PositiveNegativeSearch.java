/**
 * Project02
 * @author Zachery Nyman
 * 14 April 2017
 */
package project02;

public class PositiveNegativeSearch {
	
	public static boolean sequentialSearch(int[] arr)//O(n^2)
	{
		int value;
		for(int i = 0; i < arr.length-1; i++)
		{
			value = arr[i]*-1;
			for(int j = 0; j < arr.length-1; j++)
			{
				if(arr[j] == value)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean binarySearch(int[] arr)//O(nLog n)
	{
		int value, middle;
		for(int i = 0; i < arr.length-1; i++)
		{
			int first = 0, last = arr.length-1;
			value = arr[i]*-1;
			while(first <= last)
			{
				middle = (first+last)/2;
				if(arr[middle] == value)
				{
					return true;
				}
				else if(value < arr[middle])
				{
					last= middle-1;
				}
				else
				{
					first = middle+1;
				}
			}
		}
		return false;
	}
	
	public static boolean sumSearch(int[] arr)//O(n)
	{
		int i = 0;
		int j = arr.length-1;
		int startValue, endValue;
		while(i != j)
		{
			startValue = arr[i];
			endValue = arr[j];
			if((startValue + endValue) == 0)
			{
				return true;
			}
			else if((startValue + endValue) < 0)
			{
				i++;
			}
			else if((startValue + endValue) > 0)
			{
				j--;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
