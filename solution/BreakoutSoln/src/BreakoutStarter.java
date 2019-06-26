/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import graphics.EsGraphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import graphics.*;

public class BreakoutStarter extends EsGraphics {

	public void run() {
		// tu codigo aca
	}
	
	/**********************************************
	 *        Constantes que puedes usar          *
	 **********************************************/

	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

	/** Constantes para la paleta */
	private static final int PALETA_ANCHO = 60;
	private static final int PALETA_ALTURA = 10;
	private static final int PALETA_Y_OFFSET = 30;

	/** Constantes para las filas */
	private static final int NLADRILLOS_POR_FILA = 10;
	private static final int NFILAS = 10;

	/** Constantes para las ladrillos */
	private static final int LADRILLO_SEP = 4;
	private static final int LADRILLO_ANCHO =
			(APPLICATION_WIDTH - (NLADRILLOS_POR_FILA - 1) * LADRILLO_SEP) / NLADRILLOS_POR_FILA;
	private static final int LADRILLO_ALTURA = 8;
	private static final int LADRILLO_Y_OFFSET = 70;
	
	/** Constantes para la pelota */
	private static final int PELOTA_RADIO = 10;

	/** Numero de turnos */
	private static final int NTURNOS = 3;
	
	/** Retraso de la animación o tiempo de pausa entre movimientos de la pelota. */	
	private static final int RETRASO = 10;
	
	
}