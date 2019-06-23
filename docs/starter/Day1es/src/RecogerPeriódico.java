import stanford.karel.*;

public class RecogerPeriódico extends EsKarel {
	
	public void run(){
		moverACono();
		recogerCono();
		regresarDeCono();
	}
	
	private void moverACono() {
		moverse();
		moverse();
		girarDerecha();
		moverse();
		girarIzquierda();
		moverse();
	}
	
	private void regresarDeCono() {
		mediaVuelta();
		moverse();
		girarDerecha();
		moverse();
		girarIzquierda();
		moverse();
		moverse();
		mediaVuelta();
	}
}
