import java.awt.Color;
import java.awt.event.MouseEvent;

import espl.*;

public class ReporteroMouse extends EsGraphics {

	public void run() {
		// tu codigo aca
		agregarMouseListeners();
	}
	
	public void mouseMovido(MouseEvento e) {
		// tu codigo aca
		int x = e.darX();
		int y = e.darY();
		imprimir("x: " + x + ", y:" + y);
	}
}