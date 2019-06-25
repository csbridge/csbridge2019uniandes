/**
 * Programa: Karel NU
 * -------------------
 * Este programa hace que Karel construya casas,
 * como trabajo para la ONU.
 */
public class KarelNU extends EsKarel {
	
	public void run() {
		while(frenteDespejado()) {
			moverse();
			if(conosPresentes()) {
				construirUnaCasa();
			}
		}
	}

	/**
	 * Metodo: Construir Casa
	 * ----------------------
	 * Construye una sola casa centrada alrededor de la
	 * posición actual de Karel. Puede suponer que hay
	 * un cono presente en el estado de
	 * inicio. Al final del metodo, Karel estara mirando
	 * hacia el este en la esquina inferior derecha de
	 * la casa.
	 */
	private void construirUnaCasa() {
		recogerCono();
		mediaVuelta();
		moverse();
		girarDerecha();
		ponerTres();
		girarDerecha();
		moverse();
		girarDerecha();
		ponerTres();
		girarIzquierda();
		moverse();
		girarIzquierda();
		ponerTres();
		mediaVuelta();
		moverseALaPared();
		girarIzquierda();
	}

	/**
	 * Metodo: Mover a la pared
	 * ------------------------
	 * Avanza hasta que Karel golpee una pared.
	 */
	private void moverseALaPared() {
		while(frenteDespejado()) {
			moverse();
		}
	}

	/**
	 * Metodo: Poner tres
	 * --------------------
	 * Poner tres beepers seguidos y moverse tres veces
	 */
	private void ponerTres() {
		for(int i = 0; i < 3; i++) {
			ponerCono();
			moverse();
		}
	}
	
	/* el clasico */
	private void girarDerecha() {
		girarIzquierda();
		girarIzquierda();
		girarIzquierda();
	}

}