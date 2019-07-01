import java.awt.Color;
import java.awt.event.MouseEvent;

import espl.*;

public class ReporteroMouse extends EsGraphics {

	public void run() {
		cambiarFondo(Color.GREEN);
		agregarMouseListeners();
	}
	
	public void mouseMovido(MouseEvento e) {
		int x = e.darX();
		int y = e.darY();
		String out = x + ", " + y;
		imprimir(out);
	}
}
