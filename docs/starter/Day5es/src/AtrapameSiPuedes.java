import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import espl.*;
import java.awt.Color;
import java.awt.event.*;

public class AtrapameSiPuedes extends EsGraphics {
	private static final double TAMANO_FURTIVO = 70;
	private static final double TAMANO_DISTRACTOR = 50;
	private static final double N_DISTRACTORES = 20;
	
	private SRect furtivo;
	
	public void run() {
		agregarFurtivo();
		agregarResiduos();
		agregarMouseListeners();
	}
	
	public void mouseMovido(MouseEvento e) {
		int mouseX = e.darX();
		int mouseY = e.darY();
		SObjeto objecto = darObjetoEn(mouseX, mouseY);
		if(objecto == furtivo) {
			furtivoAleatorio();
			furtivo.sendToBack(); // enviarAlFondo
		}
	}
	
	private void agregarFurtivo() {
		furtivo = new SRect(TAMANO_FURTIVO,TAMANO_FURTIVO);
		agregar(furtivo);
		furtivo.cambiarRelleno(true);
		furtivo.cambiarColor(Color.BLUE);
		furtivoAleatorio();
	}

	private void furtivoAleatorio() {
		double x = doubleAleatorio(0, getWidth() - TAMANO_DISTRACTOR);
		double y = doubleAleatorio(0, getHeight() - TAMANO_DISTRACTOR);
		furtivo.cambiarUbicacion(x, y);
	}

	private void agregarResiduos() {
		for (int i = 0; i < N_DISTRACTORES; i++) {
			createSingleDebrisPiece();
		}
	}
	
	/* Crea una sola pieza de escombros y la agrega a 
	 * la pantalla. */
	private void createSingleDebrisPiece() {
		double x = doubleAleatorio(0, getWidth() - TAMANO_DISTRACTOR);
		double y = doubleAleatorio(0, getHeight() - TAMANO_DISTRACTOR);
		
		SRect r = new SRect(x, y, TAMANO_DISTRACTOR, TAMANO_DISTRACTOR);
		r.cambiarRelleno(true);
		add(r);
	}

}
