import acm.program.*;
import espl.*;
import acm.graphics.*;
import java.awt.event.*;

/**
 * Un programa que dibuja circulos negros rellenos 
 * en la pantalla cada vez que se presiona el mouse.
 */
public class Perforador extends EsGraphics {
	/* The radius of each hole that we punch. */
	private static final double HOYO_RADIO = 10;
	
	public void run() {
		agregarMouseListeners();
	}
	
	/**
	 * Dibuja un círculo negro centrado en la ubicacion 
	 * del mouse cada vez que se presiona el mouse.
	 */
	public void mousePresado(MouseEvento e) {
		double x = e.darX() - HOYO_RADIO;
		double y = e.darY() - HOYO_RADIO;
		
		SOvalo hole = new SOvalo(2 * HOYO_RADIO, 2 * HOYO_RADIO);
		hole.cambiarRelleno(true);
		add(hole, x, y);
	}
}
