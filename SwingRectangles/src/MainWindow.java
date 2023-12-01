import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainWindow extends JFrame
{
	
	public MainWindow()
	{
		super("Drawing Windows");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,800);
		
		
		this.setLayout(new BorderLayout());
		Canvas canvas = new Canvas();
		
		add(canvas, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new MainWindow();
	}

}
