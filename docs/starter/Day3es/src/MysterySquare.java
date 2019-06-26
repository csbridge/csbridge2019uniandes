import graphics.EsGraphics;
import graphics.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;
import graphics.EsGraphics;
import graphics.*;
import java.awt.*;


/**
 * Draws a Mystery Square that changes color
 * -----------------------------------------
 * Really does what it says.
 */
public class MysterySquare extends EsGraphics {

    private static final int SIZE = 400;
    private static final int DELAY = 1000;

	
	public void run() {
		// Draw a square in the center of the screen.
		SRect rect = new SRect(SIZE, SIZE);
		double x = (darAncho() - rect.darAncho()) / 2;
		double y = (darAltura() - rect.darAltura()) / 2;
		rect.setFilled(true);
		add(rect, x, y);
		
		// Change its color every second.
		while(true) {
			Color color = colorAleatorio();
			rect.setColor(color); 
			pause(DELAY);
		}
	}
}