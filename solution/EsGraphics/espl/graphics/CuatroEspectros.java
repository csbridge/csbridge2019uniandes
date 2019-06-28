package graphics;

import java.awt.Color;

/**
 * Programa: Cuatro Espectros
 * --------------------------
 * Pinta cuatro espectros de diferentes colores, utilizando un solo método
 */
public class CuatroEspectros extends EsGraphics {
	
	public static final int APPLICATION_WIDTH = 512;
	public static final int APPLICATION_HEIGHT = 512;
	
	private static final int NUMERO_DE_COLORES = 256;
	
	/* La longitud de un lado de una casilla */
	private static final int TAMANO = 4;

	public void run() {
		dibujarEspectro(0, 0, 0);
		dibujarEspectro(darAncho() / 2, 0, 85);
		dibujarEspectro(0, darAlto() / 2, 170);
		dibujarEspectro(darAncho() / 2, darAlto() / 2, 255);
	}
	
	private void dibujarEspectro(double xInicial, double yInicial, int azul) {
		for (int y = 0; y < darAlto() / 2; y += TAMANO) {
			for (int x = 0; x < darAncho() / 2; x += TAMANO) {
				SRect casilla = crearCasillaDeColor(x, y, azul);
				agregar(casilla, x + xInicial, y + yInicial);
			}
		}
	}

	private SRect crearCasillaDeColor(int rojo, int verde, int azul) {
		SRect casilla = new SRect(TAMANO, TAMANO);
		casilla.cambiarRelleno(true);
		Color c = new Color(rojo % NUMERO_DE_COLORES,
							verde % NUMERO_DE_COLORES,
							azul % NUMERO_DE_COLORES);
		casilla.cambiarColor(c);
		return casilla;
	}
	
}