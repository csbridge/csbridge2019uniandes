package graphics;

import java.awt.Color;

/**
 * Programa: Fiesta de Kareles
 * ---------------------------
 * Pinta varios Kareles bailando sobre un espectro de colores
 */
public class EspectroConKareles extends EsGraphics {

	public static final int APPLICATION_WIDTH = 256;
	public static final int APPLICATION_HEIGHT = 256;
	
	/* La longitud de un lado de una casilla */
	private static final int TAMANO = 4;
	
	private static final int NUMERO_DE_COLORES = 256;
	
	private static final int TAMANO_KAREL = TAMANO * 8;
	
	private static final int AVANCE = APPLICATION_WIDTH / 8;

	public void run() {
		for (int x = 0; x < darAncho(); x += TAMANO) {
			for (int y = 0; y < darAlto(); y += TAMANO) {
				SRect punto = crearCasillaDeColor(x, y, 100);
				agregar(punto, x, y);
			}
		}
		for (int x = 0; x < darAncho(); x += AVANCE) {
			SImagen karel = new SImagen("res/karel.png");
			karel.cambiarTamano(TAMANO_KAREL, TAMANO_KAREL);
			double y = doubleAleatorio(0, darAlto() - TAMANO_KAREL);
			agregar(karel, x, y);
		}
	}

	private SRect crearCasillaDeColor(int rojo, int verde, int azul) {
		SRect casilla = new SRect(TAMANO, TAMANO);
		Color c = new Color(rojo % NUMERO_DE_COLORES,
							verde % NUMERO_DE_COLORES,
							azul % NUMERO_DE_COLORES);
		casilla.cambiarColor(c);
		casilla.cambiarRelleno(true);
		return casilla;
	}

}

