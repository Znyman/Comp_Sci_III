/**
 * Project04
 * @author ZacheryNyman
 * 10 May 2017
 */

package ZacheryNyman;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Window extends JFrame
{
	public Window()
	{
		super("Rectangle Tree Builder");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 1000);
		this.setLayout(new BorderLayout());
		Panel panel = new Panel();
		add(panel, BorderLayout.CENTER);
		setVisible(true);
	}

}
