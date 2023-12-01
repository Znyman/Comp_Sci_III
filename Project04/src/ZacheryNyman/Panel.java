/**
 * Project04
 * @author ZacheryNyman
 * 10 May 2017
 */

package ZacheryNyman;

import ZacheryNyman.RectangleTree.TreeNode;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Panel extends JPanel implements MouseListener
{
	private RectangleTree tree;
	private TreeNode root;
	private Point mouseStart, mouseStop;
	

	public Panel()
	{
		super();
		tree = new RectangleTree();
		root = tree.root;
		addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		mouseStart = e.getPoint();
	}
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		mouseStop = e.getPoint();
		
		if(SwingUtilities.isLeftMouseButton(e))
		{
			Rectangle rectangle = new Rectangle(Math.min(mouseStart.x,mouseStop.x), Math.min(mouseStart.y, mouseStop.y), 
					Math.abs(mouseStop.x - mouseStart.x),Math.abs(mouseStop.y - mouseStart.y));
			 tree.addChild(rectangle);
		}
		else if(SwingUtilities.isRightMouseButton(e))
		{
			tree.remove(mouseStop);
		}
		repaint();
	}
	
	private ArrayList<TreeNode> snapshot(ArrayList<TreeNode> list, TreeNode n)
	{
		list.add(n);
		
		for(int i = 0; i < n.children.size(); i++)
		{
			snapshot(list, n.children.get(i));
		}
		return list;
	}
	
	@Override
	public void paint(Graphics g)
	{
		ArrayList<TreeNode> treeNodeList = new ArrayList<>();
		treeNodeList = snapshot(treeNodeList, root);
		for (int i = 0; i < treeNodeList.size(); i++)
		{
			if(treeNodeList.get(i).parent == null)
			{
				g.setColor(Color.BLACK);
			}
			else
			{
				g.setColor(treeNodeList.get(i).parent.color);
			}
			g.fillRect(treeNodeList.get(i).rectangle.x, treeNodeList.get(i).rectangle.y, treeNodeList.get(i).rectangle.width, treeNodeList.get(i).rectangle.height);
		}
	}
}
