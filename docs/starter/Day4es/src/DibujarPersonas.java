import graphics.EsGraphics;
import graphics.*;
import acm.graphics.*;
import acm.program.*;
import java.awt.Color;

/**
 * Un ejemplo solucionado para mostrarte 
 * como escribir metodos. 
 */
public class DibujarPersonas extends EsGraphics {

	public void run() {
		dibujarPersona(50, 150);
		dibujarPersona(100, 300);
		dibujarPersona(500, 200);
		dibujarPersona(300, 250);
		dibujarPersona(700, 310);
	}

	private void dibujarPersona(int x, int y) {
		SRect cuerpo = new SRect(20, 80);
		cuerpo.cambiarColor(Color.BLACK);
		cuerpo.cambiarRelleno(true);
		add(cuerpo, x - cuerpo.darAncho()/2, y - cuerpo.darAlto());
		
		SRect brazos = new SRect(40, 40);
		brazos.cambiarColor(Color.BLACK);
		brazos.cambiarRelleno(true);
		add(brazos, x - brazos.darAncho()/2, y - 60);
		
		SOvalo cabeza = new SOvalo(40, 40);
		cabeza.cambiarColor(Color.BLUE);
		cabeza.cambiarRelleno(true);
		add(cabeza, x - 20, y - 100);
	}
}