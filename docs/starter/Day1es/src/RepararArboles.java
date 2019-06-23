


public class RepararArboles extends EsKarel {

	public void run() {
		for(int i = 0; i < 4; i++) {
			moverArbol();
			repararArbol();
		}
		
	}

	private void repararArbol() {
		girarIzquierda();
		treparArbol();
		girarDerecha();
		ponerHojas();
		girarDerecha();
		moverseALaPared();
		girarIzquierda();
	}
	
	public void moverArbol() {
		moverseALaPared();
	}
	
	public void moverseALaPared() {
		while(frenteDespejado()) {
			moverse();
		}
	}

	public void treparArbol() {
		while(izquierdaBloqueada()) {
			moverse();
		}
	}
	
	public void ponerHojas() {
		for(int i = 0; i < 4; i++) {
			ponerCono();
			moverse();
			girarIzquierda();
		}
		moverse();
	}

}
