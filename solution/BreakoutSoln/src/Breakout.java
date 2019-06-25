/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends EsGraphics {
	
	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

	/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

	/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

	/** Separation between bricks */
	private static final int BRICK_SEP = 4;

	/** Width of a brick */
	private static final int BRICK_WIDTH =
			(APPLICATION_WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

	/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

	/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

	/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

	/** Number of turns */
	private static final int NTURNS = 3;
	
	/** Animation delay or paust time between ball moves */	
	private static final int DELAY = 10;
	
	
	
	
	

	/**Ball velocity*/	
	private double vx, vy;
	private int contadorLadrillos = 100;

	//adding an individual ball object
	private SOvalo pelota;

	//adding individual paddle object
	private SRect pala;

	public void run() {
		for(int i=0; i < NTURNS; i++) {
			iniciarJuego();
			hacerJuego();
			if(contadorLadrillos == 0) {
				break;
			}
		}
		mostrarFin();
	}

	private void mostrarFin() {
		quitarTodo();
		pelota.cambiarVisible(false);
		if(contadorLadrillos > 0) {
			imprimirPerdida();
		} else {
			imprimirGana();
		}
	}

	private void iniciarJuego() {
		dibujarLadrillos();
		dibujarPala();
		dibujarPelota();
	}

	private void dibujarLadrillos() {	
		double cx = darAncho() / 2;
		double cy = BRICK_Y_OFFSET;
		for(int fila = 0; fila < NBRICK_ROWS; fila++ ) {
			for(int columna = 0; columna < NBRICKS_PER_ROW; columna++) {
				double x = cx - (NBRICKS_PER_ROW*BRICK_WIDTH)/2 - ((NBRICKS_PER_ROW-1)*BRICK_SEP)/2 + columna*BRICK_WIDTH + columna*BRICK_SEP;
				double y = cy + fila * BRICK_HEIGHT + fila*BRICK_SEP;
				SRect ladrillo = new SRect( x , y , BRICK_WIDTH , BRICK_HEIGHT );
				ladrillo.cambiarRelleno(true);
				ladrillo.cambiarColor(darLadrilloColor(fila));
				agregar(ladrillo);
			}
		}
	}

	private Color darLadrilloColor(int fila) {
		if (fila < 2) {
			return Color.RED;
		}
		if (fila == 2 || fila == 3) {
			return Color.ORANGE;
		}
		if (fila == 4 || fila == 5) {
			return Color.YELLOW;
		}
		if (fila == 6 || fila == 7) {
			return Color.GREEN;
		}
		if (fila == 8 || fila == 9) {
			return Color.CYAN;
		}
		return Color.BLACK;
	}

	//paddle set-up
	private void dibujarPala() {
		double x = darAncho()/2 - PADDLE_WIDTH/2; 
		double y = darAltura() - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
		pala = new SRect (x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
		pala.cambiarRelleno(true);
		agregar(pala);
		agregarMouseListeners();
	}

	//making the mouse track the paddle
	public void mouseMovido(MouseEvent e) {
		if ((e.getX() < darAncho() - PADDLE_WIDTH/2) && (e.getX() > PADDLE_WIDTH/2)) {
			pala.cambiarUbicacion(e.getX() - PADDLE_WIDTH/2, darAltura() - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
		}
	}


	//ball set-up
	private void dibujarPelota() {
		double x = darAncho()/2 - BALL_RADIUS;
		double y = darAltura()/2 - BALL_RADIUS;
		pelota = new SOvalo(x, y, BALL_RADIUS, BALL_RADIUS);
		pelota.cambiarRelleno(true);
		agregar(pelota);
	}

	private void hacerJuego() {
		esperarClic();
		darPelotaVelocidad();
		while (true) {
			moverPelota();
			if (pelota.darY() >= darAltura()) {
				break;
			}
			if(contadorLadrillos == 0) {
				break;
			}
		}
	}



	private void darPelotaVelocidad() {
		vy = 4.0;
		vx = doubleAleatorio(1.0, 3.0);
		if (booleanAleatorio(0.5)) {
			vx = -vx; 
		}

	}

	private void moverPelota() {
		pelota.moverse(vx, vy);
		//check for walls
		//need to get vx and vy at the point closest to 0 or the other edge
		if ((pelota.darX() - vx <= 0 && vx < 0 )|| (pelota.darX() + vx >= (darAncho() - BALL_RADIUS*2) && vx>0)) {
			vx = -vx;
		}
		//We don't need to check for the bottom wall, since the ball can fall through the wall at that point
		if ((pelota.darY() - vy <= 0 && vy < 0 )) {
			vy = -vy;
		}

		//check for other objects
		SObjeto objetoChocando = darObjetoChocando();
		if (objetoChocando == pala) {
			vy = -Math.abs(vy);
		}
		else if (objetoChocando != null) {
			quitar(objetoChocando); 
			contadorLadrillos--;
			vy = -vy;
		}
		pausa (DELAY);
	}


	private SObjeto darObjetoChocando() {

		if((darObjetoA(pelota.darX(), pelota.darY())) != null) {
			return darObjetoA(pelota.darX(), pelota.darY());
		}
		else if (darObjetoA( (pelota.darX() + BALL_RADIUS*2), pelota.darY()) != null ){
			return darObjetoA(pelota.darX() + BALL_RADIUS*2, pelota.darY());
		}
		else if(darObjetoA(pelota.darX(), (pelota.darY() + BALL_RADIUS*2)) != null ){
			return darObjetoA(pelota.darX(), pelota.darY() + BALL_RADIUS*2);
		}
		else if(darObjetoA((pelota.darX() + BALL_RADIUS*2), (pelota.darY() + BALL_RADIUS*2)) != null ){
			return darObjetoA(pelota.darX() + BALL_RADIUS*2, pelota.darY() + BALL_RADIUS*2);
		}
		//need to return null if there are no objects present
		else{
			return null;
		}

	}

	private void imprimirPerdida() {
		SLabel finPartido = new SLabel ("FIN", darAncho()/2, darAltura()/2);
		finPartido.moverse(-finPartido.darAncho()/2, -finPartido.darAltura());
		finPartido.cambiarColor(Color.RED);
		add (finPartido);
	}


	private void imprimirGana() {
		SLabel ganador = new SLabel ("Ganador!!", darAncho()/2, darAltura()/2);
		ganador.moverse(-ganador.darAncho()/2, -ganador.darAltura());
		ganador.cambiarColor(Color.RED);
		add (ganador);
	}
}