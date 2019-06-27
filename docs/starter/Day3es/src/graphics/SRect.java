package graphics;
import java.awt.Color;

import acm.graphics.GRect;

public class SRect extends GRect implements SObjeto{

	public SRect(double ancho, double alto) {
		super(ancho, alto);
	}
	
	public SRect(double x, double y, double ancho, double alto) {
		super(x, y, ancho, alto);
	}

	public double darX() {
		return getX();
	}

	public double darY() {
		return getY();
	}

	public void moverse(double dx, double dy) {
		move(dx, dy);
	}

	public void cambiarRelleno(boolean b) {
		setFilled(b);
	}

	public boolean estaRelleno() {
		return isFilled();
	}

	public void cambiarColorRelleno(Color c) {
		setFillColor(c);
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

	public void cambiarTamano(double ancho, double alto) {
		setSize(ancho, alto);
	}

	public void cambiarVisible(boolean visible) {
		setVisible(visible);
	}

	public boolean estaVisible() {
		return isVisible();
	}
	
}
