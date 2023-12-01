import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel implements MouseListener{
	
	private ArrayList<Rectangle> rectangles;
	private Point mouseStart;
	private Point mouseStop;

	public Canvas(){
		super();
		rectangles = new ArrayList<Rectangle>();
		addMouseListener(this);
		
	}
	
	public void clear(){
		rectangles.clear();
		repaint();
	}
	
	@Override
	public void paint(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(0, 0, getWidth(), getHeight());
		for(Rectangle r: rectangles){
			g.setColor(new Color(
					(float)Math.random(),
					(float)Math.random(),
					(float)Math.random()));
			g.fillRect(r.x, r.y, r.width, r.height);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseStart = e.getPoint();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseStop = e.getPoint();
		rectangles.add(new Rectangle(Math.min(mouseStart.x,mouseStop.x), Math.min(mouseStart.y, mouseStop.y), 
				Math.abs(mouseStop.x - mouseStart.x),Math.abs(mouseStop.y - mouseStart.y)));
		repaint();
		System.out.println("mouse up event processed, " + rectangles.size());
		
		
	}
}
