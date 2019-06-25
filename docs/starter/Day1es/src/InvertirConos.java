/**
 * Programa: Invertir Conos
 * ------------------
 * Invierta todas los conos de manera
 * que, donde antes había un cono, no
 * haya ninguna cono... y donde no haya
 * un cono anteriormente, haya un cono
 */
public class InvertirConos extends EsKarel {
	
	public void run() {
		invertirFila();
		volverAlOeste();
		while(izquierdaDespejada()) {
			girarIzquierda();
			moverse();
			girarDerecha();
			invertirFila();
			volverAlOeste();
		}
	}

	/**
	 * Método: InvertirFila
	 * ---------------------
	 * Invertir una sola fila. Al comienzo, Karel debe
	 * estar orientada hacia el este desde el lado oeste
	 * de la fila. Después de que Karel esté orientado
	 * hacia el este desde el lado este de la misma
	 * fila, se invertirán todos los beepers de la fila.
	 */
	private void invertirFila() {
		while(frenteDespejado()) {
			invertirCono();
			moverse();
		}
		invertirCono();
	}

	/**
	 *&nbsp;Método: Invertir Cono
	 * -----------------------
	 *&nbsp;Invierte la configuración de el cono en
	 * un cuadrado. Si previamente había un cono, se
	 * recoge. Si anteriormente no había cono, se
	 * coloca un cono.
	 */
	private void invertirCono() {
		if(conosPresentes()) {
			recogerCono();
		} else {
			ponerCono();
		}
	}

	/**
	 *&nbsp;Método: Regreso al Oeste
	 * ------------------------
	 *&nbsp;¡Da la vuelta y vuelve a la pared de la que
	 * vienes!
	 */
	private void volverAlOeste() {
		mediaVuelta();
		while(frenteDespejado()) {
			moverse();
		}
		mediaVuelta();
	}

	/** el clásico */
	private void girarDerecha() {
		girarIzquierda();
		girarIzquierda();
		girarIzquierda();
	}
}