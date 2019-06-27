package graphics;
import java.awt.Color;

import acm.graphics.GLine;

public class SLinea extends GLine implements SObjeto{

	public SLinea(double x0, double y0, double x1, double y1) {
		super(x0, y0, x1, y1);
	}

	/* Getters and setters for start and end points. */
	public void cambiarPuntoPrincipio(double x, double y) {
		setStartPoint(x, y);
	}
	public void cambiarPuntoFinal(double x, double y) {
		setEndPoint(x, y);
	}
	public double darPuntoPrincipioX() {
		return getStartPoint().getX();
	}
	public double darPuntoPrincipioY() {
		return getStartPoint().getY();
	}
	public double darPuntoFinalX() {
		return getEndPoint().getX();
	}
	public double darPuntoFinalY() {
		return getEndPoint().getY();
	}

	public double darX() {
		return darPuntoPrincipioX();
	}
	public double darY() {
		return darPuntoPrincipioY();
	}

	public void moverse(double dx, double dy) {
		move(dx, dy);
	}

	public void cambiarUbicacion(double i, double j) {
		setLocation(i, j);
	}

	public void cambiarColor(Color c) {
		setColor(c);
	}
	
	public double darAncho() {
		return getWidth();
	}
	
	public double darAlto() {
		return getHeight();
	}
	
	public void cambiarVisible(boolean visible) {
		setVisible(visible);
	}
	public boolean estaVisible() {
		return isVisible();
	}


}
