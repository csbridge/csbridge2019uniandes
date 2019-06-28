import acm.program.*;
import acm.graphics.*;

import java.awt.Color;
import java.awt.event.*;

public class StampTool extends GraphicsProgram {

	private static final int SIZE = 50;
	
	private GRect stamp = new GRect(SIZE, SIZE);
	
	public void run() {
		stamp.setColor(Color.BLUE);
		stamp.setFilled(true);
		add(stamp);
		addMouseListeners();
	}
	
	public void mouseClicked(MouseEvent e) {
		int x = e.getX() - SIZE / 2;
		int y = e.getY() - SIZE / 2;
		
		GRect r = new GRect(SIZE, SIZE);
		r.setFilled(true);
		add(r, x, y);
	}
	
	public void mouseMoved(MouseEvent e) {
		int x = e.getX() - SIZE / 2;
		int y = e.getY() - SIZE / 2;
		stamp.setLocation(x, y);
	}
}
