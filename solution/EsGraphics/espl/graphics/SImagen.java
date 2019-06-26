package graphics;
import java.awt.Color;

import acm.graphics.GImage;

public class SImagen extends GImage implements SObjeto{

	public SImagen(String name) {
		super(name);
	}

	public SImagen(String name, double x, double y) {
		super(name, x, y);
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

	public void cambiarTamano(double ancho, double alto) {
		setSize(ancho, alto);
	}

	public double cambiarAncho(double ancho) {
		cambiarTamano(ancho, darAlto())
	}
	
	public double cambiarAlto(double alto) {
		cambiarAlto(darAncho(), alto);
	}
	
	public void cambiarVisible(boolean visible) {
		setVisible(visible);
	}
	public boolean esVisible() {
		return isVisible();
	}


}
