package graphics;
import java.awt.Color;

import acm.graphics.GImage;

public class SImagen extends GImage implements SObjeto{

	public SImagen(String nombreDeArchivo) {
		super(nombreDeArchivo);
	}

	public SImagen(String nombreDeArchivo, double x, double y) {
		super(nombreDeArchivo, x, y);
	}

	public SImagen(int[][] arregloDePixeles) {
		super(arregloDePixeles);
	}

	public SImagen(int[][] arregloDePixeles, double x, double y) {
		super(arregloDePixeles);
	}

	public void guardarImagen(String nombreDeArchivo) {
		saveImage(nombreDeArchivo);
	}

	public int[][] darArregloDePixeles() {
		return getPixelArray();
	}

	/* Utilidades de pixeles. */
	public int crearRGBPixel(int rojo, int verde, int azul) {
		return createRGBPixel(rojo, verde, azul)
	}
	public int crearRGBPixel(int rojo, int verde, int azul, int alpha) {
		return createRGBPixel(rojo, verde, azul, alpha)
	}
	public int darAlpha(int pixel) { return getAlpha(pixel); }
	public int darRojo(int pixel) { return getRed(pixel); }
	public int darVerde(int pixel) { return getGreen(pixel); }
	public int darAzul(int pixel) { return getBlue(pixel); }
	

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
