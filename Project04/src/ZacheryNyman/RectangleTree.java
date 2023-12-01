/**
 * Project04
 * @author ZacheryNyman
 * 10 May 2017
 */

package ZacheryNyman;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class RectangleTree
{

	protected TreeNode root;
	
	public RectangleTree()
	{
		root = new TreeNode(new Rectangle(1000, 1000), null);
	}
	
	public TreeNode getFullyContainingRectangle(Rectangle r, TreeNode n)
	{
		TreeNode bottomLeft = getContainer(new Point(r.x, r.y), n); //returns the node the point is contained within
		TreeNode bottomRight = getContainer(new Point(r.x + r.width, r.y), n);
		TreeNode topLeft = getContainer(new Point(r.x, r.y + r.height), n);
		TreeNode topRight = getContainer(new Point(r.x + r.width, r.y + r.height), n);
		TreeNode center = getContainer(new Point((int)r.getCenterX(), (int)r.getCenterY()), n);
		
		if(bottomLeft == bottomRight && bottomLeft == topLeft && bottomLeft == topRight && bottomLeft == center)
		{
			return bottomLeft; //if the node all of the points are in is the same, then the rectangle is drawn
		}
		else
		{
			return null;
		}
	}
	
	public TreeNode getContainer(Point p, TreeNode n)
	{
		boolean childContainsPoint = false;
		TreeNode nextChild = null;
		for(int i = 0; i < n.children.size(); i++)
		{
			if(n.children.get(i).rectangle.contains(p))
			{
				childContainsPoint = true;
				nextChild = n.children.get(i);
			}
		}
		
		if(childContainsPoint)
		{
			return getContainer(p, nextChild);
		}
		else
		{
			return n;
		}
	}
	
	public void remove(Point p)
	{
		TreeNode removedNode = getContainer(p, root);
		if(removedNode.parent == null)
		{
			return;
		}
		removedNode.parent.children.remove(removedNode);
	}
	
	public void addChild(Rectangle r)
	{
		TreeNode newParent = getFullyContainingRectangle(r, root);
		
		if(newParent == null)
		{
			return;
		}
		else
		{
			newParent.children.add(new TreeNode(r, newParent));
		}
		
	}
	
	class TreeNode
	{
		protected Rectangle rectangle;
		protected Color color;
		protected ArrayList<TreeNode> children;
		protected TreeNode parent;
		
		public TreeNode(Rectangle thisRectangle, TreeNode p)
		{
			Random randomInt = new Random();
			parent = p;
			rectangle = thisRectangle;
			children = new ArrayList<>();
			color = (new Color(randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)));
		}
	}
}