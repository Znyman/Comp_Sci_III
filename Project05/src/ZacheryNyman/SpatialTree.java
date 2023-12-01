/**
 * Project05
 * @author Zachery Nyman
 * 24 May 2017
 */

package ZacheryNyman;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class SpatialTree
{
	private TreeNode root;
	public int pinged;
	
	public SpatialTree(ArrayList<Point> p, Rectangle r)
	{
		if(p.size() > 0)
		{
			root = new TreeNode( p, true, r);
		}
		else
		{
			root = null;
		}
	}
	
	public Printable getRoot()
	{
		return root;
	}
	
	private StringBuilder recursiveToString(TreeNode r, int depth, StringBuilder total)
	{
		if(r == null)
		{
			return total;
		}
		for(int i = 0; i < depth; i++)
		{
			total.append("  ");
		}
		total.append("(" + depth + ") Rectangle (" + r.rectangle.x + ", " + r.rectangle.y + ", " + r.rectangle.width + ", "
				+ r.rectangle.height + ") Point (" + r.value.x + ", " + r.value.y + ")\n");
		recursiveToString(r.leftChild, depth + 1, total);
		recursiveToString(r.rightChild, depth + 1, total);
		return total;
	}
	
	public String toString()
	{
		StringBuilder total = new StringBuilder();
		recursiveToString(root, 0, total);
		return total.toString();
	}
	
	public ArrayList<Printable> pointSnapshot(Point mouseStart, double radius, ArrayList<Printable> list, Printable n)
	{
			pinged++;
			if(Math.sqrt((n.getPoint().getX() - mouseStart.getX()) * (n.getPoint().getX() - mouseStart.getX())
					+ (n.getPoint().getY() - mouseStart.getY()) * (n.getPoint().getY() - mouseStart.getY())) < radius)
			{
				list.add(n);
			}
			
			Line2D.Double line = n.getLine();
			if(line.ptSegDist(mouseStart.getX(), mouseStart.getY()) < radius)
			{
				if(n.getLeftChild() != null)
				{
					pointSnapshot(mouseStart, radius, list, n.getLeftChild());
				}
				if(n.getRightChild() != null)
				{
					pointSnapshot(mouseStart, radius,list, n.getRightChild());
				}
			}
			else
			{
				if(n.getType())
				{
					if(n.getPoint().getX() > mouseStart.getX())
					{
						if(n.getLeftChild() != null)
						{
							pointSnapshot(mouseStart, radius,list, n.getLeftChild());
						}
					}
					else
					{
						if(n.getRightChild() != null)
						{
							pointSnapshot(mouseStart, radius,list, n.getRightChild());
						}
					}
				}
				else
				{
					if(n.getPoint().getY() > mouseStart.getY())
					{
						if(n.getLeftChild() != null)
						{
							pointSnapshot(mouseStart, radius,list, n.getLeftChild());
						}
					}
					else
					{
						if(n.getRightChild() != null)
						{
							pointSnapshot(mouseStart, radius,list, n.getRightChild());
						}
					}
				}
			}
			return list;
	}
	
	public ArrayList<Printable> query(Point mouseStart, double radius, ArrayList<Printable> list, Printable n)
	{
		pinged = 0;
		return pointSnapshot(mouseStart, radius, list, n);
	}
	
	public class TreeNode implements Printable
	{
		private Point value;
		private boolean isX;
		private Rectangle rectangle;
		private Line2D.Double line;
		private TreeNode leftChild;
		private TreeNode rightChild;
		
		
		public TreeNode(ArrayList<Point> p, boolean b, Rectangle r)
		{
			if(p.size() == 0)
			{
				return;
			}
			value = p.get(0);
			rectangle = r;
			isX = b;
			line = constructLine();
			p.remove(0);
			
			ArrayList<Point> biggerList = new ArrayList<>();
			ArrayList<Point> smallerList = new ArrayList<>();
			
			if(!isX)
			{
				for(Point point : p)
				{
					if(point.getY() > value.getY())
					{
						biggerList.add(point);
					}
					else
					{
						smallerList.add(point);
					}
				}
			}
			else
			{
				for(Point point : p)
				{
					if(point.getX() > value.getX())
					{
						biggerList.add(point);
					}
					else
					{
						smallerList.add(point);
					}
				}
			}
			
			if(smallerList.size() > 0)
			{
				if(isX)
				{
					leftChild = new TreeNode(smallerList, !isX, new Rectangle
							(rectangle.x, rectangle.y, (value.x - rectangle.x), rectangle.height));
				}
				else
				{
					leftChild = new TreeNode(smallerList, !isX, new Rectangle
							(rectangle.x, rectangle.y, rectangle.width, (value.y - rectangle.y)));
				}
			}
			else
			{
				leftChild = null;
			}
			
			if(biggerList.size() > 0)
			{
				if(isX)
				{
					rightChild = new TreeNode(biggerList, !isX, new Rectangle
							(value.x, rectangle.y, (rectangle.width - value.x + rectangle.x), rectangle.height));
				}
				else
				{
					rightChild = new TreeNode(biggerList, !isX, new Rectangle
							(rectangle.x, value.y, rectangle.width, (rectangle.height - value.y + rectangle.y)));
				}
			}
			else
			{
				rightChild = null;
			}
		}
		
		private Line2D.Double constructLine()
		{
			int x1;
			int x2;
			int y1;
			int y2;
			
			if(!getType())
			{
				y1 = y2 = getPoint().y;
				x1 = getRectangle().x;
				x2 = getRectangle().x + getRectangle().width;
				return new Line2D.Double(x1, y1, x2, y2);
			}
			else
			{
				x1 = x2 = getPoint().x;
				y1 = getRectangle().y;
				y2 = getRectangle().y + getRectangle().height;
				return new Line2D.Double(x1, y1, x2, y2);
			}
		}
		
		public String toString()
		{
			return value.toString() + rectangle.toString();
		}
		
		@Override
		public Point getPoint()
		{
			return value;
		}
		
		@Override
		public Rectangle getRectangle()
		{
			return rectangle;
		}
		
		@Override
		public boolean getType()
		{
			return isX;
		}
		
		@Override
		public Printable getLeftChild()
		{
			return leftChild;
		}
		
		@Override
		public Printable getRightChild()
		{
			return rightChild;
		}
		
		@Override
		public Line2D.Double getLine()
		{
			
			return line;
		}
	}
	


}
