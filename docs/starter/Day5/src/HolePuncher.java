import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;

/**
 * A program that draws filled black circles on the screen whenever the mouse
 * is pressed.
 */
public class HolePuncher extends GraphicsProgram {
	/* The radius of each hole that we punch. */
	private static final double HOLE_RADIUS = 10;
	
	public void run() {
		addMouseListeners();
	}
	
	/**
	 * Draws a black circle centered at the mouse location whenever the mouse 
	 * is pressed.
	 */
	public void mousePressed(MouseEvent e) {
		double x = e.getX() - HOLE_RADIUS;
		double y = e.getY() - HOLE_RADIUS;
		
		GOval hole = new GOval(x, y, 2 * HOLE_RADIUS, 2 * HOLE_RADIUS);
		hole.setFilled(true);
		add(hole);
	}
}
