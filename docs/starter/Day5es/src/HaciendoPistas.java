import acm.program.*;
import espl.*;

import java.awt.event.*;
import acm.graphics.*;

public class HaciendoPistas extends EsGraphics {
	
	public void run() {
		// tu codigo aca
		
		// un ejemplo
		dibujarHuellaOso(50, 100);
	}
	
	
	/*** codigo de dibujo de huella debajo de este punto ***/
	/*** puedes leerlo, pero por favor no cambiar este codigo ***/
	
	/* Draws a bear track centered at (x, y). */
	private void dibujarHuellaOso(double x, double y) {
		dibujarDedo(x + FIRST_TOE_X, y + FIRST_TOE_Y);
		dibujarDedo(x + SECOND_TOE_X, y + SECOND_TOE_Y);
		dibujarDedo(x + THIRD_TOE_X, y + THIRD_TOE_Y);
		dibujarDedo(x + FOURTH_TOE_X, y + FOURTH_TOE_Y);
		dibujarTalon(x + HEEL_X, y + HEEL_Y);
	}
	
	/* Draws an ellipse with the specified upper-left corner,
	 * width, and height
	 */
	private void drawEllipse(double x, double y, double width, double height) {
		SOvalo oval = new SOvalo(x, y, width, height);
		oval.setFilled(true);
		agregar(oval);
	}
	
	/* Draws a bear track toe with upper-left corner
	 * (x, y).
	 */
	private void dibujarDedo(double x, double y) {
		drawEllipse(x, y, TOE_WIDTH, TOE_HEIGHT);
	}
	
	/* Draws a bear track heel with upper-left corner
	 * (x, y).
	 */
	private void dibujarTalon(double x, double y) {
		drawEllipse(x, y, HEEL_WIDTH, HEEL_HEIGHT);
	}
	
	/* Constants controlling the placement of the bear track
	 * toes.
	 */
	private static final double FIRST_TOE_X = -35;
	private static final double FIRST_TOE_Y = -20;
	private static final double SECOND_TOE_X = -15;
	private static final double SECOND_TOE_Y = -30;
	private static final double THIRD_TOE_X = 5;
	private static final double THIRD_TOE_Y = -30;
	private static final double FOURTH_TOE_X = 25;
	private static final double FOURTH_TOE_Y = -20;
	
	/* Constants controlling the placement of the bear track
	 * heel.
	 */
	private static final double HEEL_X = -30;
	private static final double HEEL_Y = 0;
	
	/* Constants controlling the width and height of the toes
	 * and heel.
	 */
	private static final double TOE_WIDTH = 10;
	private static final double TOE_HEIGHT = 22.5;
	private static final double HEEL_WIDTH = 60;
	private static final double HEEL_HEIGHT = 30;
}