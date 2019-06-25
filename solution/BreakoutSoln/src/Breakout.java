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
			(WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

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
	private SOvalo bola;

	//adding individual paddle object
	private SRect paleta;

	public void run() {
		for(int i=0; i < NTURNS; i++) {
			setUpGame();
			playGame();
			if(contadorLadrillos == 0) {
				break;
			}
		}
		displayEndGame();
	}

	private void displayEndGame() {
		quitarTodo();
		bola.setVisible(false);
		if(contadorLadrillos > 0) {
			printGameOver();
		} else {
			printWinner();
		}
	}

	private void setUpGame() {
		drawBricks();
		drawPaddle();
		drawBall();
	}

	private void drawBricks() {	
		double cx = getWidth() / 2;
		double cy = getHeight() / 2;
		for(int row = 0; row < NBRICK_ROWS; row++ ) {
			for(int column = 0; column < NBRICKS_PER_ROW; column++) {
				double x = cx - (NBRICKS_PER_ROW*BRICK_WIDTH)/2 - ((NBRICKS_PER_ROW-1)*BRICK_SEP)/2 + column*BRICK_WIDTH + column*BRICK_SEP;
				double y = cy + row * BRICK_HEIGHT + row*BRICK_SEP;
				SRect brick = new SRect( x , y , BRICK_WIDTH , BRICK_HEIGHT );
				agregar(brick);
				brick.darRelleno(true);
				brick.darColor(getBrickColor(row));
			}
		}
	}

	private Color getBrickColor(int row) {
		if (row < 2) {
			return Color.RED;
		}
		if (row == 2 || row == 3) {
			return Color.ORANGE;
		}
		if (row == 4 || row == 5) {
			return Color.YELLOW;
		}
		if (row == 6 || row == 7) {
			return Color.GREEN;
		}
		if (row == 8 || row == 9) {
			return Color.CYAN;
		}
		return Color.BLACK;
	}

	//paddle set-up
	private void drawPaddle() {
		double x = getWidth()/2 - PADDLE_WIDTH/2; 
		double y = getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
		paleta = new SRect (x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
		paleta.setFilled(true);
		add (paleta);
		agregarMouseListeners();
	}

	//making the mouse track the paddle
	public void ratonMovido(MouseEvent e) {
		if ((e.getX() < getWidth() - PADDLE_WIDTH/2) && (e.getX() > PADDLE_WIDTH/2)) {
			paleta.darUbicacion(e.getX() - PADDLE_WIDTH/2, getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
		}
	}


	//ball set-up
	private void drawBall() {
		double x = darAncho()/2 - BALL_RADIUS;
		double y = darAltura()/2 - BALL_RADIUS;
		bola = new SOvalo(x, y, BALL_RADIUS, BALL_RADIUS);
		bola.cambiarRelleno(true);
		add(bola);
	}

	private void playGame() {
		esperarClic();
		getBallVelocity();
		while (true) {
			moveBall();
			if (bola.darY() >= darAltura()) {
				break;
			}
			if(contadorLadrillos == 0) {
				break;
			}
		}
	}



	private void getBallVelocity() {
		vy = 4.0;
		vx = doubleAleatorio(1.0, 3.0);
		if (booleanAleatorio(0.5)) {
			vx = -vx; 
		}

	}

	private void moveBall() {
		bola.move(vx, vy);
		//check for walls
		//need to get vx and vy at the point closest to 0 or the other edge
		if ((bola.getX() - vx <= 0 && vx < 0 )|| (bola.getX() + vx >= (getWidth() - BALL_RADIUS*2) && vx>0)) {
			vx = -vx;
		}
		//We don't need to check for the bottom wall, since the ball can fall through the wall at that point
		if ((bola.getY() - vy <= 0 && vy < 0 )) {
			vy = -vy;
		}

		//check for other objects
		SObjeto collider = getCollidingObject();
		if (collider == paleta) {
			vy = -Math.abs(vy);
		}
		else if (collider != null) {
			quitar(collider); 
			contadorLadrillos--;
			vy = -vy;
		}
		pausa (DELAY);
	}


	private SObjeto getCollidingObject() {

		if((darObjectoA(bola.getX(), bola.getY())) != null) {
			return darObjectoA(bola.getX(), bola.getY());
		}
		else if (darObjectoA( (bola.getX() + BALL_RADIUS*2), bola.getY()) != null ){
			return darObjectoA(bola.getX() + BALL_RADIUS*2, bola.getY());
		}
		else if(darObjectoA(bola.getX(), (bola.getY() + BALL_RADIUS*2)) != null ){
			return darObjectoA(bola.getX(), bola.getY() + BALL_RADIUS*2);
		}
		else if(darObjectoA((bola.getX() + BALL_RADIUS*2), (bola.getY() + BALL_RADIUS*2)) != null ){
			return darObjectoA(bola.getX() + BALL_RADIUS*2, bola.getY() + BALL_RADIUS*2);
		}
		//need to return null if there are no objects present
		else{
			return null;
		}

	}

	private void printGameOver() {
		GLabel gameOver = new GLabel ("Game Over", getWidth()/2, getHeight()/2);
		gameOver.move(-gameOver.getWidth()/2, -gameOver.getHeight());
		gameOver.setColor(Color.RED);
		add (gameOver);
	}


	private void printWinner() {
		GLabel Winner = new GLabel ("Winner!!", getWidth()/2, getHeight()/2);
		Winner.move(-Winner.getWidth()/2, -Winner.getHeight());
		Winner.setColor(Color.RED);
		add (Winner);
	}
}