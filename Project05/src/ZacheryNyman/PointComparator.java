/**
 * Project05
 * @author Zachery Nyman
 * 24 May 2017
 */

package ZacheryNyman;

import java.awt.Point;
import java.util.Comparator;

public class PointComparator implements Comparator<Point>
{
	@Override
	public int compare(Point arg0, Point arg1)
	{
		return arg0.x - arg1.x;
	}

}
