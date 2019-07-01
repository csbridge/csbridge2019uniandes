package graphics;

import java.awt.Color;

public class Sorpresa extends EsGraphics {

	public static final int APPLICATION_WIDTH = 256;
	public static final int APPLICATION_HEIGHT = 256;

	/* La longitud de un lado de una casilla */
	private static final int TAMANO = 4;

	public void run() {
		// Hacer una cuadricula de casillas
		for (int y = 0; y < darAlto(); y += TAMANO) {
			for (int x = 0; x < darAncho(); x += TAMANO) {
				SRect casilla = darCasillaDeColor(x, y, 100);
				agregar(casilla, x, y);
			}
		}
		
		for (int x = 0; x < darAncho(); x += darAncho() / 8) {
			SImagen karel = new SImagen("res/karel.png");
			karel.cambiarTamano(TAMANO * 8, TAMANO * 8);
			agregar(karel, x, doubleAleatorio(0, darAlto() - TAMANO * 8));
		}
	}

	private SRect darCasillaDeColor(int rojo, int verde, int azul) {
		SRect rect = new SRect(TAMANO, TAMANO);
		rect.cambiarRelleno(true);
		Color c = new Color(rojo % 256, verde % 256, azul % 256); // cada valor entre 0 y 255
		rect.cambiarColor(c);
		return rect;
	}

}