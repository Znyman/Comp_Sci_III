/**
 * Project03
 * @author Zachery Nyman
 * 21 April 2017
 * Big O is commented out next to the search methods
 */

package project03;

public class Project03Driver
{
	public static void main(String[] args)
	{
		long start, end;
		
		System.out.println(FireProbability.computeVegetationProbability());
		
		Forest forest = new Forest(20, 20, (float) 1.0);
		Forest forest2 = new Forest(20, 20, (float) 1.0);
		
		System.out.println("Grid dimensions:\nHeight: " + forest.getHeight() + "\nWidth: "+ forest.getWidth());
		
		for(int n = 50000; n <= 1600000; n *= 2)
		{
			start = System.currentTimeMillis();
			for(int i = 0; i < n; i++)
			{
				forest.DepthFirstSearch();//O(n)
			}
			end = System.currentTimeMillis();
			System.out.println("Depth first search: " + n + " , " + (end - start));
		}
		
		
		for(int n = 50000; n <= 1600000; n *= 2)
		{
			start = System.currentTimeMillis();
			for(int i = 0; i < n; i++)
			{
				forest.BreadthFirstSearch();//O(logn)
			}
			end = System.currentTimeMillis();
			System.out.println("Breadth first search: " + n + " , " + (end - start));
		}
	}
}
