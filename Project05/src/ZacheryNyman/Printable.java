/**
 * Project05
 * @author Zachery Nyman
 * 24 May 2017
 */

package ZacheryNyman;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

public interface Printable
{
	Point getPoint();
	Rectangle getRectangle();
	boolean getType();
	Printable getLeftChild();
	Printable getRightChild();
	Line2D.Double getLine();
}
