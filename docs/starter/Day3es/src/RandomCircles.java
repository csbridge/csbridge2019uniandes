import graphics.EsGraphics;
import graphics.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.*;


/**
 * Random Circles
 * --------------
 * Draws 10 random circles such that each circle is on the screen.
 */
public class RandomCircles extends EsGraphics {
	 
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private static final int numberOfCircles = 10;
    private static final int minRadius = 5;
    private static final int maxRadius = 50;
 
    public void run() {
        for(int i=0; i < numberOfCircles; i++ ) {
            drawCircle();
        }
    }
 
    private void drawCircle() {
        double radius = rgen.nextDouble(minRadius, maxRadius);
        double x = rgen.nextDouble(0, getWidth() - radius*2);
        double y = rgen.nextDouble(0, getHeight() - radius*2);
        GOval circle = new GOval(x, y, radius, radius);
        circle.setFilled(true);
        circle.setColor(rgen.nextColor());
        add(circle);
    }
 
}