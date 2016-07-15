package dev.teknikation.tilegame.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width;
	private int height;
	
	public Display (String title, int width, int height) {
		this.title = title;
		this.height = height;
		this.width = width;
		createDisplay();
	}
	
	
	private void createDisplay () {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Make sure windows closes down properly
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); //Makes windows center of screen
		frame.setVisible(true); // JFrames by default arent visible
		
		canvas = new Canvas ();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack(); // Makes sure canvas stays in frame
	}


	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
}
