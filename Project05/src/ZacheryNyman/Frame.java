/**
 * Project05
 * @author Zachery Nyman
 * 24 May 2017
 */

package ZacheryNyman;

import java.awt.BorderLayout;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Frame extends JFrame
{
	public Frame(ArrayList<Point> points, int width, int height, String name)
	{
		super(name);
		setSize(width,height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		Panel canvas = new Panel(points, width, height);
		add(canvas, BorderLayout.CENTER);
		setVisible(true);
	}

}
