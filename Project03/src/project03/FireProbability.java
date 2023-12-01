/**
 * Project03
 * @author Zachery Nyman
 * 21 April 2017
 */

package project03;

public class FireProbability<E>
{
	private static <E> float computeFireSpread(float thisP)
	{
		float count = 0;
		float p = thisP;
		for(int i = 0; i < 10000; i++)
		{
			Forest<E> forest = new Forest<>(20, 20, p);
			if(forest.DepthFirstSearch())
			{
				count++;
			}
		}
		return (float) (count/10000.0);
	}
	
	public static String computeVegetationProbability()
	{
		float p = 0;
		float low = 0;
		float high = 1;
		
		for(int i = 0; i < 20; i++)
		{
			p = (high+low)/2;
			if(computeFireSpread(p) > 0.5)
			{
				high = p;
			}
			else
			{
				low = p;
			}
		}
		return "The optimal vegetation probability is: " + p;
	}
	
}
