/**
 * Lab05
 * @author Zache
 * 12 April 2017
 * @param <E>
 */
import java.awt.Point;
import edu.princeton.cs.introcs.StdDraw;

public class StackTurtle<E> {
	
	private LinkedListStack<E> stack = new LinkedListStack<>();
	private Point currentPosition;
	private double angle;
	
	public StackTurtle(Point startingPosition){
		currentPosition = startingPosition;
		angle = 90;
	}
	
	public void moveForward(double distance){
		Point newPosition = new Point(
				(int)(currentPosition.x + distance*Math.cos(Math.toRadians(angle))),
				(int)(currentPosition.y + distance*Math.sin(Math.toRadians(angle))));
		
		StdDraw.line(currentPosition.x, currentPosition.y, newPosition.x, newPosition.y);
		
		currentPosition = newPosition;
		//System.err.println("Move forward: " + distance);
	}
	
	public void rotate(double degrees){
		angle += degrees;
		//System.err.println("Rotate: " + degrees);
	}
	
	public void pushCurrentPosition()
	{
		stack.push((E)currentPosition);
	}
	
	public void popPosition()
	{
		currentPosition = (Point)stack.pop();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
