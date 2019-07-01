import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import espl.*;

import java.awt.event.*;

public class ResiduosLimpiador extends EsGraphics {
	private static final double MIN_TAMANO_RESIDUO = 50;
	private static final double MAX_TAMANO_RESIDUO = 150;
	private static final double N_RESIDUOS = 100;
	
	public void run() {
		agregarResiduos();
		agregarMouseListeners();
	}
	
	public void mousePulsado(MouseEvento e) {
		SObjeto objecto = darObjetoEn(e.darX(), e.darY());
		if (objecto != null) {
			quitar(objecto);
		}
	}
	
	/***** Codigo para agregar residuos a la pantalla.. *****/
	
	/* Crea escombros y los derrama al azar a la pantalla. */
	private void agregarResiduos() {
		for (int i = 0; i < N_RESIDUOS; i++) {
			createSingleDebrisPiece();
		}
	}
	
	/* Crea una sola pieza de escombros y la agrega a 
	 * la pantalla. */
	private void createSingleDebrisPiece() {
		double width  = doubleAleatorio(MIN_TAMANO_RESIDUO, MAX_TAMANO_RESIDUO);
		double height = doubleAleatorio(MIN_TAMANO_RESIDUO, MAX_TAMANO_RESIDUO);
		double x = doubleAleatorio(0, getWidth() - width);
		double y = doubleAleatorio(0, getHeight() - height);
		
		SOvalo oval = new SOvalo(x, y, width, height);
		oval.setFilled(true);
		oval.setColor(colorAleatorio());
		add(oval);
	}
}
