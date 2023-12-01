/**
 * Lab05
 * @author Zache
 * 12 April 2017
 * @param <E>
 */
import java.awt.Point;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdDraw;

public class TurtleDriver {

	public static void main(String[] args) {
		
		StdDraw.setCanvasSize(800, 800);
		StdDraw.setXscale(0, 800);
		StdDraw.setYscale(0, 800);
		
		StackTurtle st = new StackTurtle(new Point(400,400));
		
		String command;
		double value;
		Scanner keyboard = new Scanner(System.in);
		do{
			command = keyboard.next();
			if(command.equalsIgnoreCase("f"))
			{
				value = keyboard.nextDouble();
				st.moveForward(value);
			}
			else if(command.equalsIgnoreCase("r"))
			{
				value = keyboard.nextDouble();
				st.rotate(value);
			}
			else if(command.equals("["))
			{
				st.pushCurrentPosition();
			}
			else if(command.equals("]"))
			{
				st.popPosition();
			}
		} while(!command.equalsIgnoreCase("q"));
		System.exit(0);
	}

}
