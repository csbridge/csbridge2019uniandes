import graphics.EsGraphics;

import java.awt.Color;

import graphics.*;


/**
 *&nbsp;Dibujar cara
 * ------------
 *&nbsp;Dibuja una impresionante cara de robot, con
 * etiquetas y ojos de diferentes colores. @ # $% #
 * @!
 */
public class DibujarCara extends EsGraphics {

	private static final int ANCHO_DE_CARA = 300;
	private static final int ALTURA_DE_CARA = 350;
	private static final int DIÁMETRO_DE_OJOS = 70;
	private static final int COMPENSACION_OJO_Y = 40;
	private static final int ANCHO_DE_BOCA = 150;
	private static final int ALTURA_DE_BOCA = 30;
	private static final int COMPENSACION_BOCA_Y = 200;
	private static final int ETIQUETA_Y = 50;

	public void run() {
		dibujarLaCabeza();
		dibujarOjoIzquierdo();
		dibujarOjoDerecho();
		dibujarBoca();
		dibujarEtiqueta();
	}

	private void dibujarLaCabeza() {
		double x = (darAncho() - ANCHO_DE_CARA) / 2;
		double y = (darAlto() - ALTURA_DE_CARA) / 2;
		SRect cabeza = new SRect(x, y, ANCHO_DE_CARA, ALTURA_DE_CARA);
		cabeza.cambiarRelleno(true);
		cabeza.cambiarColor(Color.ORANGE);
		agregar(cabeza);
	}

	private void dibujarOjoIzquierdo() {
		double espaciamientoDeLosOjos = (ANCHO_DE_CARA - 2 * DIÁMETRO_DE_OJOS) / 3;
		double cabezaX = (darAncho() - ANCHO_DE_CARA) / 2;
		double cabezaY = (darAlto() - ALTURA_DE_CARA) / 2;
		double x =  cabezaX + espaciamientoDeLosOjos;
		double y = cabezaY + COMPENSACION_OJO_Y;
		SOvalo ojo = new SOvalo(x, y, DIÁMETRO_DE_OJOS, DIÁMETRO_DE_OJOS);
		ojo.cambiarRelleno(true);
		ojo.cambiarColor(Color.BLUE);
		agregar(ojo);
	}

	private void dibujarOjoDerecho() {
		double espaciamientoDeLosOjos = (ANCHO_DE_CARA - 2 * DIÁMETRO_DE_OJOS) / 3;
		double cabezaX = (darAncho() - ANCHO_DE_CARA) / 2;
		double cabezaY = (darAlto() - ALTURA_DE_CARA) / 2;
		double x =  cabezaX + espaciamientoDeLosOjos * 2 + DIÁMETRO_DE_OJOS;
		double y = cabezaY + COMPENSACION_OJO_Y;
		SOvalo ojo = new SOvalo(x, y, DIÁMETRO_DE_OJOS, DIÁMETRO_DE_OJOS);
		ojo.cambiarRelleno(true);
		ojo.cambiarColor(Color.GREEN);
		agregar(ojo);
	}

	private void dibujarBoca() {
		double cabezaX = (darAncho() - ANCHO_DE_CARA) / 2;
		double cabezaY = (darAlto() - ALTURA_DE_CARA) / 2;
		double x = cabezaX + (ANCHO_DE_CARA - ANCHO_DE_BOCA) / 2;
		double y = cabezaY + COMPENSACION_BOCA_Y;
		SRect boca = new SRect(x, y, ANCHO_DE_BOCA, ALTURA_DE_BOCA);
		boca.cambiarRelleno(true);
		agregar(boca);
	}

	private void dibujarEtiqueta() {
		SEtiqueta etiqueta = new SEtiqueta("Cara de robot");
		etiqueta.cambiarFuente("Courier-50");
		double x = (darAncho() - etiqueta.darAncho()) / 2;
		agregar(etiqueta, x, ETIQUETA_Y);
	}
}
