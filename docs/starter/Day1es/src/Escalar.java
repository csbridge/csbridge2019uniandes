
public class Escalar extends EsKarel {
	
	public void run() {
		//WOOT!!!!!
		
		moverse();
		recogerCono();
		girarIzquierda();
		moverse();
		
		// girar a la derecha
		girarDerecha();
		
		moverse();
		ponerCono();
		moverse();
	}
	
	
	private void girarDerecha() {
		// tu codigo aca
		girarIzquierda();
		girarIzquierda();
		girarIzquierda();
	}

}
