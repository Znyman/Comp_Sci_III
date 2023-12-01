/**
 * Project05
 * @author Zachery Nyman
 * 24 May 2017
 */

package ZacheryNyman;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Driver
{
	public static void main(String args[])
	{
		ArrayList<Point> points = new ArrayList<>();
		ArrayList<Point> orderedPoints = new ArrayList<>();

		Random r = new Random();
		for(int i = 0; i < 1250; i++)
		{
			orderedPoints.add(new Point(i, i));
			points.add(new Point(r.nextInt(1250), r.nextInt(1250)));
		}
		//System.err.println(orderedPoints);
		//System.err.println(points);
		//Frame orderedInput = new Frame(orderedPoints, 1250, 1250, "Ordered Values");
		Frame randomInput = new Frame(points, 1250, 1250, "Random Values");
		points.sort(new PointComparator());
		//Frame sortedInput = new Frame(points, 1250, 1250, "Sorted Values");
		
		
	}
	
}
