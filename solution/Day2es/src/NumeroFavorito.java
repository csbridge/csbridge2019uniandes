
/**
 * Numero Favorito
 * -----
 * Un usuario intenta adivinar tu numero favorito.
 */
public class NumeroFavorito extends EsConsole {

	// cambia esto para que sea tu número favorito
	private static final int NUMERO_FAVORITO = 88;
	
	public void run() {
		setFont("courier-24");
		imprimir("Intenta adivinar mi número favorito (entre 0 y 100)");
		
		int guess = 0;
		while(guess != NUMERO_FAVORITO) {
			guess = leerInt("Adivinar: ");
			if(guess < NUMERO_FAVORITO) {
				imprimir("Demasiado pequena... ");
			} else if(guess > NUMERO_FAVORITO) {
				imprimir("Demasiado grande... ");
			} else {
				imprimir("Bien hecho");
			}
		}
	}

}
