package graphics;
import java.awt.Color;

import acm.graphics.GLabel;

public class SLabel extends GLabel implements SObjeto{

	public SLabel(String str) {
		super(str);
	}
	
	public SLabel(String str, double x, double y) {
		super(str, x, y);
	}
	
	public double darAscension() {
		return getAscent();
	}
	public double darDescenso() {
		return getDescent();
	}
	
	/* change text label */
	public void cambiarTexto(String texto) {
		setLabel(texto);
	}
	
	/* fonts */
	public void cambiarFuente(String fuente) {
		setFont(fuente);
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
	public void moverse(int dx, int dy) {
		move(dx, dy);
	}

	public void cambiarUbicacion(double i, double j) {
		setLocation(i, j);
	}
	public void cambiarUbicacion(int i, int j) {
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
