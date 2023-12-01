/**
 * Project05
 * @author Zachery Nyman
 * 24 May 2017
 */

package ZacheryNyman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Panel extends JPanel implements MouseListener
{
	private SpatialTree tree;
	private Printable root;
	private Point mouseStart, mouseStop;
	private int width, height, pinged;
	private double radius;
	
	public Panel(ArrayList<Point> points, int width, int height)
	{
		super();
		mouseStart = new Point(0,0);
		mouseStop = new Point(0,0);
		radius = 0;
		tree = new SpatialTree(points, new Rectangle(width, height));
		this.width = width;
		this.height = height;
		root = tree.getRoot();
		addMouseListener(this);
	}
	
	private ArrayList<Printable> snapshot(ArrayList<Printable> list, Printable n)
	{
		list.add(n);
		if(n.getLeftChild() != null){
			snapshot(list, n.getLeftChild());
		}
		if(n.getRightChild() != null){
			snapshot(list, n.getRightChild());
		}
		return list;
	}
	
	@Override
	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		ArrayList<Printable> list = new ArrayList<>();
		list = snapshot(list, root);
		Printable current;
		for (int i = 0; i < list.size(); i++)
		{
			current = list.get(i);
			if(current.getType())
			{
				g.setColor(Color.RED);
				g.drawLine((int)current.getLine().x1, (int)current.getLine().y1,(int) current.getLine().x2, (int)current.getLine().y2);
			}
			else
			{
				g.setColor(Color.BLUE);
				g.drawLine((int)current.getLine().x1,(int) current.getLine().y1,(int) current.getLine().x2,(int) current.getLine().y2);
			}
		}
		
		g.setColor(Color.WHITE);
		ArrayList<Printable> nearbyLocations = new ArrayList<>();
		pinged = 0;
		nearbyLocations = tree.query(mouseStart, radius, nearbyLocations, root);
		for(Printable p : nearbyLocations)
		{
			g.fillOval(p.getPoint().x - 5, p.getPoint().y -5 , 10, 10);
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//Do nothing
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//Do nothing
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//Do nothing
		
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
		radius = Math.sqrt(Math.pow((mouseStop.getX() - mouseStart.getX()), 2) + Math.pow((mouseStop.getY() - mouseStart.getY()), 2));
		repaint();
	}
}
