import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import espl.*;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

public class PelotasQueRebota extends EsGraphics {
	private static final double TAMANO_PELOTA = 20;
	private static final double N_PELOTAS = 20;
	
	// cada pelota tiene un SOvalo, vx, vy
	// hay una lista para los tres.
	private ArrayList<SOvalo> pelotas;
	private ArrayList<Double> pelotasVx;
	private ArrayList<Double> pelotasVy;
	
	public void run() {
		crearPelotas();
		while(true) {
			animaPelotas();
			pausa(10);
		}
	}

	private void animaPelotas() {
		// anima cada pelota
		for(int i = 0; i < N_PELOTAS; i++) {
			SOvalo pelota = pelotas.get(i);
			// prueba si la pelota ha chocado con un pared. 
			if(chocarIzquierdaDerecha(pelota)) {
				pelotasVx.set(i, -pelotasVx.get(i));
			}
			if(chocarArribaAbajo(pelota)) {
				pelotasVy.set(i, -pelotasVy.get(i));
			}
			// mueva la pelota (usa su velocidad)
			pelota.moverse(pelotasVx.get(i), pelotasVy.get(i));
		}
	}

	/* si o no? has la pelota chocade con los paredes 
	 * arriba o abajo? */
	private boolean chocarArribaAbajo(SOvalo pelota) {
		if(pelota.darY() > darAlto() - TAMANO_PELOTA) {
			return true;
		}
		return pelota.darY() < 0;
	}

	/* si o no? has la pelota chocade con los paredes 
	 * izquierda o derecha? */
	private boolean chocarIzquierdaDerecha(SOvalo pelota) {
		if(pelota.darX() > darAncho() - TAMANO_PELOTA) {
			return true;
		}
		return pelota.darX() < 0;
	}

	private void crearPelotas() {
		// crea los listas
		pelotas = new ArrayList<SOvalo>();
		pelotasVx = new ArrayList<Double>();
		pelotasVy = new ArrayList<Double>();
		// agregar cada peloa a las listas
		for(int i = 0; i < N_PELOTAS; i++) {
			// crea una nueva pelota
			SOvalo pelota = creaPelota();
			
			// agregar a la pantalla
			agregar(pelota);
			
			// agregar a las listas
			pelotas.add(pelota);
			double vx = doubleAleatorio(2,6);
			double vy = doubleAleatorio(2,6);
			pelotasVx.add(vx);
			pelotasVy.add(vy);
		}
	}

	private SOvalo creaPelota() {
		double x = doubleAleatorio(0, getWidth() - TAMANO_PELOTA);
		double y = doubleAleatorio(0, getHeight()- TAMANO_PELOTA);
		SOvalo ball = new SOvalo(x, y, TAMANO_PELOTA, TAMANO_PELOTA);
		ball.cambiarRelleno(true);
		ball.cambiarColor(colorAleatorio());
		return ball;
	}

	
}
