import java.awt.Color;

import acm.graphics.GRect;

public class SRect extends GRect implements SObjeto{

	public SRect(double w, double h) {
		super(w, h);
	}
	
	public SRect(double x, double y, double w, double h) {
		super(x, y, w, h);
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

	public void cambiarUbicacion(double i, double j) {
		setLocation(i, j);
	}

	public void cambiarColor(Color c) {
		setColor(c);
	}
	
	public double darAncho() {
		return getWidth();
	}
	
	public double darAltura() {
		return getHeight();
	}

	public void cambiarVisible(boolean visible) {
		setVisible(visible);
	}
	public boolean esVisible() {
		return isVisible();
	}
	
}
