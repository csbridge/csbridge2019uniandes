import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

public class BouncingBall extends EsGraphics {
	
	public void run() {
		SOvalo bola = new SOvalo(50, 50);
		bola.cambiarRelleno(true);
		agregar(bola, 0, 0);
		int dx = 1;
		int dy = 1;
		while(true) {
			bola.moverse(dx,  dy);
			
			if(bola.darX() > darAncho()) {
				dx *= -1;
			}
			if(bola.darY() > darAltura()) {
				dy *= -1;
			}
			if(bola.darX() < 0) {
				dx *= -1;
			}
			if(bola.darY() < 0) {
				dy *= -1;
			}
			
			pausa(5);
		}
	}

}
