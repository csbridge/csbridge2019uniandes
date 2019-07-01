import java.awt.Color;
import java.awt.event.*;

import espl.*;

public class Estampando extends EsGraphics {

	private static final int TAMANO = 50;
	
	private SRect punteroSello = new SRect(TAMANO, TAMANO);
	
	public void run() {
		punteroSello.cambiarColor(Color.BLUE);
		punteroSello.cambiarRelleno(true);
		agregar(punteroSello);
		agregarMouseListeners();
	}

	public void mouseClickeado(MouseEvento e) {
		int x = e.darX() - TAMANO / 2;
		int y = e.darY() - TAMANO / 2;
		
		SRect r = new SRect(TAMANO, TAMANO);
		r.setFilled(true);
		add(r, x, y);
	}
	
	public void mouseMovido(MouseEvento e) {
		int x = e.darX() - TAMANO / 2;
		int y = e.darY() - TAMANO / 2;
		punteroSello.cambiarUbicacion(x, y);
	}
}
