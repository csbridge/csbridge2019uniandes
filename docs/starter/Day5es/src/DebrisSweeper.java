import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;

public class DebrisSweeper extends GraphicsProgram {
	/* Minimum and maxmimum size of a piece of debris. */
	private static final double MIN_DEBRIS_SIZE = 50;
	private static final double MAX_DEBRIS_SIZE = 150;
	
	/* Number of pieces of debris. */
	private static final double NUM_DEBRIS_PIECES = 100;
	
	public void run() {
		createDebris();
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		GObject hitObject = getElementAt(e.getX(), e.getY());
		if (hitObject != null) {
			remove(hitObject);
		}
	}
	
	/* * * * * Code for adding debris to the screen. * * * * */
	
	/* Creates debris and strews it randomly on the canvas. */
	private void createDebris() {
		for (int i = 0; i < NUM_DEBRIS_PIECES; i++) {
			createSingleDebrisPiece();
		}
	}
	
	/* Creates a single piece of debris and adds it to the
	 * canvas.
	 */
	private void createSingleDebrisPiece() {
		RandomGenerator rgen = RandomGenerator.getInstance();
		
		/* Compute the width and height first so that we know where we can
		 * safely put the object on screen.
		 */
		double width  = rgen.nextDouble(MIN_DEBRIS_SIZE, MAX_DEBRIS_SIZE);
		double height = rgen.nextDouble(MIN_DEBRIS_SIZE, MAX_DEBRIS_SIZE);
		double x = rgen.nextDouble(0, getWidth() - width);
		double y = rgen.nextDouble(0, getHeight() - height);
		
		/* Add an oval of that size and position to the screen. */
		GOval oval = new GOval(x, y, width, height);
		oval.setFilled(true);
		oval.setColor(rgen.nextColor());
		add(oval);
	}
}
