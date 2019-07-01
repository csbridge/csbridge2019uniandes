import java.awt.Color;
import java.awt.event.MouseEvent;

import espl.*;

public class SeguidorMouse extends EsGraphics {
	
	private static final int TAMANO = 50;

	/* Atributo que deja que los listeners usen la casilla */
	SRect casilla = null;
	
	public void run() {
		casilla = darCasilla();
		agregarMouseListeners();
	}
	
	public void mouseMovido(MouseEvento e) {
		int x = e.darX() - TAMANO / 2;
		int y = e.darY() - TAMANO / 2;
		casilla.cambiarUbicacion(x, y);
	}
	
	private SRect darCasilla() {
		SRect casilla = new SRect(TAMANO, TAMANO);
		casilla.cambiarColor(Color.BLUE);
		casilla.cambiarRelleno(true);
		agregar(casilla);
		return casilla;
	}
}
